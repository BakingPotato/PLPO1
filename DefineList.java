import java.util.ArrayList;

/**
 * Esta clase sirve para representar la definicion de constantes que se encontraran
 * en el comienzo del codigo del lenguaje final
 */
public class DefineList {

    public ArrayList<Variable> defines;

    public DefineList(){
        defines = new ArrayList<>();
    }

    public StringBuilder print(){
        StringBuilder toReturn = new StringBuilder();
        for ( Variable d : defines ) {
            toReturn.append("#define ").append(d.id).append(" ").append(d.sim.valor).append("\n");
        }
        return toReturn;
    }
}
