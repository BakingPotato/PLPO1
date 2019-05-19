public class Sentencia{

    public StringBuilder valor;

    public Sentencia(){
        valor = new StringBuilder();
    }
    public Sentencia(Simbolo s){ valor = new StringBuilder(s.valor);
    }
}