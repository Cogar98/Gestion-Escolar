package Funciones_con_archivos;

import Clases.Alumno;
import static Clases.ArrayLists.Archivos;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Metodos_Alumnos extends Metodos_Abstractos
{

    /**
     *
     * @param Alumnos
     */
    public static void escribeTXT(ArrayList<Alumno> Alumnos)
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
    
}
