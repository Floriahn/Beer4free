
public class Figur {
	int posX;
	int posZ;
	public Figur() {
		this.posX = 0;
		this.posZ = 0;
	}
	
	public void vor(int meter) {
		this.posX += meter;
	}
	public void hoeher(int meter) {
	this.posZ += meter;
	}
}
