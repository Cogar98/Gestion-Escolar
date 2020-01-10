package Funciones_con_archivos;

import Clases.Administrador;
import static Clases.ArrayLists.Archivos;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Metodos_Administradores extends Metodos_Abstractos
{

    /**
     *
     * @param Administradores
     */
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
}
