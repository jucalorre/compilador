/* 
Juan Carlos López Aguirre
23-08-17
Compiladores
*/

package Unidad1;
import java.io.File;
import javax.swing.JOptionPane;

public class T2 {
    public static void main_(String[] args)
    {
        //"C:\\Users\\AULA 45\\Desktop\\Juan Carlos\\ejemplo.txt"
        String ruta;
        JOptionPane captura = new JOptionPane(); //clon o herramienta duplicada
        ruta = captura.showInputDialog("Inserta la ruta del archivo");
        File archivo = new File(ruta);
        if (archivo.exists()) 
        {
            //System.out.println("El archivo Si existe");
            JOptionPane.showMessageDialog(null, "El archivo SÍ existe");
        }
        else
        {
            //System.out.println("El archivo No existe");
            JOptionPane.showMessageDialog(null, "El archivo NO existe");
        }
    }
    
}
