package modelo;

/**
 *
 * @author Sebastian Leal S
 */
public class Formulario {
    private String nroF;
    private Fecha fechaR;
    private Persona propietario;
    private Vehiculo objV;

    public Formulario(String nroF, Fecha fechaR, Persona propietario, Vehiculo objV) {
        this.nroF = nroF;
        this.fechaR = fechaR;
        this.propietario = propietario;
        this.objV = null;
    }
    
    public Formulario() {
        int cod = (int)(Math.random()*999+100);
        this.nroF = "FRM - " + cod;
        this.fechaR = new Fecha();
        this.propietario = new Persona();
        this.objV = new Auto();
    }

    @Override
    public String toString() {
        return "Formulario impuesto\n\n" +
                "Numero Formulario: \n" + nroF + "\n" +
                "fecha Registro: " + fechaR + "\n" +
                "\n--Propietario--\n" + propietario + "\n" +
                "\n--Vehiculo--\n" + objV + "\n";
    }
    
    public double valorPago() {
        return objV.valorImpuesto();
    }

    public String getNroF() {
        return nroF;
    }

    public void setNroF(String nroF) {
        this.nroF = nroF;
    }

    public Fecha getFechaR() {
        return fechaR;
    }

    public void setFechaR(Fecha fechaR) {
        this.fechaR = fechaR;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Vehiculo getObjV() {
        return objV;
    }

    public void setObjV(Vehiculo objV) {
        this.objV = objV;
    }
    
}
