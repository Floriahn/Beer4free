
public class Singelton {
	private static Singelton instance = null;
	private Singelton(){}
	
	String shout="";
	
	public static Singelton getInstance(){
		if(instance==null){
			instance=new Singelton();
			System.out.println("Singleton erstellt");
		}
		return instance;
	}
	
	public void setShout(String x){
		shout=x;
	}
	public void shout(){
		System.out.println(shout+"!");
	}
}
