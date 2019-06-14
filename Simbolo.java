public class Simbolo {

    enum TipoSim {
        T_BOOLEAN,
        T_INTEGER,
        T_FLOAT,
        T_STRING
    }

    public TipoSim tipo_enum;
    public String valor; //id, operacion, operacionC, operacionL, negacion, parentesis, tipo, coma, PyC, asignacion;
    public boolean esId, esOperacion, esOperacionC, esOperacionL, esNegacion, esParentesis, esTipo, esComa, esPyC, esAsignacion;

    public Simbolo(){
        /*id = new String();  operacion = new String();
        operacionC = new String();  operacionL = new String(); negacion = new String();
        parentesis = new String();  tipo = new String();
        coma = new String(); PyC = new String();    asignacion = new String();*/
        valor = new String();

        esId = false;   esOperacion = false;
        esOperacionC = false;   esOperacionL = false; esNegacion = false;
        esParentesis = false;   esTipo = false;
        esComa = false; esPyC = false;  esAsignacion = false;
    }
}
