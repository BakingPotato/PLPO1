public class Simbolo {

    enum TipoSim {
        T_BOOLEAN,
        T_INTEGER,
        T_FLOAT,
        T_STRING
    }

    public TipoSim tipo_enum;
    public String valor, valor2;
    public boolean esId, esIdAsig, esIdFuncion, esPyC, esDosP, esAsignacion, esUltimo;

    public Simbolo(){
        valor = new String();
        valor2 = new String();
    }

    public Simbolo(String valor){
        this.valor = valor;
        valor2 = new String();
    }
}
