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
        String programa = new String();
        String identificador = new String(); //ID de la funcion actual
        ArrayList<String> identificadores = new ArrayList<>(); //Metodos sin atributos
        boolean returnAnadido = false;
        int i = 0;

        for(Sentencia sent: declaraciones){
            if(sent.esCierre){
                i--;
            }
            programa = tabs(programa, i);
            for(Simbolo sim: sent.simbolos){
                if(sim.esIdFuncion) { //Si es id de una funcion lo añadimos a la lista antes de imprimirlo
                    identificador = sim.valor;
                    if(sent.esLlamadaVacia){
                        identificadores.add(sim.valor);
                    }
                    programa += sim.valor;
                }else if(identificador.equals(sim.valor) && sim.esIdAsig) { //Si es id de asignacion y esta en la lista de ids ponemos return y activamos el boolean para saltar el "="
                    programa += "return ";
                    returnAnadido = true;
                }else if(identificadores.contains(sim.valor) && !sim.esIdAsig) //Si la lista de id de metodos con llamadas vacias lo contiene y no es id de asignacion
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
                    if(identificadores.contains(sim.valor) && !sim.esIdAsig) //Si la lista de id de metodos con llamadas vacias lo contiene y no es id de asignacion
                        programa += sim.valor +"()";
                    else
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
