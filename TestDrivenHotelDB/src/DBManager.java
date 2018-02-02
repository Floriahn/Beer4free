import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	private static DBManager instance=null;
	
	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	static final String DB_URL = "jdbc:postgresql://localhost/TestDrivenHotelDB";
	
	static final String USER = "Testuser";
	static final String PASS = "passwoo";
	
	private Connection conn =null;
	private PreparedStatement stmt = null;
	
	private String insertstring;
	
	private DBManager() throws ClassNotFoundException, SQLException{
		createConnection();
	}
	
	public static DBManager getInstance() throws ClassNotFoundException, SQLException{
		if(instance==null){
			instance = new DBManager();
		}
		return instance;
	}
	
	private void createConnection() throws ClassNotFoundException, SQLException{
		Class.forName(JDBC_DRIVER);
		conn=DriverManager.getConnection(DB_URL, USER, PASS);
	}
	
	public void insertGast(Gast gast){
		insertstring = gast.getInsertString();
		System.out.println(insertstring);
		try {
			stmt = conn.prepareStatement(insertstring);
			stmt.setString(1, gast.getNachname());
			stmt.setDate(2, gast.getGebdat());
			stmt.setString(3, gast.getPlz());
			stmt.setString(4, gast.getLand());
			stmt.setString(5, gast.getHausnmr());
			stmt.setString(6, gast.getNumber());
			stmt.setString(7, gast.getName());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("INSERT EXECUTED");
	}
	
}
