import java.util.ArrayList;

public class Ordner implements IComponent{

	String name;
	int size;
	
	public Ordner(String name, int size){
		this.name = name;
		this.size = size;
	}
	
	ArrayList<IComponent> files = new ArrayList<IComponent>();

	public void addChild(IComponent file){
		files.add(file);
	}
	
	public ArrayList<IComponent> getChildren(){
		return files;
	}
	
	@Override
	public String getHirarchy(int n) {
		String hir ="";
		
		for(int i=0;i<n;i++){
			hir+="|\t";
		}
		hir += name+"\n";
		for (IComponent x : files){
			hir += x.getHirarchy(n+1);
		}
		return(hir);
	}

	@Override
	public int getSize() {
		int gessize=0;
		for (IComponent x : files) {
			gessize += x.getSize();
		}
		gessize += size;
		return gessize;
	}
}
