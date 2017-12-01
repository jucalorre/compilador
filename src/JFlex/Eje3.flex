package JFlex;
import static JFlex.Token3.*;
%%
%public
%class Eje3
%type Token3
NUMERAL = [#]
INCLUDE = "include"
LIBRERIA = "<iostream.h>"
LIBRERIA2 = "<conio.h>"
ESPACIO = " "
INT = "int"
FLOAT = "float"
IGUAL = "="
MAIN = "main"
PARENTESIS = "()"
LLAVEIZQ = "{"
COUT = "cout"
COMP = "<"
GETCH = "getch"
RETURN = "return"
LLAVEDER = "}"
L = [a-zA-Z]
NUM = [0-9]
ENDL = "endl"
PUNTO_COMA = [;]
PUNTO = [.]
WHITE = [ \t\r\n]
%{
public String lexeme;
%}
%%
{WHITE} {/*ignore*/}
"//".* {/*ignore*/}
{NUMERAL} {INCLUDE} {ESPACIO} {LIBRERIA} {lexeme = yytext(); return BIEN;}
{NUMERAL} {INCLUDE} {ESPACIO} {LIBRERIA2} {lexeme = yytext(); return BIEN;}
{INT} {ESPACIO} {MAIN} {PARENTESIS} {lexeme = yytext(); return BIEN;}
{LLAVEIZQ} {lexeme = yytext(); return BIEN;}
{FLOAT} {ESPACIO} {L} ({L}|{NUM})* {PUNTO_COMA} {lexeme = yytext(); return BIEN;}
{INT} {ESPACIO} {L} ({L}|{NUM})* {PUNTO_COMA} {lexeme = yytext(); return BIEN;}
{L} ({L}|{NUM})* {ESPACIO} {IGUAL} {ESPACIO} {NUM} ({NUM}|{PUNTO}|{NUM})* {PUNTO_COMA} {lexeme = yytext(); return BIEN;}
{COUT} {ESPACIO} {COMP} {COMP} {ESPACIO} {L} ({L}|{NUM})* {ESPACIO} {COMP} {COMP} {ESPACIO} {ENDL} {PUNTO_COMA} {lexeme = yytext(); return BIEN;}
{GETCH} {PARENTESIS} {PUNTO_COMA} {lexeme = yytext(); return BIEN;}
{RETURN} {ESPACIO} {NUM} {PUNTO_COMA} {lexeme = yytext(); return BIEN;}
{LLAVEDER} {lexeme = yytext(); return BIEN;}
. {return ERROR;}
