package JFlex;
import static JFlex.Token.*;
%%
%public
%class ejemplo1
%class ejemplo1
%type Token
D = [0-9]
L = [a-zA-Z]
WHITE = [ \t\r\n]


%{
public String lexeme;
%}
%%
{WHITE} {/*ignore*/}
"//".* {/*ignore*/}
"=" {return IGUAL;}
"==" {return COMPARA;}
"+" {return MAS;}
"*" {return POR;}
"-" {return MENOS;}
[-+]?{D}+ {lexeme = yytext(); return INT;}
(L) ({L} | {D})* {lexeme = yytext(); return VAR;}

. {return ERROR;}