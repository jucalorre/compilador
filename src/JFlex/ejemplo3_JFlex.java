package JFlex;
///src/JFlex/programa4.txt
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ejemplo3_JFlex {
    String[][] tabla = new String[10][5];
    int fila_ =  1;
    public static void main(String[] args) throws IOException 
    {
        ejemplo3_JFlex funcion = new ejemplo3_JFlex();
        funcion.tablaTitulos();
        funcion.verificar();
        funcion.contenidoTabla();
    }
    
    public void contenidoTabla()
    {
        String salida = "";
        for (String[] tabla1 : tabla) {
            for (String tabla11 : tabla1)
                salida += tabla11 + " ";
            salida += "\n";
        }
        JOptionPane.showMessageDialog(null, salida);
    }
    public void tablaTitulos()
    {
        tabla[0][0] = "Tipo";
        tabla[0][1] = "Variable";
        tabla[0][2] = "Valor";
        tabla[0][3] = "Estado";
        tabla[0][4] = "Tipo";
    }
    
    public void verificar() throws IOException
    {
        try
        {
            BufferedReader buffer = new BufferedReader(new FileReader("src/JFlex/programa4.txt"));
            Eje3 analizadorJFlex  = new Eje3(buffer);
            while(true)
            {
                Token3 token = analizadorJFlex.yylex();
                if(token == null)
                {
                    System.out.println("FIN");
                    break;
                }
                switch(token)
                {
                    case ERROR:
                        System.out.println("Error. Simbolo no reconocido");
                        System.exit(5);
                        break;
                    case BIEN:
                        System.out.println("TOKEN: " + token + " " + analizadorJFlex.yytext());
                        separarToken(analizadorJFlex.yytext());
                        break;
                    default:
                        System.out.println("Operación no reconocida");
                        break;
                }
            }
        }catch(HeadlessException | FileNotFoundException e)
        {
            System.out.println(e.toString());
        }
    }
    
    
    public void separarToken (String cadena)
    {
        String [] Tokens = cadena.split("[ ;]");
        if (Tokens[0].equals("int")||Tokens[0].equals("float")) 
        {
            if (!Tokens[1].contains("main")) 
            {
                for (String[] tabla1 : tabla) {
                    if (Tokens[1].equals(tabla1[1])) {
                        System.out.println("ERROR SEMÁNTICO: La variable ya está declarada");
                        System.exit(1);
                    }
                }
                tabla[fila_][0] = Tokens[0];
                tabla[fila_++][1] = Tokens[1];
                System.out.println("*SEMANTICO: Variable definida ->" + Tokens[1]);
            }
        }
    }
}
