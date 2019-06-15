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
        for(Simbolo sim: cabecera.simbolos){
            programa += sim.valor;
        }
        programa +=  "\n";
        for(Sentencia sent: declaraciones){
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
            i = 0;
            programa +=  "\n";
        }
        programa +=  "\nvoid main ( void )\n{\n";
        for(Sentencia sent: bloque){
            for(Simbolo sim: sent.simbolos){
                programa += sim.valor;
            }
            programa +=  "\n";
        }
        programa +=  "}";
        return programa;
    }
}
