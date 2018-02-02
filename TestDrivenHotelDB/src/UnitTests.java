import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

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
			Gast testg = new Gast("Griesebner", "08-11-1998", "6561", "Oesterreich", "Oberer Kw. 4", "0676/123", "Florian");
			
			manager.insertGast(testg);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
