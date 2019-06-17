import java.util.ArrayList;
import java.util.List;

public class Sentencia{
    public List<Simbolo> simbolos;
    public List<Sentencia> sentList;
    public boolean esFuncion, esLlamadaVacia, esControlFlujo, esAsignacion, esVacia, esApertura, esCierre;

    public Sentencia() {
        this.sentList = new ArrayList<>();
        this.simbolos = new ArrayList<>();
    }
}