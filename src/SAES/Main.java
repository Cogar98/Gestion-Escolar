
package SAES;
import static Funciones_con_archivos.Main_ArchivosTXT.*; // IMPORTA METODOS PARA ARCHIVOS DE TEXTO
import static Clases.ArrayLists.*;

public class Main { 
    public static void main(String[] args) {      
        //ATRIBUTOS 
            // VARIABLES
        int i;
            // ARCHIVOS TXT
        System.out.println( alumnos.size() + " " +administradores.size() + " " + profesores.size());
        IniciaTXT("Administradores"); // recupera toda la info del archivo Administradores en ArrayLists
        //IniciaTXT("Alumnos"); //recupera toda la info del archivo Alumnos en ArrayLists
        //IniciaTXT("Profesores"); //recupera toda la info del archivo Profesores en ArrayLists
        System.out.println( alumnos.size() + " " +administradores.size() + " " + profesores.size() + " ADMINISTRADOR PREDETERMINADO: " + administradores.get(0).nombre);
        /* for(i = 0 ; i < administradores.size() ; i++)
        System.out.println(administradores.get(i).getId() + administradores.get(i).nombre + " " + administradores.get(i).a_paterno + administradores.get(i).a_materno
        + administradores.get(i).edad + administradores.get(i).credenciales.user + administradores.get(i).credenciales.password +
        administradores.get(i).Privilegios_Administrativos);*/
        // LAS VENTANAS EMPIEZAN AQUI
        Inicio_Sesion Frame = new Inicio_Sesion();
        Frame.setVisible(true);
    }
    
}
