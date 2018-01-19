import java.util.ArrayList;

public class Heizung {

	static double heizwert=0;
	static ArrayList<IHeizObserver> observer = new ArrayList<IHeizObserver>();
	
	public static double getHeizWert(){
		return heizwert;
	}
	public static void setHeizWert(double x){
		heizwert=x;
		informAll();
	}
	public void subscribe(IHeizObserver obs){
		observer.add(obs);
	}
	public void unSubscribe(IHeizObserver obs){
		observer.remove(obs);
	}
	private static void informAll(){
		for (IHeizObserver obs : observer) {
			obs.update();
		}
	}
}