/* 
Juan Carlos López Aguirre
26-09-2017
Examen v2, versión mejorada 1| parcial
*/
package Unidad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

public class Parcial {
    String[][] numeros = new String[2][101];
    public static void main_(String args[])
    {
        Parcial clon = new Parcial();
        clon.menu();
    }
    
    public String abrir()
    {
        String contenido = "";
        try
        {
            String archivo = "C:\\Users\\Juan Carlos\\Documents\\UDG\\Compiladores\\Proyecto_Compilador\\src\\Unidad1\\diccionario.txt";
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
            String dato;
            while((dato=buffer.readLine())!= null)
                contenido+=dato;
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return contenido;
    }
    
    public void menu()
    {
        int seleccion, indice;
        String busqueda;
        arreglar();
        do
        {
            seleccion = parseInt(JOptionPane.showInputDialog("Hola, bienvenido:\n"
                + "1.- Inglés/Español\n"
                + "2.- Español/Inglés\n"
                + "3.- Salir"));
            switch(seleccion)
            {
                case 1:
                    busqueda = JOptionPane.showInputDialog("Seleccionó 1.\n"
                            + "Ingresa el numero escrito con letras en inglés:").toUpperCase();
                    indice = buscarIngles(busqueda);
                    
                        if (indice == 101)
                            JOptionPane.showMessageDialog(null, "NO se ha encontrado ninguna coincidencia");
                        else
                            JOptionPane.showMessageDialog(null, "El número " + busqueda + " en español es: " + numeros[0][indice]);
                        break;

                    
                case 2: 
                    busqueda = JOptionPane.showInputDialog("Seleccionó 2.\n"
                            + "Ingresa el numero escrito con letras en español:").toUpperCase();
                    indice = buscarEspañol(busqueda);
                    if (indice == 101)
                        JOptionPane.showMessageDialog(null, "NO se ha encontrado ninguna coincidencia");
                    else
                        JOptionPane.showMessageDialog(null, "El número " + busqueda + " en inglés es: " + numeros[1][indice]);
                    break;

                    
                case 3:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa :)");
                    arreglar();
                    break;
                default:
                    break;
            }
        }while(seleccion!=3);
    }
    
    public void arreglar() //Crear arreglo bidimensional con los numeros en español e inglés
    {
        String[][]  indices = new String[2][100];
        String contenido = abrir();
        String[] español = contenido.split("[=.]");
        int par = 0, impar = 0;
        for (int i = 0; i < español.length; i++) 
        {
            if(i%2==0)
                numeros[0][par++] = español[i].toUpperCase();
            else
                numeros[1][impar++] = español[i].toUpperCase();
            
        }
    }
    
    public int buscarEspañol(String palabra) // no se si exista un metodo en Java para hacer lo que estoy haciendo en arreglos
    {
        int i;
        for (i = 0; i <= 100; i++) 
        {
            if(palabra.equals(numeros[0][i]))
                break; //Si la palabrta buscada se encuentra, se sale del bucle
        }
        return i;
    }
    
    public int buscarIngles(String palabra) // no se si exista un metodo en Java para hacer lo que estoy haciendo en arreglos
    {
        int i;
        for (i = 0; i <= 100; i++) 
        {
            if(palabra.equals(numeros[1][i]))
                break; //Si la palabrta buscada se encuentra, se sale del bucle
        }
        return i;
    }
}
