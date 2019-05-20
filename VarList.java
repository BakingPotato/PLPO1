import java.util.Deque;
import java.util.ArrayDeque;

public class VarList {

	//public ArrayList<String> vars;
	public Deque<String> vars;
	public String tipo;
	public boolean isDef;
	public boolean isFun;

	public VarList() {
		//this.vars = new ArrayDeque<>();
		this.vars = new ArrayDeque<String>();
	}

	public StringBuilder returnSBFun() {
		StringBuilder r = new StringBuilder();
		for (String v : vars) {
			r.append(tipo).append(" ").append(v).append(", ");
		}
		r.setLength(r.length() - 2).append(" ; ");
		return r;
	}

	public StringBuilder returnSBVar() {
		StringBuilder r = new StringBuilder();
		for (String v : vars) {
			r.append(tipo).append(" ").append(v).append(";\n");
		}
		return r;
	}

	public StringBuilder returnSBDef() {
		StringBuilder r = new StringBuilder();
		for (String v : vars) {
			r.append("#defines ").append(v).append(";\n");
		}
		return r;
	}


}