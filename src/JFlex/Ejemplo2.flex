package JFlex;
import static JFlex.Token2.*;
%%
%public
%class Eje2
%type Token2
NUMERAL = [#]
INCLUDE = "include"
LIBRERIA = "<iostream.h>" 
LIBRERIA2 = "<conio.h>"
ESPACIO = " "
INT = "int"
MAIN = "main"
PARENTESIS = "()"
LLAVEI = "{"
LLAVED = "}"
COUT = "cout"
COMP = "<"
GETCH = "getch"
L = [a-zA-Z]
ENDL = "endl"
PUNTO_COMA = [;]
RETURN = "return"
D = [0-9]
WHITE = [ \t\r\n]
%{
public String lexeme;
%}
%%
{WHITE} {/*ignore*/}
"//".* {/*ignore*/}
{NUMERAL} {INCLUDE} {ESPACIO}{LIBRERIA} {lexeme = yytext (); return BIEN;}
{NUMERAL} {INCLUDE} {ESPACIO}{LIBRERIA2} {lexeme = yytext (); return BIEN;}
{INT} {ESPACIO} {MAIN} {PARENTESIS} {lexeme = yytext (); return BIEN;} 
{LLAVEI} {lexeme = yytext (); return BIEN;} 
{COUT} {ESPACIO} {COMP}{COMP} {ESPACIO} {L}({L}|{D})* {ESPACIO} {COMP}{COMP} {ESPACIO} {ENDL} {PUNTO_COMA} {lexeme = yytext (); return BIEN;}
{GETCH} {PARENTESIS} {PUNTO_COMA} {lexeme = yytext (); return BIEN;}
{RETURN} {ESPACIO} {D} {PUNTO_COMA} {lexeme = yytext (); return BIEN;}
{LLAVED} {lexeme = yytext (); return BIEN;}
. {return ERROR;}