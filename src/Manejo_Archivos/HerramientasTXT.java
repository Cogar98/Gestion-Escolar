
package Manejo_Archivos;
import java.io.*; // Input / Output para FILE

public class HerramientasTXT{
    //METODOS
    public static void crearArchivo(String nombreArchivo)
    {   
        File archivo = new File("src/Files",nombreArchivo); // OBJETO TIPO FILE RECIBE EL NOMBRE DEL ARCHIVO
        try {   // FILE(RUTA, NOMBREARCHIVO) -> CREA EL ARCHIVO
            PrintWriter salida = new PrintWriter(archivo + ".txt"); // INICIA EL FLUJO DEL ARCHIVO
            salida.close(); // CIERRA EL FLUJO DEL ARCHIVO
            System.out.println("EL Archivo " + nombreArchivo + " se ha creado correctamente");
        } catch (FileNotFoundException ex) { // SI NO ENCUENTRA EL ARCHIVO
            ex.printStackTrace(System.out); // CUALQUIER ERROR LO MANDA EN SALIDA STANDARD
        }    
    }
}
