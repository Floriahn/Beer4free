
public class Test {

	public static void main(String[] args) {
		
		Pizza piz = new Funghi();
		piz = new PizzaGro�(piz);

		System.out.println(piz.getBeschreibung());
		System.out.println("EUR: "+piz.getPreis()+"�");
	}

}
