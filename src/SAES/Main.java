
package SAES;

import java.util.ArrayList;

public class Main {
        //ArrayList
    public static ArrayList<Alumno> alumnos = new ArrayList<>();
    public static ArrayList<Administrador> administradores = new ArrayList<>();
    public static ArrayList<Profesor> profesores = new ArrayList<>();
    
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
        
        // LAS VENTANAS EMPIEZAN AQUI
        System.out.println("Bolean: " + administradores.get(0).Privilegios_Administrativos);
        Inicio_Sesion Frame = new Inicio_Sesion();
        Frame.setVisible(true);
           

            
    }
    
}
