package modelo;
import java.util.Locale;
import java.text.DecimalFormat;
/**
 *
 * @author Sebastian Leal S
 */
public abstract class Vehiculo {
    protected String placa, marca;
    protected int modelo;
    protected double valor;

    public Vehiculo(String placa, String marca, int modelo, double valor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
    }
    
    public Vehiculo() {
        this.placa = " ";
        this.marca = " ";
        this.modelo = 0;
        this.valor = 0;
    }
    
    public String conversionDouble(double conv) {
      Locale.setDefault(Locale.US);
      DecimalFormat num = new DecimalFormat("#,###.00");
      return num.format(conv);
    }
    
    public double valorImpuesto() {
        if (modelo <= 2000) {return valor * 0.05;}
        return valor * 0.10;
    }
    
    @Override
    public String toString() {
        return "placa: " + placa + "\n" +
                "marca: " + marca + "\n" + 
                "modelo: " + modelo + "\n" +
                "valor: " + conversionDouble(valor) + "\n";
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
