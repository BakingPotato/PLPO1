public class TError {
    String lexema,tipo,descripcion;
    int linea,columna;

    public TError(String lex, int lin, int col, String tip,String desc){
        lexema = lex;
        linea = lin;
        columna = col;
        tipo = tip;
        descripcion = desc;
    }

}
