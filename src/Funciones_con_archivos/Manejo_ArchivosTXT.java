
package Funciones_con_archivos;
import Clases.*; // Importa todas las clases
import static Clases.ArrayLists.*;
import java.io.*; // Input / Output para FILE
import static java.lang.Integer.parseInt;
import  java.util.ArrayList; 


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
                System.out.println("ARCHIVO " + archivo + " CREADO" );
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
                    case "Administradores":
                        escribeAdministradores(administradores);
                        break;                     
                    case "Alumnos":
                        escribeAlumnos(alumnos);
                        break;
                    case "Profesores":
                        escribeProfesores(profesores);
                        break;   
                }
            }
            else
            {
                crearArchivo(nombreArchivo); // Si no existe lo creara y dara otra vuelta  hasta entrar en el if
            }
        }while(!archivo.exists()); // SE REPETIRA HASTA QUE EL ARCHIVO EXISTA
    }
        
    public static void escribeAdministradores(ArrayList<Administrador> Administradores)
    {
        try
        {
            PrintWriter escritura = new PrintWriter(Archivos.get(0)); // Archivos.get(0) = Administradores
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
            System.out.println("ARCHIVO " + Archivos.get(0).getName() + " INICIADO CORRECTAMENTE");
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace(System.out);
        }      
    }
    
    public static void escribeAlumnos(ArrayList<Alumno> Alumnos)
    {
        try
        {
            PrintWriter escritura = new PrintWriter(Archivos.get(1)); // Archivos.get(1) = alumnos<ArrayList>
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
    
    public static void regresaInfoTXT(File archivo)
    {
        int i = 0, c; // para los ciclos // c para cast
        try
        {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo)); // crea un flojo de entrada
            String lectura = entrada.readLine(); // guarda toda la linea en lectura
            while(lectura != null) //  si lectura no tiene un caracter se cierra el ciclo
            {
                ArrayList<String> infolinea = (ArrayList<String>)infoaArrayList(lectura).clone(); //copia el ArrayList de toda la informacion a uno final
                switch(archivo.getName())
                {
                    case "Administradores.txt":
                        Administrador administrador = new Administrador();
                        administrador.create(infolinea.get(0), infolinea.get(1), infolinea.get(2), infolinea.get(3), parseInt(infolinea.get(4)) , infolinea.get(5), infolinea.get(6) , Boolean.valueOf(infolinea.get(7)));
                        administradores.add(administrador);
                        break;
                        
                    case "Alumnos.txt":
                        Alumno alumno = new Alumno();
                        alumno.create(infolinea.get(0), infolinea.get(1), infolinea.get(2), infolinea.get(3), parseInt(infolinea.get(4)) , infolinea.get(5), infolinea.get(6) , Boolean.valueOf(infolinea.get(7)));
                        alumnos.add(alumno);
                        break;
                    case "Profesores.txt":
                        Profesor profesor = new Profesor();
                        profesor.create(infolinea.get(0), infolinea.get(1), infolinea.get(2), infolinea.get(3), parseInt(infolinea.get(4)) , infolinea.get(5), infolinea.get(6) , Boolean.valueOf(infolinea.get(7)));
                        profesores.add(profesor);
                        break;
                        
                }
                lectura = entrada.readLine(); // lee la siguiente linea
                i++;
            }
            entrada.close(); // cierra el flujo de entrada del archivo
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace(System.out);
        }
        catch(IOException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
    public static ArrayList<String> infoaArrayList(String cadena)
    {
        // Atributos
        ArrayList<String> informacion = new ArrayList<>();
        StringBuffer palabra = new StringBuffer(); // sirve para separar cada palabra
        char letra; // sirve para revisar cada letra
        String comparar;
        int i = 0, j = 0; // contador que debe llegar hasta el tamaño de la cadena
         // contador j es para las palabras
        while( (cadena != null) &&  (i != cadena.length())) // mientras tenga algo escrito y el contador no llegue al tamaño de la cadena
        {            
            if( (cadena.charAt(i) != ' ') && (cadena.charAt(i) != ',') ) // si es distitnto de un espacio y una coma
            {
                letra = cadena.charAt(i);  // la letra se guarda
                palabra.insert(j,letra); // la letra se añade a la palabra
                j++; // el contador de letras de palabras se aumenta
            }
            if(cadena.charAt(i) == ',')
            {
                informacion.add(palabra.toString()); // se convierte la palabra a String normal y se guarda en el ArrayList
                palabra.delete(0, j); // Borra la palabra guardada para inciar de nuevo
                j = 0; // se resetea la posicion de la palabra
            }
            if(i == cadena.length()-1)
            {
                informacion.add(palabra.toString()); // agrega la ultima palabra de la linea
            }
            i++; // el contador de posicion de toda la cadena se aumenta
            //System.out.println(j);
        }
        return informacion;
    }
}
