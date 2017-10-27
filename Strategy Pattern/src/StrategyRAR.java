import java.util.ArrayList;

public class StrategyRAR implements IStrategy{

	@Override
	public void compress(ArrayList<String> files) {
		System.out.println("RAR Compression");
	}

}
