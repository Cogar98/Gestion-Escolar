
package Funciones_con_archivos;
import Clases.*; // Importa todas las clases
import static Clases.ArrayLists.*;
import static Funciones_con_archivos.Metodos_Administradores.escribeTXT;
import static Funciones_con_archivos.Metodos_Administradores.actualizaDatos;
import static Funciones_con_archivos.Metodos_Alumnos.escribeTXT;
import static Funciones_con_archivos.Metodos_Alumnos.BuscaID;
import static Funciones_con_archivos.Metodos_Profesores.escribeTXT;
import static Funciones_con_archivos.Metodos_Profesores.BuscaID;
import java.io.*; // Input / Output para FILE
import static java.lang.Integer.parseInt;
import  java.util.ArrayList; 
import static Funciones_con_archivos.Metodos_Administradores.BuscaPersona;


public class Main_ArchivosTXT{
    //METODOS
    public static void FilesYArrayListPredeterminados()
    {
        System.out.println("SE ABRE METODO");
        //FILES
        Archivos.add(new File("src/Files","Administradores.txt"));
        Archivos.add(new File("src/Files","Alumnos.txt"));
        Archivos.add(new File("src/Files","Profesores.txt"));
        // ArrayList
            // DECLARACION DE USUARIOS PREDETERMINADOS
        Alumno plantilla_alumno = new Alumno();
        Administrador plantilla_administrador = new Administrador();
        Profesor plantilla_profesor = new Profesor();        
        plantilla_alumno.create("1", "Mike", "Gutierrez", "Villalpando", 19, "mike99", "password",false);
        alumnos.add(plantilla_alumno);
        plantilla_administrador.create("1", "Roberto", "Cordova", "Galvan", 21,"cogar98", "password", true);
        administradores.add(plantilla_administrador);
        plantilla_profesor.create("1", "Ernesto", "Filio", "Lopez", 70 , "Filio", "password",false);
        profesores.add(plantilla_profesor);
    }
    
    public static boolean verificaTXT(String nombreArchivo)
    {
        File archivo = new File("src/Files", nombreArchivo + ".txt");        
        return archivo.exists(); // regresa TRUE / FALSE si existe o no existe
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
                        escribeTXT(administradores);
                        controlDeEscritura = true;
                        break;                     
                    case "Alumnos":
                        escribeTXT(alumnos);
                        controlDeEscritura = true;
                        break;
                    case "Profesores":
                        escribeTXT(profesores);
                        controlDeEscritura = true;
                        break;   
                }
            }
            else
                creaTXT(regresaNombreSinTXT(archivo.getName())); // Si no existe lo creara y dara otra vuelta  hasta entrar en el if
        }while(controlDeEscritura == false); // SE REPETIRA HASTA QUE EL ARCHIVO TXT SE ESCRIBA
    }
  
    public static void IniciaTXT(String nombreArchivo)
    {
        int i = 0;
        if(Archivos.isEmpty()) // si NO EXISTEN FILES
            FilesYArrayListPredeterminados(); // crea los Administradores.txt Alumnos.txt Profesores.txt
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
                        Administrador desconocido = new Administrador(); // para crear un nuevo desconocido
                        Administrador modificacion = new Administrador(); // para SOLAMENTE modificar datos de un desconocido
                        desconocido.create(infolinea.get(0), infolinea.get(1), infolinea.get(2), infolinea.get(3), parseInt(infolinea.get(4)) , infolinea.get(5), infolinea.get(6) , Boolean.valueOf(infolinea.get(7)));
                        if((modificacion = BuscaPersona(administradores,infolinea)) != null) // si encontro a  un desconocido
                        {   
                            System.out.println(administradores.size());
                            System.out.println("SE ENCONTRO A ALGUIEN");
                            actualizaDatos(modificacion , desconocido); // se modificarán sus datos segun el archivo de texto
                            System.out.println(administradores.size());
                        }
                        else // en caso de NO encontrar un desconocido
                            administradores.add(desconocido); // se creara un nuevo desconocido
                        break;
                    case "Alumnos.txt":
                        Alumno alumno = new Alumno();
                        alumno.create(infolinea.get(0), infolinea.get(1), infolinea.get(2), infolinea.get(3), parseInt(infolinea.get(4)) , infolinea.get(5), infolinea.get(6) , Boolean.valueOf(infolinea.get(7)));
                        if(BuscaID(alumnos, infolinea) == null)
                            alumnos.add(alumno);
                        else
                            
                        break;
                    case "Profesores.txt":
                        Profesor profesor = new Profesor();
                        profesor.create(infolinea.get(0), infolinea.get(1), infolinea.get(2), infolinea.get(3), parseInt(infolinea.get(4)) , infolinea.get(5), infolinea.get(6) , Boolean.valueOf(infolinea.get(7)));
                        if(BuscaID(profesores , infolinea) == null)
                            profesores.add(profesor);
                        else
                            
                        break;
                }
                i++;
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
        for( i = 0 ; i < Archivos.size() ; i++) // recorre los Files -> Flujo de salida
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
                return palabra.toString();
        }
        return null;
    }
}