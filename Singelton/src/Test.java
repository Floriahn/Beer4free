
public class Test {

	public static void main(String[] args) {
		Singelton eins = Singelton.getInstance();
		Singelton zwei = Singelton.getInstance();
		
		eins.setShout("Hallo");
		zwei.shout();
	}

}
