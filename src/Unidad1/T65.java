package Unidad1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class T65
{
	public static void main_(String args[]) throws FileNotFoundException
	{
		T65 clon = new T65();
		clon.eje6();
	}
	
	public void eje5()
	{
		String texto = JOptionPane.showInputDialog(" Introduce la cadena");
		String [] cadena = texto.split("[-:._]");
		String resultado="";
		for(int i=0; i<cadena.length;i++)
		{
			resultado += cadena[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, resultado);
	}
        
        public void eje6() throws FileNotFoundException
        {
            int opcion = 0;
            String nombre = "";
            String contenido="";
            do
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero del menú:\n"
                        + "1.- Guardar informacion de un archivo\n"
                        + "2.- Abrir un archivo\n"
                        + "3.- Herramienta traductor español/inglés\n"
                        + "4.- Herramienta traductor inglés/español\n"
                        + "5.- Salir"));
                switch(opcion)
                {
                                           
                    case 1:
                        JOptionPane.showMessageDialog(null, "Has ingresado a la opción 1");
                        nombre = JOptionPane.showInputDialog(null, "¿Cual es el nombre del archivo que deseas guardar?");
                        contenido = JOptionPane.showInputDialog(null, "Ingresa el contenido del archivo a guardar");
                        guardar(nombre, contenido);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Has ingresado a la opción 2");
                        JOptionPane.showMessageDialog(null, abrir());
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Has ingresado a la opción 3");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Has ingresado a la opción 4");
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                        break;
                    default:
                }
            }while(opcion != 5);
        }
        
        public void guardar(String name, String body) throws FileNotFoundException
        {    
            try{
                int caracter=0;
                PrintWriter salida = new PrintWriter("C:\\Users\\AULA 45\\Desktop\\" + name + ".txt"); //creamos una ruta del archivo
                salida.println(body);
                salida.close();
            }catch(FileNotFoundException e){
                System.out.println(e);
            }finally
            {
                JOptionPane.showMessageDialog(null, "Se terminó la operación");
            }
        }
        public String abrir()
        {
            String contenido = "";

            try
            {
                String archivo = "C:\\Users\\AULA 45\\Documents\\Proyecto_Compilador\\src\\proyecto_compilador\\proyecto_compilador.java";
                BufferedReader buffer = new BufferedReader(new FileReader(archivo));
                String dato;
                while((dato=buffer.readLine())!= null)
                    contenido+=dato;
            } catch(IOException e){
                JOptionPane.showMessageDialog(null, e);
            }
            return contenido;
        }
}
