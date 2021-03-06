package bibimpab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {

	private static DBManager instance=null;
	
	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	static final String DB_URL = "jdbc:postgresql://localhost/TestDrivenHotelDB";
	
	private static final String READ_GAST_SUR_SQL = "SELECT * FROM gast where nachname like ? order by nachname";
	private static final String READ_ZIMMER_BETTEN_SQL = "SELECT * FROM zimmer where betten = ? order by zid";
	private static final String READ_GAST_ID_SQL ="SELECT * FROM gast where gid = ?";
	private static final String READ_ZIMMER_ID_SQL="SELECT * FROM zimmer where zid = ?";
	private static final String READ_BUCHUNG_ALL_SQL="SELECT * FROM buchung order by von desc";
	private static final String READ_BUCHUNG_GID_SQL="SELECT * FROM buchung where gid=? order by von desc";
	private static final String READ_BUCHUNG_ZID_SQL="SELECT * FROM buchung where zid=? order by von desc";
	
	private static final String CHECK_LOGIN="SELECT passwort FROM logindaten where email =?";
	private static final String READ_GID_MAIL_SQL="select gid from logindaten where email =?";
	private static final String READ_GID_NN_N_SQL="select gid from gast where nachname=? and name =?";
	private static final String INSERT_LOGIN_SQL="insert into logindaten (gid,email,passwort) VALUES (?,?,?);";
	
	private static final String DELETE_GAST_SQL = "DELETE FROM gast WHERE gid=?";
	private static final String DELETE_ZIMMER_SQL = "DELETE FROM zimmer WHERE zid=?";
	private static final String DELETE_BUCHUNG_SQL = "DELETE FROM buchung WHERE buchungsid=?";
	
	private static final String UPDATE_GAST_SQL = "UPDATE gast SET nachname=?, geburtsdatum=?, land=?, name=?, telefonnummer=?, hausnummer=?, plz=? WHERE gid=?";
	private static final String UPDATE_ZIMMER_SQL = "UPDATE zimmer SET betten=?, lage=?, eigenschaft=?, fernseher=?, preispronacht=?, nummer=? WHERE zid=?";
	private static final String UPDATE_BUCHUNG_SQL = "UPDATE buchung SET von=?, bis=?, anz=?, bezahlt=? WHERE buchungsid=?";
	
	static final String USER = "Testuser";
	static final String PASS = "passwoo";
	
//	static final String USER = "postgres";
//	static final String PASS = "password";
	
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
	
	public void insertZimmer(Zimmer zim){
		insertstring = zim.getInsertString();
		System.out.println(insertstring);
		
		try {
			stmt = conn.prepareStatement(insertstring);
			stmt.setInt(1, zim.getBetten());
			stmt.setBoolean(2, zim.isFernseh());
			stmt.setString(3, zim.getLage());
			stmt.setDouble(4, zim.getPreispronacht());
			stmt.setString(5, zim.getNummer());
			if(zim.getEingenschaft()!=null){
				stmt.setString(6, zim.getEingenschaft());
			}
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("INSERT EXECUTED");
	}
	
	public void insertLogin (int id, String mail, String pass) throws SQLException{
		stmt = conn.prepareStatement(INSERT_LOGIN_SQL);
		stmt.setInt(1, id);
		stmt.setString(2, mail);
		stmt.setString(3, pass);
		stmt.executeUpdate();
		stmt.close();
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
			if(gast.getNumber()!=null){
				stmt.setString(6, gast.getNumber());
				System.out.println("number");
			}
			if(gast.getName()!=null){
				stmt.setString(7, gast.getName());
			}
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("INSERT EXECUTED");
	}
	
	public void insertBuchung(Buchung buch){
		insertstring = buch.getInsertString();
		System.out.println(insertstring);
		
		try {
			stmt = conn.prepareStatement(insertstring);
			stmt.setInt(1, Integer.parseInt(buch.getZid()));
			stmt.setInt(2, Integer.parseInt(buch.getGid()));
			stmt.setDate(3, buch.getVon());
			stmt.setDate(4, buch.getBis());
			stmt.setInt(5, buch.getAnz());
			stmt.setBoolean(6, buch.isBezahlt());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("INSERT EXECUTED");
	}
	
	//select * from gast where nachname like 'Griese%'
	
	public ArrayList<Gast> readGastbySurName(String strg) throws SQLException{
		String gs = strg+"%";
		stmt = conn.prepareStatement(READ_GAST_SUR_SQL);
		stmt.setString(1, gs);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Gast> garray = new ArrayList<>();
		while(rs.next()){
			Gast g = new Gast(rs.getString("nachname"), rs.getString("geburtsdatum"), rs.getString("plz"), rs.getString("land"), rs.getString("hausnummer"), rs.getString("telefonnummer"), rs.getString("name"));
			g.setID(rs.getInt("gid")+"");
			garray.add(g);
		}
		stmt.close();
		rs.close();
		return garray;
	}
	
	public Gast readGastbyID (int i) throws SQLException{
		stmt = conn.prepareStatement(READ_GAST_ID_SQL);
		stmt.setInt(1, i);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		Gast g = new Gast(rs.getString("nachname"), rs.getString("geburtsdatum"), rs.getString("plz"), rs.getString("land"), rs.getString("hausnummer"), rs.getString("telefonnummer"), rs.getString("name"));
		g.setID(rs.getInt("gid")+"");
		stmt.close();
		rs.close();
		return g;
	}
	
	public ArrayList<Zimmer> readZimmerbyBetten(int i) throws SQLException{
		stmt = conn.prepareStatement(READ_ZIMMER_BETTEN_SQL);
		stmt.setInt(1, i);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Zimmer> zarray = new ArrayList<>();
		while(rs.next()){
			Zimmer z = new Zimmer(rs.getString("nummer"), rs.getInt("betten"), rs.getBoolean("fernseher"), rs.getString("lage"), rs.getInt("preispronacht"), rs.getString("eigenschaft"));
			z.setId(rs.getInt("zid")+"");
			zarray.add(z);
		}
		stmt.close();
		rs.close();
		return zarray;
	}
	
	public Zimmer readZimmerbyID (int i) throws SQLException{
		stmt = conn.prepareStatement(READ_ZIMMER_ID_SQL);
		stmt.setInt(1, i);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		Zimmer z = new Zimmer(rs.getString("nummer"), rs.getInt("betten"), rs.getBoolean("fernseher"), rs.getString("lage"), rs.getInt("preispronacht"), rs.getString("eigenschaft"));
		z.setId(rs.getInt("zid")+"");
		stmt.close();
		rs.close();
		return z;
	}
	
	public ArrayList<Buchung> readAllBuchung() throws SQLException{
		stmt = conn.prepareStatement(READ_BUCHUNG_ALL_SQL);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Buchung> blist = new ArrayList<Buchung>();
		while(rs.next()){
			Buchung b = new Buchung(readGastbyID(rs.getInt("gid")), readZimmerbyID(rs.getShort("zid")), rs.getString("von"), rs.getString("bis"), rs.getInt("anz"), rs.getBoolean("bezahlt"));
			b.setId(rs.getInt("buchungsid")+"");
			blist.add(b);
		}
		stmt.close();
		rs.close();
		return blist;
	}
	
	public ArrayList<Buchung> readGidBuchung(int i) throws SQLException{
		stmt = conn.prepareStatement(READ_BUCHUNG_GID_SQL);
		stmt.setInt(1, i);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Buchung> blist = new ArrayList<Buchung>();
		while(rs.next()){
			Buchung b = new Buchung(readGastbyID(rs.getInt("gid")), readZimmerbyID(rs.getShort("zid")), rs.getString("von"), rs.getString("bis"), rs.getInt("anz"), rs.getBoolean("bezahlt"));
			b.setId(rs.getInt("buchungsid")+"");
			blist.add(b);
		}
		stmt.close();
		rs.close();
		return blist;
	}
	
	public ArrayList<Buchung> readZidBuchung(int i) throws SQLException{
		stmt = conn.prepareStatement(READ_BUCHUNG_ZID_SQL);
		stmt.setInt(1, i);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Buchung> blist = new ArrayList<Buchung>();
		while(rs.next()){
			Buchung b = new Buchung(readGastbyID(rs.getInt("gid")), readZimmerbyID(rs.getShort("zid")), rs.getString("von"), rs.getString("bis"), rs.getInt("anz"), rs.getBoolean("bezahlt"));
			b.setId(rs.getInt("buchungsid")+"");
			blist.add(b);
		}
		stmt.close();
		rs.close();
		return blist;
	}
	public int readGidbyNNN(String nachname, String name) throws SQLException{
		stmt = conn.prepareStatement(READ_GID_NN_N_SQL);
		stmt.setString(1, nachname);
		stmt.setString(2, name);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			System.out.println("NNN");
			int i = rs.getInt("gid");
			stmt.close();
			rs.close();
			return i;
		}
		System.out.println("noNNN");
		stmt.close();
		rs.close();
		return 0;
	}
	public int readGidbyMail (String mail) throws SQLException{
		stmt = conn.prepareStatement(READ_GID_MAIL_SQL);
		stmt.setString(1, mail);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			int i = rs.getInt("gid"); 
			stmt.close();
			rs.close();
			return i;
			
		}
		return (Integer) null;
	}
	
	public boolean checkPass (String pwd, String mail) throws SQLException{
		stmt = conn.prepareStatement(CHECK_LOGIN);
		stmt.setString(1, mail);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
		if(rs.getString("passwort").equals(pwd)){
			stmt.close();
			rs.close();
			return true;
		}
		stmt.close();
		rs.close();
		return false;
		}
		stmt.close();
		rs.close();
		return false;
	}
	public void deleteGast(int id) throws SQLException{
		stmt = conn.prepareStatement(DELETE_GAST_SQL);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void deleteZimmer(int id) throws SQLException{
		stmt = conn.prepareStatement(DELETE_ZIMMER_SQL);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void deleteBuchung(int id) throws SQLException{
		stmt = conn.prepareStatement(DELETE_BUCHUNG_SQL);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void updateGast(Gast gast){
		try {
			stmt = conn.prepareStatement(UPDATE_GAST_SQL);
			stmt.setString(1, gast.getNachname());
			stmt.setDate(2, gast.getGebdat());
			stmt.setString(3, gast.getLand());
			stmt.setString(4, gast.getName());
			stmt.setString(5, gast.getNumber());
			stmt.setString(6, gast.getHausnmr());
			stmt.setString(7, gast.getPlz());
			stmt.setInt(8, Integer.parseInt(gast.getId()));
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void updateZimmer(Zimmer zimmer){
		try {
			stmt = conn.prepareStatement(UPDATE_ZIMMER_SQL);
			stmt.setInt(1, zimmer.getBetten());
			stmt.setString(2, zimmer.getLage());
			stmt.setString(3, zimmer.getEingenschaft());
			stmt.setBoolean(4, zimmer.isFernseh());
			stmt.setDouble(5, zimmer.getPreispronacht());
			stmt.setString(6, zimmer.getNummer());
			stmt.setInt(7, Integer.parseInt(zimmer.getId()));
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateBuchung(Buchung b){
		try {
			stmt = conn.prepareStatement(UPDATE_BUCHUNG_SQL);
			stmt.setDate(1, b.getVon());
			stmt.setDate(2, b.getBis());
			stmt.setInt(3, b.getAnz());
			stmt.setBoolean(4, b.isBezahlt());
			stmt.setInt(5, Integer.parseInt(b.getId()));
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}