
package SAES;

public class Administrador extends Persona{
    // ATRIBUTOS
    private String Id;
    Boolean Privilegios_Administrativos;
    // METODOS
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    } 
}
