
public class Test {

	public static void main(String[] args) {
		
		Ordner überordner = new Ordner("schule", 1);
		File d = new File("deutsch", 15);
		File m = new File("mathe", 15);
		File e = new File("englisch", 15);
		
		Ordner abgaben = new Ordner("abgaben", 7);
		File abg1 = new File("abgabe_01", 24);
		File abg2 = new File("AA02_xY", 56);
		
		Ordner josef = new Ordner("joesf", 56);
		File c = new File("Joe", 14);
		File x = new File("is", 65);
		File y = new File("the_best", 999);
		
		überordner.addChild(d);
		überordner.addChild(m);
		
		josef.addChild(c);
		josef.addChild(x);
		josef.addChild(y);
		
		abgaben.addChild(abg1);
		abgaben.addChild(abg2);
		abgaben.addChild(josef);
		überordner.addChild(abgaben);
		
		überordner.addChild(e);

		
		System.out.println("Gesamtsize: "+überordner.getSize());
		System.out.println(überordner.getHirarchy(0));
		System.out.println("");
		System.out.println(abgaben.getHirarchy(0));
	}

}
