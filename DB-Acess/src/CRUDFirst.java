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
	public static void main(String[] args) {
		
		
		
		while(true){
			System.out.println("Was wollen Sie machen(Create, Read, Update, Delete)");
			String input = scan.next();
			
			switch(input.toLowerCase()){
			case"read":{
				System.out.println("Welche Tabelle wollen Sie ausgeben?:");
			}
			}
		}
	}
}
