import java_cup.runtime.*
%%

%class AnalizadorLexico
%unicode
%line
%column
%cup
%state STRING


%{
      StringBuffer string = new StringBuffer();

      private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
      }
      private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
      }
%}
/* macros */


letra = [a-zA-Z]
signo = [+-]
digitos = [0-9]+
real = {digitos}"."{digitos}
StringCharacter = [^\r\n\'\\]
SingleLineComment = "{" [^.] "}"  // No se si estos dos estan bien
MultipleLineComment = "(*" [^"*)"] "*)"

%%

/* Simbolos terminales sencillos */

"="			{ return new symbol(sym.igual); }
"+"			{ return new symbol(sym.op_mas); }
"-"			{ return new symbol(sym.op_men); }
"*"			{ return new symbol(sym.op_mul); }
","			{ return new symbol(sym.coma); }
"."			{ return new symbol(sym.punto); }
":"			{ return new symbol(sym.dos_puntos); }
";"			{ return new symbol(sym.punto_coma); }
":="        { return new symbol(sym.dos_p_igual); }
"("         { return new symbol(sym.ab_parentesis); }
")"         { return new symbol(sym.cr_parentesis); }
"program"   { return new symbol(sym.program); }
"begin"     { return new symbol(sym.begin); }
"end"       { return new symbol(sym.end); }
"const"     { return new symbol(sym.const_); }
"var"       { return new symbol(sym.var); }
"procedure" { return new symbol(sym.procedure); }
"function"  { return new symbol(sym.function); }
"integer"   { return new symbol(sym.integer); }
"real"      { return new symbol(sym.real); }
"div"       { return new symbol(sym.div); }    
"mod"       { return new symbol(sym.mod); }




/* no se de expr regulares jeje revisen */
{letra}[a-zA-Z0-9_]+	{ return symbol(sym.identifier); }

{signo}?{digitos}		{ return symbol(sym.numeric_integer_const); }

{signo}? ( {real} | {digitos}[eE]{signo}?{digitos} | {real}[eE]{signo}?{digitos} )
	{ return symbol(sym.numeric_real_const); }

"'"   { yybegin(STRING); string.setLength(0); }

	
<STRING> {
    
    /* Para que aparezca una comilla simple como contenido debe ir precedida de otra */
    "''"    { string.append('''); }  //Esto esta bien?
    
    "'"     { yybegin(YYINITIAL); return symbol(string_const, string.toString()); }
    
    {StringCharacter}+  { string.append( yytext() );}
    
    /* Error fin de linea (preguntar si hace falta) */
    {LineTerminator} { throw new RuntimeException("Error lexico: salto de linea detectado en la constante literal de la linea " ++ (yyline+1) + " y columna " + (yycolumn+1)); }
    
}
    

/* errorfallback */
. | \n 	{ throw new RuntimeException("Error lexico: caracter no reconocido <" + yytext() + "> en la linea " + (yyline+1) + " y columna " + (yycolumn+1)); }

<<EOF>>     {return symbol(EOF);}  // Esto lo copie del example no se que es xd
