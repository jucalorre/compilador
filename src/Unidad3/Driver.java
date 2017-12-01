package Unidad3;


import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

public class Driver {
    String texto="";
    String rutaArchivo;
    public String Ascii()
    {
        texto = "Número\tAscii\n\n";
        for (int i = 1; i <= 256; i++) 
        {
            texto += i + "\t" + (char)i + "\n";
        }
        return texto;
    }
    
    public String abrir(String ruta)
    {
        texto = "";
        try
        {
            BufferedReader buffer = new BufferedReader(new FileReader(ruta));
            String dato;
            while((dato=buffer.readLine())!= null)
                texto+=dato+"\n";
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al "
                    + "abrir el archivo, por favor verifica la ruta" + e);
        }
        return texto;
    }
    
    public void guardar(String body, int temporal) throws FileNotFoundException
    {    
        try
        {
            if (temporal==0) 
            {
                try (PrintWriter salida = new PrintWriter(rutaArchivo))
                {
                    salida.println(body);
                }
            }
            else
            {
                try (PrintWriter salida = new PrintWriter("src/Unidad3/dump.temp"))
                {
                    salida.println(body);
                    salida.close();
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("Se terminó la operación");
        }
    }
    
    
    
    public String guardarComo(File fichero, String body) throws IOException
    {
        try
        {
            rutaArchivo = fichero.getPath();
            try (FileWriter fw = new FileWriter(fichero)) 
            {
                fw.write(body);
                JOptionPane.showMessageDialog(null, "Se grabó con éxito ;)");
            }
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Error al grabar :( \n" + e);
        }
        return rutaArchivo;        
    }
    
    
    public String quitarSaltos(String cadena) {
        return cadena.replaceAll("\n", ""); 
    }
    
    
    public String verificar() throws IOException
    {
        String salida="";
        try
        {
            BufferedReader buffer = new BufferedReader(new FileReader("src/Unidad3/dump.temp"));
            AnalizadorLexico analizadorJFlex  = new AnalizadorLexico(buffer);
            while(true)
            {
                Tokens token = analizadorJFlex.yylex();
                if(token == null)
                {
                    System.out.println("FIN");
                    break;
                }
                switch(token)
                {
                    case ERROR:
                        salida += "Error. Simbolo no reconocido\n";
                        break;
                    case BIEN:
                        salida += "TOKEN: " + token + " " + analizadorJFlex.yytext() + "\n";
                        break;
                    default:
                        System.out.println("Operación no reconocida");
                        break;
                }
                
            }
            buffer.close();
        }catch(HeadlessException | FileNotFoundException e)
        {
            System.out.println(e.toString());
        }
        System.out.println("El texto de salida es: "+ salida);
        Path path = Paths.get("src/Unidad3/dump.temp");
        Files.delete(path);
        return salida;
    }
    
}
