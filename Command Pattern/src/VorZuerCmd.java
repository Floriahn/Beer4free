
public class VorZuerCmd implements ICommand{
	private Figur f;
	private int meter;
	
	@Override
	public void doIt() {
		f.vor(meter);
	}

	@Override
	public void undoIt() {
		f.vor(-meter);
	}
	
	public VorZuerCmd(Figur f, int meter) {
		this.f = f;
		this.meter = meter;
	}

}
