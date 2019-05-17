import java.util.ArrayList;

/**
 * Esta clase sirve para representar una funcion en el lenguaje final
 */
public class Funcion {

    public String tipo; // Tipo que devuelve la funcion
    public String name; // Nombre de la funcion
    public ArrayList<Variable> paramList; // Lista de parametros de la funcion

    /*  Faltan las sentencias y lo que se haga con ellas
        Hay que hacer una clase para las sentencias y para más cosas si hacen falta
        son casi las dos y hace como una hora que me he empezado a enterar de qué hay que hacer jejej
        para los terminales complejos de la gramatica del lenguaje final hay que hacer clases como
        las pocas que he hecho lo siento chicos os quiero el domingo por la noche me vuelvo a poner
     */

    public Funcion(){
        paramList = new ArrayList<>();
    }

}
