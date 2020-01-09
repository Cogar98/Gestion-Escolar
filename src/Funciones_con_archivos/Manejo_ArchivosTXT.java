
package Funciones_con_archivos;
import Clases.*; // Importa todas las clases
import static Clases.ArrayLists.*;
import java.io.*; // Input / Output para FILE
import static java.lang.Integer.parseInt;
import  java.util.ArrayList; 


public class Manejo_ArchivosTXT{
    //METODOS
    public static void FilesPredeterminados()
    {
        Archivos.add(new File("src/Files","Administradores.txt"));
        Archivos.add(new File("src/Files","Alumnos.txt"));
        Archivos.add(new File("src/Files","Profesores.txt"));
    }
    public static boolean verificaTXT(String nombreArchivo)
    {
        File archivo = new File("src/Files", nombreArchivo + ".txt");        
        if(archivo.exists())
            return true; // regresa el archivo si existe
        else
            return false; // regresa falso
    }
    
    public static void creaTXT(String nombreArchivo)
    {
        if(!verificaTXT(nombreArchivo)) // el TXT NO EXISTE en el HD / SD
        {
            File archivo = new File("src/Files" , nombreArchivo + ".txt");
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
        /*else // El archivo TXT EXISTE EN HD / SD
        {
            File archivo = new File("src/Files" , nombreArchivo + ".txt"); //  AUNQUE YA EXISTA EL 
            Archivos.add(archivo); //   ARCHIVO AUN ASI SE REGISTRA EN EL ARRAYLIST<FILE> Archivos
        }*/
    }
    
    public static void iniciaDatosATXT(File archivo)
    {
        boolean controlDeEscritura = false; // esta variable controlara el while para que ejecute "escribe..." forzosamente aun si no existe el TXT
        do
        {
            if(verificaTXT(regresaNombreSinTXT(archivo.getName()))) // Si el archivo TXT existe
            {
                switch(regresaNombreSinTXT(archivo.getName()))
                {
                    case "Administradores":
                        escribeAdministradores(administradores);
                        controlDeEscritura = true;
                        break;                     
                    case "Alumnos":
                        escribeAlumnos(alumnos);
                        controlDeEscritura = true;
                        break;
                    case "Profesores":
                        escribeProfesores(profesores);
                        controlDeEscritura = true;
                        break;   
                }
            }
            else
                creaTXT(regresaNombreSinTXT(archivo.getName())); // Si no existe lo creara y dara otra vuelta  hasta entrar en el if
        }while(controlDeEscritura == false); // SE REPETIRA HASTA QUE EL ARCHIVO TXT SE ESCRIBA
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
            System.out.println("ARCHIVO " + Archivos.get(1) + " INICIADO CORRECTAMENTE");
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
            System.out.println("ARCHIVO " + Archivos.get(1) + " INICIADO CORRECTAMENTE");
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace(System.out);
        }           
    }
    
    public static void IniciaTXT(String nombreArchivo)
    {   
        if(Archivos.size() == 0)
            FilesPredeterminados(); // crea los Administradores.txt Alumnos.txt Profesores.txt
        try
        {
            BufferedReader entrada = new BufferedReader(new FileReader(regresaFileBuscado(nombreArchivo))); // crea un flujo de entrada, busca busca el archivo sino lo crea en Archivos<ArrayList>
            String lectura = entrada.readLine(); // guarda toda la linea en lectura
            while(lectura != null) //  si lectura no tiene un caracter se cierra el ciclo
            {

                ArrayList<String> infolinea = (ArrayList<String>)infoaArrayList(lectura).clone(); //copia el ArrayList de toda la informacion a uno final
                switch(nombreArchivo + ".txt")
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
    public static File regresaFileBuscado(String nombreArchivo)
    {
        int i;
        for( i = 0 ; i < Archivos.size() ; i++)
        {
            if(Archivos.get(i).getName().equals(nombreArchivo + ".txt")) // si el nombre del archivo que yo ingrese es igual algun File de los registros predeterminados, que regrese ese FILE
            {  
                iniciaDatosATXT(Archivos.get(i)); // Escribe los usuarios predeterminados de este File
                return Archivos.get(i);
            }
            if(Archivos.size()-1 == i) // si no encontro ningun File y lo inicio lo va a crear
            {
                creaTXT(nombreArchivo); 
                //iniciarArchivo(); FALTA INICIAR ARCHIVO NO CREADO
            }
        }
        return Archivos.get(Archivos.size()); // me regresa el File en la posicion del ultimo creado
    }

    public static String regresaNombreSinTXT(String nombreArchivoTXT)
    {
        int i ; // ciclos
        char letra;
        StringBuffer palabra = new StringBuffer();
        for( i = 0 ; i < nombreArchivoTXT.length(); i++)
        {
            letra = nombreArchivoTXT.charAt(i);         
            if(letra != '.')
                palabra.insert(i,letra);
            else
            {
                return palabra.toString();
            }
        }
        return null;
    }
}
