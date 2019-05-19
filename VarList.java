import java.util.Deque;

public class VarList {

	//public ArrayList<String> vars;
	public Deque<String> vars;
	public String tipo;

	public VarList() {
		//this.vars = new ArrayDeque<>();
		this.vars = new ArrayDeque<String>();
	}
}