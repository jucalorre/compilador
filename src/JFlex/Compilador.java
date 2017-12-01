package JFlex;

import java.io.File;
import javax.swing.JOptionPane;

public class Compilador {
    
    public static void main(String[] agrs)
    {
        String ruta  = JOptionPane.showInputDialog("Ruta del archivo .flex");
        generAnalizador(ruta);
    }
    
    public static void generAnalizador(String ruta)
    {
        File archivo = new File(ruta);
        jflex.Main.generate(archivo);
    }
    
}
//C:\Users\AULA 45\Documents\Compiladores\Proyecto_Compilador\src\JFlex\programa.txt
//C:\Users\AULA 45\Documents\Compiladores\Proyecto_Compilador\src\JFlex\Ejemplo1.flex
//C:\Users\AULA 45\Desktop\Compiladores\Proyecto_Compilador\src\JFlex\Ejemplo3.flex