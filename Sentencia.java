public class Sentencia{

    public boolean isMain;
    public StringBuilder valor;
    public StringBuilder id;
    public boolean isAsig;

    public Sentencia(){
        valor = new StringBuilder();
    }

    public Sentencia(StringBuilder id, StringBuilder valor, boolean isAsig) {
        this.id = id;
        this.valor = valor;
        this.isAsig = isAsig;
    }

    public Sentencia(StringBuilder valor) {
        this.valor = valor;
    }

    public StringBuilder returnSB(String idGlobal) {
        StringBuilder r = new StringBuilder();
        if (isAsig) {
            if (id.equals(idGlobal))
                r.append("return ").append(valor).append("\n");
            else
                r.append(id).append(" = ").append(valor).append("\n");
        } else
            r.append(id).append(" (").append(valor).append(");\n");
        return r;
    }

    public StringBuilder returnSB() {
        StringBuilder r = new StringBuilder();
        if (isAsig)
            r.append(id).append(" = ").append(valor).append("\n");
        else
            r.append(id).append(" (").append(valor).append(");\n");
        return r;
    }
}