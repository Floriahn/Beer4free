
public class Mais implements IPizza{
	private String[] ingreds = new String[4];

	@Override
	public void make() {
		ingreds[0] = "Tomatensauce";
		ingreds[1] = "Oregano";
		ingreds[2] = "K�se";
		ingreds[3] = "Mais";
		System.out.println("Pizza Mais wurde gemacht");
	}

	@Override
	public void getIngreds() {
		for (String string : ingreds) {
			System.out.println(string);
		}
	}

}