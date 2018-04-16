
public class PizzaMitnehmen extends Decorator{

	public PizzaMitnehmen(Pizza pizza) {
		super.pizza=pizza;
	}
	
	public String getBeschreibung(){
		return this.pizza.beschreibung + ", zum Mitnehmen";
	}
	
	public double getPreis() {
		return this.pizza.getPreis() + 0;
	}
}