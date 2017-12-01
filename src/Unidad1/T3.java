/* 
Juan Carlos López Aguirre
23-08-17
Compiladores
*/

package Unidad1;
import java.io.File;
import javax.swing.JOptionPane;

public class T3 {
    public static void main_(String[] args)
    {
        //"C:\\Users\\AULA 45\\Desktop\\Juan Carlos\\ejemplo.txt"
        JOptionPane captura = new JOptionPane(); //clon o herramienta duplicada
        String ruta = captura.showInputDialog("Inserta la ruta");
        
        File archivo = new File(ruta);
        String[] listaArchivos = archivo.list();
        String salida="";
        for (int i = 0; i < listaArchivos.length; i++) {
            //System.out.println(listaArchivos[i]);
            salida += listaArchivos[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, salida);
    }
    
}
