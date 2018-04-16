import java.util.Stack;

public class CommandRecorder {

	Stack<ICommand> mainStack = new Stack<>();
	Stack<ICommand> secStack = new Stack<>();
	
	public void undoSchritt(){
		mainStack.peek().undoIt();
		secStack.add(mainStack.pop());
	}
	public void redoSchritt(){
		secStack.peek().doIt();
		mainStack.add(secStack.pop());
	}
	public void ausführen(ICommand c){
		mainStack.add(c);
		c.doIt();
	}
}
