/**
 * Esta clase sirve para representar una variable en el lenguaje final
 */

public class Variable {

    public StringBuilder id;
    public Simbolo sim; // Para las constantes sera el valor y para variables el tipo

    public Variable(){
        id = new StringBuilder();
        sim = new Simbolo();
    }
}
