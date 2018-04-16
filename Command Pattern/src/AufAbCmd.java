
public class AufAbCmd implements ICommand{
	private Figur f;
	private int meter;
	
	@Override
	public void doIt() {
		f.hoeher(meter);
	}

	@Override
	public void undoIt() {
		f.hoeher(meter);
	}
	
	public AufAbCmd(Figur f, int meter) {
		this.f = f;
		this.meter = meter;
	}
}
