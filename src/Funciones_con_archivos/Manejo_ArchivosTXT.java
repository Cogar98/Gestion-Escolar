
package Funciones_con_archivos;
import Clases.*; // Importa todas las clases
import static Clases.ArrayLists.*;
import java.io.*; // Input / Output para FILE
import  java.util.ArrayList; 
import javax.swing.JOptionPane;


public class Manejo_ArchivosTXT{
    // FILES
    public File archivo = new File("src/Files" ,"");
    /*public static File AlumnosTXT = new File("src/Files","Alumnos.txt");
    public static File ProfesoresTXT = new File("src/Files","Profesores.txt");
    public static File AdministradoresTXT = new File("src/Files","Administradores.txt");*/
    //METODOS
    public static boolean verificaArchivo(String nombreArchivo)
    {
        File archivo = new File("src/Files", nombreArchivo + ".txt");        
        if(archivo.exists())
            return true; // regresa el archivo si existe
        else
            return false; // regresa falso
    }
    
    public static void crearArchivo(String nombreArchivo)
    {
        if(!verificaArchivo(nombreArchivo)) // el archivo NO EXISTE
        {
            File archivo = new File("src/Files" , nombreArchivo + ".txt");
            Archivos.add(archivo); // SE REGISTRA EN EL ARRAYLIST<FILE> Archivos
            try
            {
                PrintWriter escritura = new PrintWriter(archivo);
                escritura.close();
                System.out.println("EL ARCHIVO " + archivo + ".txt se ha creado correctamente" );
            }
            catch(FileNotFoundException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        else // El archivo EXISTE
        {
            File archivo = new File("src/Files" , nombreArchivo + ".txt"); //  AUNQUE YA EXISTA EL 
            Archivos.add(archivo); //   ARCHIVO AUN ASI SE REGISTRA EN EL ARRAYLIST<FILE> Archivos
        }
    }
    
    public static void iniciarArchivo(String nombreArchivo)
    {
        File archivo = new File("src/Files", nombreArchivo + ".txt");      
        crearArchivo(nombreArchivo);
        do
        {
            if(verificaArchivo(nombreArchivo)) // Si el archivo existe
            {
                switch(nombreArchivo)
                {
                    case "Alumnos":
                        escribeAlumnos(alumnos);
                        break;
                    case "Profesores":
                        escribeProfesores(profesores);
                        break;
                    case "Administradores":
                        escribeAdministradores(administradores);
                        break;    
                    default:
                        break;
                }
            }
            else
            {
                crearArchivo(nombreArchivo); // Si no existe lo creara y dara otra vuelta  hasta entrar en el if
            }
        }while(!archivo.exists()); // SE REPETIRA HASTA QUE EL ARCHIVO EXISTA
    }
    
    public static void escribeAlumnos(ArrayList<Alumno> Alumnos)
    {
        try
        {
            PrintWriter escritura = new PrintWriter(Archivos.get(1));
            for(int i = 0 ; i < Alumnos.size() ; i++)
            {
                escritura.print(Alumnos.get(i).getId() + " , ");
                escritura.print(Alumnos.get(i).nombre + " , ");
                escritura.print(Alumnos.get(i).a_paterno + " , ");
                escritura.print(Alumnos.get(i).a_materno + " , ");
                escritura.print(Alumnos.get(i).edad + " , ");
                escritura.print(Alumnos.get(i).credenciales.user + " , ");
                escritura.print(Alumnos.get(i).credenciales.password + " , ");
                escritura.print(Alumnos.get(i).Privilegios_Administrativos + "\n");
            }
            escritura.close();
            System.out.println("El ARCHIVO " + Archivos.get(1) + " SE HA INICIADO CORRECTAMENTE");
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void escribeAdministradores(ArrayList<Administrador> Administradores)
    {
        try
        {
            PrintWriter escritura = new PrintWriter(Archivos.get(0));
            for(int i = 0 ; i < Administradores.size() ; i++)
            {
                escritura.print(Administradores.get(i).getId() + " , ");
                escritura.print(Administradores.get(i).nombre + " , ");
                escritura.print(Administradores.get(i).a_paterno + " , ");
                escritura.print(Administradores.get(i).a_materno + " , ");
                escritura.print(Administradores.get(i).edad + " , ");
                escritura.print(Administradores.get(i).credenciales.user + " , ");
                escritura.print(Administradores.get(i).credenciales.password + " , ");
                escritura.print(Administradores.get(i).Privilegios_Administrativos + "\n");
            }
            escritura.close();
            System.out.println("El ARCHIVO " + Archivos.get(0) + " SE HA INICIADO CORRECTAMENTE");
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace(System.out);
        }      
    }
    
    public static void escribeProfesores(ArrayList<Profesor> Profesores)
    {
        try
        {
            PrintWriter escritura = new PrintWriter(Archivos.get(2)); // REVISA EL FILE 2 = PROFESORES
            for(int i = 0 ; i < Profesores.size() ; i++)
            {
                escritura.print(Profesores.get(i).getId() + " , ");
                escritura.print(Profesores.get(i).nombre + " , ");
                escritura.print(Profesores.get(i).a_paterno + " , ");
                escritura.print(Profesores.get(i).a_materno + " , ");
                escritura.print(Profesores.get(i).edad + " , ");
                escritura.print(Profesores.get(i).credenciales.user + " , ");
                escritura.print(Profesores.get(i).credenciales.password + " , ");
                escritura.print(Profesores.get(i).Privilegios_Administrativos + "\n");
            }
            escritura.close();
            System.out.println("El ARCHIVO " + Archivos.get(1) + " SE HA INICIADO CORRECTAMENTE");
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace(System.out);
        }           
    }
    
}
