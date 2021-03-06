import java.sql.*;
import java.util.Scanner;
public class CRUDFirst {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "org.postgresql.Driver";  
	   static final String DB_URL = "jdbc:postgresql://localhost/dbp";

	   //  Database credentials
	   static final String USER = "Testuser";
	   static final String PASS = "passwoo";
	   
	   static Scanner scan = new Scanner(System.in);
	   
	   static Connection conn = null;
	   static Statement stmt = null;
	   
	   static boolean verbindung=false;
	   
	   private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS person (id SERIAL, first character varying not null, last character varying not null, age int)";
	   private static final String READ_TABLE_SQL = "SELECT id, first, last, age FROM person";
	   private static final String CREATE_DATA_SQL = "INSERT INTO person (first, last, age) VALUES(?, ?, ?)";
	   private static final String DELETE_DATA_SQL = "DELETE FROM person WHERE id=?";
	   private static final String UPDATE_DATA_SQL = "UPDATE person SET first=?, last=?, age=? WHERE id=?";
	   
	public static void main(String[] args) {
		   
		
		
		while(true){
			System.out.println("Was wollen Sie machen?(/help f�r Hilfe)");
			String input = scan.next();
			
			if(!verbindung&&!input.toLowerCase().equals("verbinden")&&!input.toLowerCase().equals("/help")){
				System.out.println("Es besteht noch keine Verbindung");
				continue;
			}
			
			switch(input.toLowerCase()){
			case"read":{
				try {
					ResultSet rs = stmt.executeQuery(READ_TABLE_SQL);
					//STEP 5: Extract data from result set
				      while(rs.next()){
				         //Retrieve by column name
				    	 int id = rs.getInt("id");
				         String first = rs.getString("first");
				         String last = rs.getString("last");
				         int age = rs.getInt("age");

				         //Display values
				         System.out.print("ID: " + id);
				         System.out.print(", First: " + first);
				         System.out.print(", Last: " + last);
				         System.out.println(", Age: " + age);
				      }
				      rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			case"create":{
				PreparedStatement stm;
				try {
					stm = conn.prepareStatement(CREATE_DATA_SQL);
					System.out.println("Vorname:");
					stm.setString(1, scan.next());
					System.out.println("Name:");
					stm.setString(2, scan.next());
					System.out.println("Alter:");
					stm.setInt(3, scan.nextInt());
					stm.executeUpdate();
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				continue;
			}
			case"update":{
				PreparedStatement stm;
				try {
					stm = conn.prepareStatement(UPDATE_DATA_SQL);
					System.out.println("ID:");
					stm.setInt(4, scan.nextInt());
					System.out.println("neuer Vorname:");
					stm.setString(1, scan.next());
					System.out.println("neuer Name:");
					stm.setString(2, scan.next());
					System.out.println("neues Alter:");
					stm.setInt(3, scan.nextInt());
					
					stm.executeUpdate();
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			case"delete":{
				PreparedStatement stm;
				try {
					stm = conn.prepareStatement(DELETE_DATA_SQL);
					System.out.println("ID:");
					stm.setInt(1, scan.nextInt());
					stm.executeUpdate();
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			case"/help":{
				System.out.println("Befehle: Create, Read, Update, Delete, Verbinden, Trennen");
				continue;
			}
			case"verbinden":{
				try {
					conn = getConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				verbindung=true;
				//tabelle wird hier erstellt, da create f�r datens�tze dient und erst eine Verbindung bestehen
				//muss um eine Tabelle zu erstellen. F�r ausf�hrlichere Anwendungsf�lle anpassen!
				try {
					stmt = conn.createStatement();
					stmt.execute(CREATE_TABLE_SQL);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			case"trennen":{
				try {
					conn.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Auf Wiedersehen!");
				verbindung=false;
				continue;
			}
			}
			
			System.out.println("Falsche Eingabe!");
			
		}
	}
	
	
	private static Connection getConnection() throws SQLException{
		//STEP 2: Register JDBC driver
    	try {
			Class.forName(JDBC_DRIVER);
			//STEP 3: Open a connection
		    System.out.println("Connecting to database...");
		    return DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
