/** Juan Carlos López Aguirre
 * 06-09-17
 */
package Unidad1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;



public class T62
{
	public static void main_(String args[])
	{
            T62 clon = new T62();
            clon.eje4();
	}
        public void eje1()
        {
            //Encontrar una palabra o formato dentro de un texto
            String texto="Esto es una prueba de texto"
                    + "que puede ser buscado" + "en internet como http://"
                    + "que es usado";
            String patron = ".*internet.*"; // qué es lo que quiero buscar
            Pattern busqueda = Pattern.compile(patron);
            Matcher contenido = busqueda.matcher(texto);
            JOptionPane.showMessageDialog(null, "Coincidencia: "
                    + contenido.matches());
        }
        
        public void eje2() //encuentra un texto que sea mayusculas o minusculas
        {
            String texto="Esto es una prueba de texto"
                    + "que puede ser buscado" + "en internet como http://"
                    + "que es usado";
            String patron = ".*esTo.*"; // qué es lo que quiero buscar
            Pattern busqueda = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
            Matcher contenido = busqueda.matcher(texto);
            JOptionPane.showMessageDialog(null, "Coincidencia: "+ contenido.matches() +
                                            "\nBuscando: " + contenido.lookingAt());
        }
        
        public void eje3() //nos muestra un message dialog si encuentra una coincidencia
        {
            String texto="Esto es una prueba de texto"
                    + "que puede ser buscado" + "en internet como http://"
                    + "que es usado";
            String patron = ".*es.*"; // qué es lo que quiero buscar
            Pattern busqueda = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
            Matcher contenido = busqueda.matcher(texto);
            int cont = 0;
            while(contenido.find())
            {
                cont++;
                System.out.println(cont);
                JOptionPane.showMessageDialog(null, "Se encontró: " + cont
                                            + ": "
                                            + contenido.start() +
                                            " - "
                                            + contenido.end());
                
            }
        }
        
        public void eje4() //comprobar si una cadena empieza por 
        {
            String texto="Esto es una prueba de texto"
                    + "que puede ser buscado" + "en internet como http://"
                    + "que es usado";
            String patron = "^qu.*"; // qué es lo que quiero buscar
            Pattern busqueda = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
            Matcher contenido = busqueda.matcher(texto);
            int cont = 0;
            while(contenido.find())
            {
                cont++;
                System.out.println(cont);
                JOptionPane.showMessageDialog(null, "Se encontró: " + cont
                                            + ": "
                                            + contenido.start() +
                                            " - "
                                            + contenido.end());
                
            }
        }
}