import java.util.ArrayList;

public class Funcion {
    Sentencia cabecera;
    ArrayList<Sentencia> declaraciones;
    ArrayList<Sentencia> bloque;
    boolean esFuncion;

    public Funcion(){
        cabecera = new Sentencia();
        declaraciones = new ArrayList<>();
        bloque = new ArrayList<>();
        esFuncion = false;
    }

    public String reestructurar(){
        ArrayList<String> identificadores = new ArrayList<>();
        ArrayList<String> identificadoresP = new ArrayList<>();
        boolean returnAnadido = false;
        int i = 0;
        String programa = new String();
        for(Sentencia sent: declaraciones){
            if(sent.esCierre){
                i--;
            }
            programa = tabs(programa, i);
            for(Simbolo sim: sent.simbolos){
                if(sim.esIdFuncion) { //Si es id de una funcion lo añadimos a la lista antes de imprimirlo
                    identificadores.add(sim.valor);
                    if(sent.esLlamadaVacia){
                        identificadoresP.add(sim.valor);
                    }
                    programa += sim.valor;
                }else if(identificadores.contains(sim.valor) && sim.esIdAsig) { //Si es id de asignacion y esta en la lista de ids ponemos return y activamos el boolean para saltar el "="
                    programa += "return ";
                    returnAnadido = true;
                }else if(identificadoresP.contains(sim.valor) && !sim.esIdAsig) //Si la lista de id de metodos con llamadas vacias lo contiene y no es id de asignacion
                    programa += sim.valor +"()";
                else if(returnAnadido && !sim.esAsignacion && !sim.esPyC)
                    programa += sim.valor;
                else if(!returnAnadido)
                    programa += sim.valor;
            }
            returnAnadido = false;
            programa +=  "\n";
            if(sent.esApertura){
                i++;
            }
        }
        if(!bloque.isEmpty()) {
            programa += "\nvoid main ( void )\n{\n";
            i = 1;
            for (Sentencia sent : bloque) {
                if (sent.esCierre) {
                    i--;
                }
                programa = tabs(programa, i);
                for (Simbolo sim : sent.simbolos) {
                    programa += sim.valor;
                }
                programa += "\n";
                if (sent.esApertura) {
                    i++;
                }
            }
            programa += "}";
        }
        return programa;
    }

    private String tabs(String aux, int cont){
        for(int i = 0; i<cont; i++){
                aux += "\t";
        }
        return aux;
    }
}
