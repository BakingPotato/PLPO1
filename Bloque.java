import java.util.ArrayList;

public class Bloque {

	public ArrayList<Function> dclList;
	public ArrayList<Sentencia> sentList;
	public String id;

	public Bloque () {
		this.dclList = new ArrayList<>();
		this.sentList = new ArrayList<Sentencia>();
	}

	public Bloque (ArrayList dclList, ArrayList sentList) {
		this.dclList = dclList;
		this.sentList = sentList;
	}

}
