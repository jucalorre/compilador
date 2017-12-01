/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Examen1 {
    public static void main_(String args[]) throws FileNotFoundException 
	{
		T65 clon = new T65();
		clon.eje6();
	}
    
    
    public void eje6() throws FileNotFoundException
        {
            int opcion = 0;
            String nombre = "";
            String contenido="";
            do
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Hola, estas son las opciones:\n"
                        + "1.- Español/Inglés"
                        + "\n2.- Inglés Español"
                        + "\n3.- Salir"));
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
                        JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                        break;
                    default:
                }
            }while(opcion != 3);
        }
        
        public void guardar(String name, String body) throws FileNotFoundException
        {    
            try{
                int caracter=0;
                try (PrintWriter salida = new PrintWriter("C:\\Users\\AULA 45\\Desktop\\" + name + ".txt") //creamos una ruta del archivo
                ) {
                    salida.println(body);
                }
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
}
