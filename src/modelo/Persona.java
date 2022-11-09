
package modelo;

/**
 *
 * @author Sebastian Leal S
 */
public class Persona {
    private String id, nombre, tel, email;
    private Fecha fNac;

    public Persona(String id, String nombre, String tel, String email, Fecha fNac) {
        this.id = id;
        this.nombre = nombre;
        this.tel = tel;
        this.email = email;
        this.fNac = fNac;
    }

    public Persona() {
        this.id = " ";
        this.nombre = " ";
        this.tel = " ";
        this.email = " ";
        this.fNac = new Fecha();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Id: " + id + "\n" +
               "Telefono: " + tel + "\n" +
               "Email: " + email + "\n" +
               "Fecha Nacimiento: " + fNac + "\n" +
               "Edad: " + edad() + "\n";
    }
    
    public int edad() {
        Fecha fActual= new Fecha();
        return fActual.getAa() - fNac.getAa();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Fecha getfNac() {
        return fNac;
    }

    public void setfNac(Fecha fNac) {
        this.fNac = fNac;
    }
}
