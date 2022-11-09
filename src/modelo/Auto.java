package modelo;

/**
 *
 * @author Sebastian Leal S
 */
public class Auto extends Vehiculo{

    public Auto(String placa, String marca, int modelo, double valor) {
        super(placa, marca, modelo, valor);
    }

    public Auto() {
        super();
    }
    
    @Override
    public double valorImpuesto(){
        if(modelo < 2000){
            return valor * 0.05;
        }else{
            return valor * 0.1;
        }
    }
}
