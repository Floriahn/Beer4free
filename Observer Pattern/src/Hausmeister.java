
public class Hausmeister implements IHeizObserver{

	
	public void update(){
		System.out.println(this.toString()+": "+Heizung.getHeizWert());
	}
}
