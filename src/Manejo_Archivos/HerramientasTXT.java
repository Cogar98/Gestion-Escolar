
package Manejo_Archivos;
import java.io.*; // Input / Output para FILE
import  java.util.ArrayList; // 
import SAES.*; // IMPORTA TODAS LAS CLASES Y FRAMES DE SAES
import javax.swing.JOptionPane;


public class HerramientasTXT{
    // FILES
    public static File AlumnosTXT = new File("src/Files","Alumnos.txt");
    public static File ProfesoresTXT = new File("src/Files","Profesores.txt");
    public static File AdministradoresTXT = new File("src/Files","Administradores.txt");
    //METODOS
    public static void crearArchivo(String nombreArchivo)
    {   
        File archivo = new File("src/Files",nombreArchivo +".txt");
        try {   // FILE(RUTA, NOMBREARCHIVO) -> CREA EL ARCHIVO
            
            PrintWriter salida = new PrintWriter(archivo); // INICIA EL FLUJO DEL ARCHIVO
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
    
   public static void iniciaAlumnosTXT(ArrayList<Alumno> alumnos)// Recibe un ArrayLis<Alumno>
    {
        int i;
        try
        {
           PrintWriter escribir = new PrintWriter(AlumnosTXT); // LISTO PARA ESCRIBIR ARCHIVO
           if( 0 < alumnos.size()) // SI EL ARRAYLIST CONTIENE ELEMENTOS
           {
               for( i = 0 ; i < alumnos.size() ; i++ ) // RECORRE EL ARREGLO
               {
                   escribir.println(alumnos.get(i).getId() + " , " + alumnos.get(i).nombre + " , " + alumnos.get(i).a_paterno
                   + " , " + alumnos.get(i).a_materno + " , " + alumnos.get(i).edad + " , " + (alumnos.get(i).Privilegios_Administrativos ? 1 : 0)
                   + " , " + alumnos.get(i).credenciales.user + " , " + alumnos.get(i).credenciales.password); // (alumnos.get(i).Privilegios_Administrativos ? 1 : 0) regresa 1 o 0 si es true or false
               }
           }
           else // NO CONTIENE NINGUN ELEMENTO
           {
               JOptionPane.showMessageDialog(null,"NO SE PUDO GUARDAR INFORMACION EN EL ARCHIVO ALUMNOS");
           }
           escribir.close();
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace(System.out); //IMPRIME UN ERROR
        }  
    }
}
