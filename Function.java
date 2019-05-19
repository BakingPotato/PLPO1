import java.util.ArrayList;

public class Function {

	//public ArrayList<VarList> varLists;
	public Deque<VarList> varLists;
	public String type;
	public String name;
	public Bloque bloque;

	public Function() {
		//this.varLists = new ArrayList<>();
		this.varLists = new ArrayDeque<>();
		this.bloque = new Bloque();
	}

	public StringBuilder print() {
		StringBuilder r = new StringBuilder();
		/*for (VarList vl : this.varLists) {
			for (String v : vl.vars) {
				r.append(vl.tipo).append(" ").append(v).append(", ");
			}
		}*/
		for (VarList vl : this.varLists) {
			for (String v : vl.vars) {
				r.append(vl.tipo).append(" ").append(v).append(", ");
			}
		}
		r.setLength(r.length()-2);
		return r;
	}

	public StringBuilder returnSB() {
		StringBuilder r = new StringBuilder();
		r.append(this.type).append(" ").append(this.name);
		if (varLists.size() > 0) {
			r.append(" ( ");
			while (varLists.size() > 0) {
				r.append(varLists.pop());
			}
			r.append(" ) ");
		} else {
			r.append(" ( void ) ");
		}
	}
}