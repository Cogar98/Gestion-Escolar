
package SAES;
import Clases.Administrador;
import Clases.Alumno;
import Clases.Profesor;
import static Funciones_con_archivos.Manejo_ArchivosTXT.*; // IMPORTA METODOS PARA ARCHIVOS DE TEXTO
import static Clases.ArrayLists.*;

public class Main { 
    public static void main(String[] args) {      
        //ATRIBUTOS 
            //Objetos
        Alumno plantilla_alumno = new Alumno();
        Administrador plantilla_administrador = new Administrador();
        Profesor plantilla_profesor = new Profesor();
            // VARIABLES
        int i;
            // DECLARACION DE USUARIOS PREDETERMINADOS
        plantilla_alumno.create("1", "Mike", "Gutierrez", "Villalpando", 19, false, "mike99", "password");
        alumnos.add(plantilla_alumno);
        plantilla_administrador.create("1", "Roberto", "Cordova", "Galvan", 21,true, "cogar98", "password");
        administradores.add(plantilla_administrador);
        plantilla_profesor.create("1", "Ernesto", "Filio", "Lopez", 70 , false ,"Filio", "password");
        profesores.add(plantilla_profesor);
            // ARCHIVOS TXT
        iniciarArchivo("Administradores");
        iniciarArchivo("Alumnos");       
        iniciarArchivo("Profesores");
            // LAS VENTANAS EMPIEZAN AQUI
        Inicio_Sesion Frame = new Inicio_Sesion();
        Frame.setVisible(true);
    }
    
}
