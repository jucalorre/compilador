package JFlex;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class Eje2JFlex {
public static void main (String[] args){
    try{
        String archivo = JOptionPane.showInputDialog("Ruta del archivo");
    BufferedReader buffer = new BufferedReader(new FileReader(archivo));
    Eje2 analizadorJFlex = new Eje2(buffer);
    while (true){
        
         Token2 token = analizadorJFlex.yylex();
         if (token == null){
             System.out.println("Fin");
             break;
         }
         switch (token){
             case ERROR:
             System.out.println("Error simbolo desconocido");
         break;
          case BIEN:
             System.out.println("SINTACTICO: "+token+" "+analizadorJFlex.yytext());
         break;
          default:
              System.out.println("token: "+ token + " "+ analizadorJFlex.yytext()+"\n");
         
         }
    }
    }catch(Exception e){
        System.out.print(e.toString());
    }
}   //fin de la clase 
} //fin de la clase