import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Function {

	//public ArrayList<VarList> varLists;
	public ArrayList<VarList> varLists;
	public String type;
	public String name;
	public Bloque bloque;

	public Function() {
		//this.varLists = new ArrayList<>();
		this.varLists = new ArrayList<>();
		this.bloque = new Bloque();
	}

	/*public StringBuilder print() {
		StringBuilder r = new StringBuilder();
		*//*for (VarList vl : this.varLists) {
			for (String v : vl.vars) {
				r.append(vl.tipo).append(" ").append(v).append(", ");
			}
		}*//*
		for (VarList vl : this.varLists) {
			for (String v : vl.vars) {
				r.append(vl.tipo).append(" ").append(v).append(", ");
			}
		}
		r.setLength(r.length()-2);
		return r;
	}*/

	public StringBuilder returnSB() {
		StringBuilder r = new StringBuilder();

		ArrayList<VarList> toRemove = new ArrayList<>();
		// primero tiene que imprimir los define
		for (VarList vl : varLists) {
			if (vl.isDef) {
				r.append(vl.returnSBDef());
				toRemove.add(vl);
			}
		}

		varLists.removeAll(toRemove);

		// luego los var
		for (VarList vl : varLists) {
			if (this.type == null) {
				r.append(vl.returnSBVar());
				toRemove.add(vl);
			}
		}

		// despues las funciones
		r.append(this.type).append(" ").append(this.name).append(" ( ");
		StringBuilder params = new StringBuilder();
		for (VarList vl : varLists) {
			if (vl.isFun) {
				params.append(vl.returnSBFun());
				varLists.remove(vl);
			}
		}
		if (params.length() != 0)
			r.append(params).append(" ) ");
		else
			r.append("void )");
		// hasta aqui la cabecera
		// ahora el bloque
		if (name == null || type.equals("void")) {
			r.append(bloque.returnSB());
		} else {
			r.append(bloque.returnSB(name));
		}
		return r;

		// quedan las declaraciones de variables dentro de varLists

		/*if (this.isDef) {
			//Deque<String> vars = this.varLists.pop().vars;

			return this.;
		} else if (this.type == null) {
			if (varLists.size() > 0) {
				while (varLists.size() > 0) {

					Deque<String> vars = varLists.peek().vars;
					String tipo = varLists.pop().tipo;
					if (!vars.isEmpty()) {
						while (vars.size() > 0) {
							r.append(tipo).append(" ").append(vars.pop()).append(";\n");
						}
					}
				}
				r.setLength(r.length() - 2);
				r.append(" )\n{");
			}
			return r;
		} else {
			r.append(this.type).append(" ").append(this.name);
			if (varLists.size() > 0) {
				r.append(" ( ");
				while (varLists.size() > 0) {

					Deque<String> vars = varLists.peek().vars;
					String tipo = varLists.pop().tipo;
					if(!vars.isEmpty()) {
						while(vars.size() > 0) {
							r.append(tipo).append(" ").append(vars.pop()).append(", ");
						}
					}
				}
				r.setLength(r.length()-2);
				r.append(" )\n{");
			} else {
				r.append(" ( void )\n{");
			}
			r.append(bloque.returnSB());
			r.append("\n}");
			return r;
		}*/
	}
}