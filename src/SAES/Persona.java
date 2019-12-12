
package SAES;

public abstract class Persona {
    protected String Id; // PROTECTED PORQUE HEREDA
    public String nombre;
    public String a_paterno;
    public String a_materno;
    public int edad;
    public boolean Privilegios_Administrativos;
    // OBJETOS
    public Usuario credenciales = new Usuario();  
    // METODOS
    public void create(String Id, String nombre, String a_paterno, String a_materno, int edad, boolean Privilegios_Administrativos
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
    
    public String getId() {
        return Id;
    }

    //Atributos
    public void setId(String Id) {
        this.Id = Id;
    }
}
