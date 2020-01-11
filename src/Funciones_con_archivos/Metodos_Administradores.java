package Funciones_con_archivos;

import Clases.Administrador;
import static Clases.ArrayLists.Archivos;
import static Clases.ArrayLists.administradores;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Metodos_Administradores
{
    public static File regresaFileBuscado(String nombreArchivo ,ArrayList<Administrador> Administradores)
    {
        for(int i = 0 ; i < Administradores.size() ; i++)
        {
            
        }
        return null;
    }
    public static void escribeTXT(ArrayList<Administrador> Administradores) 
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
    public static Administrador BuscaPersona(ArrayList<Administrador> Administradores , ArrayList<String> Lista)
    {
        int i;
        for( i = 0; i < Administradores.size() ; i++) // Recorre Administradores
        {
            if(Lista.get(0).equals(Administradores.get(i).getId())) // Lista.get(0) es un ID SIEMPRE
                return Administradores.get(i); // si coincide el ID me regresa el objeto Administrador
        }
        return null; // si no encuentra a nadie es null
    }
    public static void actualizaDatos(Administrador usuarioExistente ,Administrador personaArchivo)
    {
        if( !(usuarioExistente.getId().equals(personaArchivo.getId())) ) 
            usuarioExistente.setId(personaArchivo.getId());
        if( !(usuarioExistente.nombre.equals(personaArchivo.nombre)) ) 
            usuarioExistente.nombre = personaArchivo.nombre; 
        if( !(usuarioExistente.a_paterno.equals(personaArchivo.a_paterno)) ) 
            usuarioExistente.a_paterno = personaArchivo.a_paterno;
        if( !(usuarioExistente.a_materno.equals(personaArchivo.a_materno)) ) 
            usuarioExistente.a_materno = personaArchivo.a_materno;
        if( (usuarioExistente.edad != personaArchivo.edad) ) 
            usuarioExistente.edad = personaArchivo.edad;
        if( !(usuarioExistente.credenciales.user.equals(personaArchivo.credenciales.user)) ) 
            usuarioExistente.credenciales.user = personaArchivo.credenciales.user;
        if( !(usuarioExistente.credenciales.password.equals(personaArchivo.credenciales.password)) ) 
            usuarioExistente.credenciales.password = personaArchivo.credenciales.password;
        if( (usuarioExistente.Privilegios_Administrativos != personaArchivo.Privilegios_Administrativos) ) 
            usuarioExistente.Privilegios_Administrativos = personaArchivo.Privilegios_Administrativos;
        administradores.set(BuscaIndex(administradores ,personaArchivo ),usuarioExistente);
    }
    public static int BuscaIndex(ArrayList<Administrador> Administradores , Administrador personaArchivo)
    { // este metodo funciona con un Objeto de parametro personaArchivpo
        int i;
        for( i = 0; i < Administradores.size() ; i++) // Recorre Administradores
        {
            if(personaArchivo.getId().equals(Administradores.get(i).getId())) // personaArchivo.get(0) es un ID SIEMPRE
                return i; // si coincide el ID me regresa su posicion denttro del ArrayList
        }
        return -1; // si no encuentra a nadie es -1
    }
}
