import java.sql.SQLException;

public class Test {

	static DBManager manager;
	
	public static void main(String[] args) {
		try {
			manager=DBManager.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}