import java.util.ArrayList;

public class Function {

	public ArrayList<VarList> varLists;
	public String type;
	public String name;

	public Function() {
		this.varLists = new ArrayList<>();
	}

	public StringBuilder print() {
		StringBuilder r = new StringBuilder();
		for (VarList vl : this.varLists) {
			for (String v : vl.vars) {
				r.append(vl.tipo).append(" ").append(v).append(", ");
			}
		}
		r.setLength(r.length()-2);
		return r;
	}
}