import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		//Erzeugen des Context
		StrategyContext ctx = new StrategyContext();
		
		//Setzen der Strategy
		ctx.setStrategy(new StrategyRAR());
		
		//Daten erzeguen
		ArrayList<String> list = new ArrayList<String>();
		list.add("file.txt");
		
		//ausf�hren der gesetzten Strategie
		ctx.exeuteStrategy(list);
	}

}
