import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

public class UnitTests {

	@Test
	public void verbindung(){
		try {
			DBManager manager = DBManager.getInstance();
			assertNotEquals(manager, null);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void insertGast(){
		try {
			DBManager manager = DBManager.getInstance();
			Gast testg = new Gast("Friedels", "1998-11-08", "6561", "Oesterreich", "Oberer Kw. 4", "061/34", "Benni");
			
			manager.insertGast(testg);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void insertZimmer() {
			try {
				DBManager manager = DBManager.getInstance();
				Zimmer testz = new Zimmer("104B", 3, true, "S�dseite", 50, "Parkettboden");
				
				manager.insertZimmer(testz);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void readGast(){
		try {
			DBManager manager = DBManager.getInstance();
			ArrayList<Gast> gasta = new ArrayList<>();
			gasta=manager.readGastbySurName("Griese");
			
			System.out.println(gasta.get(0).getName());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void readZimmer(){
		try {
			DBManager manager = DBManager.getInstance();
			ArrayList<Zimmer> zimmera = new ArrayList<>();
			zimmera=manager.readZimmerbyBetten(3);
			
			System.out.println(zimmera.get(0).getLage());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deleteGast() {
		try {
			DBManager manager = DBManager.getInstance();
			
			manager.deleteGast(36);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteZimmer() {
		try {
			DBManager manager = DBManager.getInstance();
			
			manager.deleteZimmer(7);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateGast() {
		try {
			DBManager manager = DBManager.getInstance();
			
			ArrayList<Gast> gist = new ArrayList<>();
			gist=manager.readGastbySurName("Griesebner");
			
//			System.out.println("Test");
//			System.out.println(gist.get(0).getName());
//			
			gist.get(0).setName("flirian");
			manager.updateGast(gist.get(0));
//			
//			gist = manager.readGastbySurName("Griesebner");
//			
//			System.out.println("After:");
//			System.out.println(gist.get(0).getName());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateZimmer() {
		try {
			DBManager manager = DBManager.getInstance();
			
			ArrayList<Zimmer> zist = new ArrayList<>();
			zist=manager.readZimmerbyBetten(3);
			
//			System.out.println("Test");
//			System.out.println(zist.get(0).getNummer());
//			
			zist.get(0).setNummer("123KAPPA");
			manager.updateZimmer(zist.get(0));
//			
//			zist = manager.readZimmerbyBetten(3);
//			
//			System.out.println("After:");
//			System.out.println(zist.get(0).getNummer());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void insertBuchung(){
		try {
			DBManager manager = DBManager.getInstance();
			
			Gast g = manager.readGastbyID(15);
			Zimmer z = manager.readZimmerbyID(5);
			Buchung b = new Buchung(g, z, "2018-03-01", "2018-03-11", 3, false);
			
			manager.insertBuchung(b);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteBuchung(){
		try {
			DBManager manager = DBManager.getInstance();
			
			manager.deleteBuchung(3);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}