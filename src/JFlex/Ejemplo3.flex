package JFlex;
import static JFlex.Token3.*;
%%
%public
%class Eje3
%type Token3
D = [0-9]
L = [a-zA-Z]
WHITE = [ \t\r\n]

%{
public String lexeme;
%}
%%
{WHITE} {/*ignore*/}
"//".* {/*ignore*/}
"public" {return PUBLIC;}
"class" {return CLASS;}
"HolaMundo" {return HOLAMUNDO;}
"{" {return LLAVEI;}
"}" {return LLAVED;}
"static" {return STATIC;}
"void" {return VOID;}
"main" {return MAIN;}
"(" {return PARENTESISI;}
")" {return PARENTESISD;}
"String" {return STRING;}
"[" {return CORCHI;}
"]" {return CORCHD;}
"args" {return ARGS;}
"System" {return SYSTEM;}
"." {return PUNTO;}
"out" {return OUT;}
"println" {return PRINTLN;}
";" {return PUNTO_COMA;}
[-+]?{D}+ {lexeme = yytext(); return INT;}
(L) ({L} | {D})* {lexeme = yytext(); return VAR;}

. {return ERROR;}