package modelo;

/**
 *
 * @author Sebastian Leal S
 */
public class Moto extends Vehiculo{
    
    private double cilindraje;
    public Moto(String placa, String marca, int modelo, double valor, double cilindraje) {
        super(placa, marca, modelo, valor);
        this.cilindraje = cilindraje;
    }

    public Moto() {
        super();
        this.cilindraje = 0;
    }
    
    @Override
    public double valorImpuesto(){
        if(cilindraje > 125){
            return valor * 0.1;
        }else{
            return valor * 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\ncilindraje: " + cilindraje + "\n";
    }

    
    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }
        
}
