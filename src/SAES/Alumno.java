
package SAES;

public class Alumno extends Persona {
    // ATRIBUTOS
    private String Id; // Id es PRIVADO
    public boolean Privilegios_Administrativos = false;
    // METODOS
    public String getId() {

        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
}
