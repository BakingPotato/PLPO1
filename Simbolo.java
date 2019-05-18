public class Simbolo {

    enum TipoSim {
        T_BOOLEAN,
        T_INTEGER,
        T_FLOAT,
        T_STRING
    }

    public TipoSim tipo;
    public StringBuilder valor;

    public Simbolo(){
        valor = new StringBuilder();
    }

}
