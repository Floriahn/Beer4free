import java.util.ArrayList;

public class StrategyZIP implements IStrategy{

	@Override
	public void compress(ArrayList<String> files) {
		System.out.println("ZIP Compression");
		
	}

}
