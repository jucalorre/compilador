
package Unidad1;
import java.io.File;

public class T1 
{
    public static void main_(String []Args)
    {
        //Herramienta para manejo de archivos
        //Aqui se inserta la ruta del archivo
        File archivo = new File("");
        if (archivo.exists()) 
        {
            System.out.println("El archivo Si existe");
        }
        else
        {
            System.out.println("El archivo No existe");
        }
    }
}
