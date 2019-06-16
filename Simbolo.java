public class Simbolo {

    enum TipoSim {
        T_BOOLEAN,
        T_INTEGER,
        T_FLOAT,
        T_STRING
    }

    public TipoSim tipo_enum;
    public String valor, valor2; //id, operacion, operacionC, operacionL, negacion, parentesis, tipo, coma, PyC, asignacion;
    public boolean esId, esIdAsig, esIdFuncion, esPyC, esDosP, esAsignacion;

    public Simbolo(){
        /*id = new String();  operacion = new String();
        operacionC = new String();  operacionL = new String(); negacion = new String();
        parentesis = new String();  tipo = new String();
        coma = new String(); PyC = new String();    asignacion = new String();*/
        valor = new String();
        valor2 = new String();

        esId = false; esIdAsig = false; esIdFuncion = false;
        esPyC = false; esDosP = false; esAsignacion = false;
    }

    public Simbolo(String valor){
        this.valor = valor;
        valor2 = new String();
        esId = false; esIdAsig = false; esIdFuncion = false;
        esPyC = false; esDosP = false; esAsignacion = false;
    }
}
