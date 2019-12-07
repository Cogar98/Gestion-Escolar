
package SAES;

public class Profesor extends Persona {
    // ATRIBUTOS
    private String Id;
    public boolean Privilegios_Administrativos = false;
    // METODOS
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }   
}
