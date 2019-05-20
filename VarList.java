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
		if (!vars.isEmpty())
			r.setLength(r.length() - 2);
		r.append(" ; ");
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
			r.append("#define ").append(v).append(";\n");
		}
		return r;
	}


}