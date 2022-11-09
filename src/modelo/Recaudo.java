package modelo;

import java.util.ArrayList;

/**
 *
 * @author Sebastian Leal S
 */
public class Recaudo {
    private ArrayList<Formulario> listaF;

    public Recaudo(ArrayList<Formulario> listaF) {
        this.listaF = listaF;
    }
    
    public Recaudo() {
        this.listaF = new ArrayList<Formulario>();
    }

    public double totalRecaudo() {
        double form = 0;
        for (int i = 0; i < listaF.size(); i++) {
            form += listaF.get(i).valorPago();
        }
        return form;
    }
    
    public int cantAutos() {
        int form = 0;
        for (int i = 0; i < listaF.size(); i++) {
            if (listaF.get(i).getObjV() instanceof Auto)
            form ++;
        }
        return form;
    }
    
    public int cantMoto() {
        int form = 0;
        for (int i = 0; i < listaF.size(); i++) {
            if (listaF.get(i).getObjV() instanceof Moto)
            form ++;
        }
        return form;
    }
    
    @Override
    public String toString() {
        String form = "", tipoV = "";
        for (int i = 0; i < listaF.size(); i++) {
            if (listaF.get(i).getObjV() instanceof Auto)//Polimorfismo
                tipoV = "Formulario Auto\n";
            else
                tipoV = "Formulario Moto\n";
            form += tipoV + listaF.get(i).toString() + "\n" + 
                    "valor impuesto: " + listaF.get(i).valorPago() + "\n";
        }
        return "Recaudo: " + form + "\n";
    }

    public ArrayList<Formulario> getListaF() {
        return listaF;
    }

    public void setListaF(ArrayList<Formulario> listaF) {
        this.listaF = listaF;
    }
    
    
}
