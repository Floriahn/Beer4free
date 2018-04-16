
public class Factory {

	public IPizza makePizza(String pizza){
		switch (pizza.toLowerCase()) {
		case "mais":
			return new Mais();
		case "tonno":
			return new Tonno();
		case "salami":
			return new Salami();
		default:
			return null;
		}
	}
}
