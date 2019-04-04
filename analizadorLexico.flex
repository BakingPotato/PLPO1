import java_cup.runtime.*;
import java_cup.sym;

%%

%class AnalizadorLexico
%implements sym
%unicode
%line
%column
%cup

%xstate STRING

/* Raw Java code */
%{
      StringBuilder string = new StringBuilder();

      private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
      }
      private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
      }
%}

/* Macros */

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
Alphabet = [a-z|A-Z]
Digit = [0-9]
Digits = {Digit}+
Underscore = "_"
Sign = [+-]
Exp = "e"|"E"

Identifier = ({Alphabet} | {Digit} | {Underscore})+

Numeric_real_fixed_point_const = {Digits} "." {Digits}
Numeric_real_exponential_const = {Digits} {Exp} {Sign}? {Digits}
Numeric_real_mixed_const = {Numeric_real_fixed_point_const} {Exp} {Sign}? {Digits}

Numeric_integer_const = {Sign}? {Digits}
Numeric_real_const = {Numeric_real_fixed_point_const}
                   | {Numeric_real_exponential_const}
                   | {Numeric_real_mixed_const}

StringCharacter = [^\r\n\'\\]
SingleLineComment = "{" [^}\r\n] ~"}"
MultipleLineComment = "(*" [^*] ~"*)"

%%

/* Simbolos terminales sencillos */

"="			{ return symbol(sym.igual); }
"+"			{ return symbol(sym.op_mas); }
"-"			{ return symbol(sym.op_men); }
"*"			{ return symbol(sym.op_mul); }
","			{ return symbol(sym.coma); }
"."			{ return symbol(sym.punto); }
":"			{ return symbol(sym.dos_puntos); }
";"			{ return symbol(sym.punto_coma); }
":="        { return symbol(sym.dos_p_igual); }
"("         { return symbol(sym.ab_parentesis); }
")"         { return symbol(sym.cr_parentesis); }
"program"   { return symbol(sym.program); }
"begin"     { return symbol(sym.begin); }
"end"       { return symbol(sym.end); }
"const"     { return symbol(sym.const_); }
"var"       { return symbol(sym.var); }
"PROCEDURE" { return symbol(sym.procedure); }
"function"  { return symbol(sym.function); }
"integer"   { return symbol(sym.integer); }
"real"      { return symbol(sym.real); }
"div"       { return symbol(sym.div); }
"mod"       { return symbol(sym.mod); }

"or"        { return symbol(sym.or); }
"and"       { return symbol(sym.and); }
"not"       { return symbol(sym.not); }
"<"         { return symbol(sym.lt); }
">"         { return symbol(sym.gt); }
"<="        { return symbol(sym.let); }
">="        { return symbol(sym.bet); }

"if"        { return symbol(sym.if_); }
"then"      { return symbol(sym.then); }
"else"      { return symbol(sym.else_); }
"for"       { return symbol(sym.bucle_for); }
"while"     { return symbol(sym.while_); }
"do"        { return symbol(sym.do_); }
"repeat"    { return symbol(sym.repeat); }
"until"     { return symbol(sym.until); }
"to"        { return symbol(sym.to); }
"downto"    { return symbol(sym.downto); }

"unit"      { return symbol(sym.unit); }

/* no se de expr regulares jeje revisen */
{Identifier}	                    { return symbol(sym.identifier, yytext()); }
{Numeric_integer_const}		        { return symbol(sym.numeric_integer_const, new Integer(yytext())); }
{Numeric_real_fixed_point_const}    { return symbol(sym.numeric_real_const, new Float(yytext())); }
{Numeric_real_exponential_const}    { return symbol(sym.numeric_real_const, new Long(yytext())); }
{Numeric_real_mixed_const}          { return symbol(sym.numeric_real_const, new Long(yytext())); }
"'"                                 { yybegin(STRING); string.setLength(0); }
// [^"*)"] esto se supone que va con algo


<STRING> {

    /* Para que aparezca una comilla simple como contenido debe ir precedida de otra */
    "''"                { string.append("'"); }

    "'"                 { yybegin(YYINITIAL); return symbol(string_const, string.toString()); }

    {StringCharacter}+  { string.append( yytext() ); }

    /* Error fin de linea (preguntar si hace falta) */
    {LineTerminator}    { throw new RuntimeException("Error lexico: salto de linea detectado en la constante literal de la linea " + (yyline+1) + " y columna " + (yycolumn+1)); }

}

/* errorfallback */
[^] | \n    { throw new RuntimeException("Error lexico: caracter no reconocido <" + yytext() + "> en la linea " + (yyline+1) + " y columna " + (yycolumn+1)); }

<<EOF>>   { return symbol(EOF); }  // Esto lo copie del example no se que es xd
