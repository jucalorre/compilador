/* 
Juan Carlos López Aguirre
20-09-2017
Exmamen parcial 1: Traductor inglés español
*/
package Unidad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author AULA 45
 */
public class ExmaneParcial {

    int cantidad=0;
    String dic[][] = new String[2][100];
    String ruta;
    
    public static void main_(String args[]) throws IOException
    {
        String entrada, salida;
        ExmaneParcial clon = new ExmaneParcial();
        /*entrada = JOptionPane.showInputDialog("Hola, bienvenido al programa. Éste es un traductor\n"
                + "Por favor ingresa un número en español y será\ntraducido al inglés. (Ingresa -1 para salir)");
        */
        clon.separarCadena();


    }

    public String leerArchivo() throws IOException
    {
        int cont = 0;
        String contenido="";
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\AULA 45\\Desktop\\diccionario.txt"))) {
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                    cont++;
                }
                
                contenido = sb.toString();
                return contenido;
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return contenido;
    }
	
    public void separarCadena() throws IOException
    {
        String cadenaTotal = leerArchivo();
        String[] arreglo = cadenaTotal.split("=");
        String string="";
        for (int i = 0; i < arreglo.length; i++) {
            string = arreglo[i];
            System.out.println(arreglo[i]);
        }

    }
        
    
    
}
