
package SAES;

public abstract class Persona {
    //Atributos
    String Id;
    String nombre;
    String a_paterno;
    String a_materno;
    int edad;
    Boolean Privilegios_Administrativos;
    // OBJETOS
    Usuario credenciales = new Usuario();  
    // METODOS
    public void create(String Id, String nombre, String a_paterno, String a_materno, int edad, boolean Privilegios_administrativos
    ,String user, String password)
    {
        this.Id = Id;
        this.nombre = nombre;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.edad = edad;
        this.Privilegios_Administrativos = Privilegios_Administrativos;
        this.credenciales.createUsuario(user, password);
    }
}
