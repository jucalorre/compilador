package JFlex;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ejemplo1_JFlex {
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        try
        {
            String archivo = JOptionPane.showInputDialog("Ruta del archivo a analizar: ");
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
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
                        break;
                    default:
                        System.out.println("Token: " + token + " " + analizadorJFlex.yytext());
                        break;
                }
                
            }
        }catch(HeadlessException | FileNotFoundException e)
        {
            System.out.println(e.toString());
        }
        
    }
}
