
package Manejo_Archivos;
import java.io.*; // Input / Output para FILE
import  java.util.ArrayList; // 
import static SAES.Main.*; // Importa todo lo estatico de MAIN
import SAES.*; // IMPORTA TODAS LAS CLASES Y FRAMES DE SAES

public class HerramientasTXT{
    //METODOS
    /*public static File AlumnosTXT = new File("src/Files","Alumnos.txt");
    public static File ProfesoresTXT = new File("src/Files","Profesores.txt");
    public static File AdministradoresTXT = new File("src/Files","Administradores.txt");
    */
    public static void crearArchivo(String nombreArchivo)
    {   
        File archivo = new File("src/Files",nombreArchivo + ".txt");
        try {   // FILE(RUTA, NOMBREARCHIVO) -> CREA EL ARCHIVO
            
            PrintWriter salida = new PrintWriter(archivo + ".txt"); // INICIA EL FLUJO DEL ARCHIVO
            salida.close(); // CIERRA EL FLUJO DEL ARCHIVO
            System.out.println("EL Archivo " + nombreArchivo + " se ha creado correctamente");
        } catch (FileNotFoundException ex) { // SI NO ENCUENTRA EL ARCHIVO
            ex.printStackTrace(System.out); // CUALQUIER ERROR LO MANDA EN SALIDA STANDARD
        }    
    }
    
    public static void verificaArchivos(String nombreArchivo)
    {
        File archivo = new File("src/Files",nombreArchivo + ".txt"); // añade extension .txt
        if(!archivo.exists()) // SI EL ARCHIVO NO EXISTE
        {
            crearArchivo(nombreArchivo); // ENTONCES CREARA EL ARCHIVO
        }
        else
        {
            System.out.println("ARCHIVO INICIALIZADO"); // SI EXISTE ENTONCES SOLO INDICARA QUE SE INICIALIZÓ
        }
    }
    
    public static void añadeObjetos(File archivo, ArrayList<Alumno> Alumno)// recibe un archivo
    {
        try
        {
            PrintWriter escritura = new PrintWriter(archivo + ".txt");
            
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
}
