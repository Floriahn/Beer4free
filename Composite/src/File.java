
public class File implements IComponent{

	String name;
	int size;
	
	public File(String name, int size){
		this.name = name;
		this.size = size;
	}
	
	@Override
	public String getHirarchy(int n) {
		String x="";
		for(int i=0;i<n;i++){
			x+="|\t";
		}
		x+=name+"\n";
		return(x);
	}

	@Override
	public int getSize() {
		return size;
	}
	
	public String getName(){
		return name;
	}

}
