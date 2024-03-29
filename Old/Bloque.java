import java.util.ArrayList;
import java.util.Deque;

public class Bloque {

	public boolean isMain;
	public ArrayList<Function> dclList;
	public ArrayList<Sentencia> sentList;
	public String id;
	public boolean isMain;

	public Bloque () {
		this.dclList = new ArrayList<>();
		this.sentList = new ArrayList<Sentencia>();
	}

	public Bloque (ArrayList dclList, ArrayList sentList) {
		this.isMain = false;
		this.dclList = dclList;
		this.sentList = sentList;
	}

	public StringBuilder returnSB() {
		StringBuilder r = new StringBuilder("\n{\n");


		// print declaraciones
		for (Function f : dclList) {
			r.append(f.returnSB());
		}

		// print sentencias
		if (this.isMain)
			r.append("\nvoid main (void)\n{\n");
		for (Sentencia s : sentList) {
			r.append(s.returnSB());
		}
		return r.append("\n}\n");
	}

	public StringBuilder returnSB(String idGlobal) {
		StringBuilder r = new StringBuilder("\n{\n");

		// print declaraciones
		for (Function f : dclList) {
			r.append(f.returnSB());
		}
		/*for (Function f : dclList) {
			if (f.isDef) {
				Deque<String> vars = f.varLists.pop().vars;
				while (!vars.isEmpty()) {
					r.append("#defines ").append(vars.pop()).append("\n");
				}
			} else {
				r.append(f.returnSB());
			}
		}*/

		// print sentencias
		for (Sentencia s : sentList) {
			r.append(s.returnSB(idGlobal));
		}
		/*for (Sentencia s : sentList) {
			if (s.isAsig) {
				if (s.id.equals(this.id))
					r.append("return ").append(s.valor);
				else
					r.append(s.id).append(" = ").append(s.valor);
			} else {
				r.append(s.id).append(" (").append(s.valor);
			}
		}*/
		return r.append("\n}\n");
	}

}
