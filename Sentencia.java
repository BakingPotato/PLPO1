public class Sentencia{

    public StringBuilder valor;
    public String id;
    public boolean isAsig;

    public Sentencia(){
        valor = new StringBuilder();
    }

    public Sentencia(String id, StringBuilder valor, boolean isAsig) {
        this.id = id;
        this.valor = valor;
        this.isAsig = isAsig;
    }

    public Sentencia(StringBuilder valor) {
        this.valor = valor;
    }
}