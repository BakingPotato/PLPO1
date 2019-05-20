public class Sentencia{

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
                r.append("return ").append(valor);
            else
                r.append(id).append(" = ").append(valor);
        } else
            r.append(id).append(" (").append(valor).append(")");
        return r;
    }
}