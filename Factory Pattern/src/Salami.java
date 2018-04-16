
public class Salami implements IPizza{
	private String[] ingreds = new String[4];

	@Override
	public void make() {
		ingreds[0] = "Tomatensauce";
		ingreds[1] = "Oregano";
		ingreds[2] = "Käse";
		ingreds[3] = "Salami";
		System.out.println("Pizza Salami wurde gemacht");
	}

	@Override
	public void getIngreds() {
		for (String string : ingreds) {
			System.out.println(string);
		}
	}
}
