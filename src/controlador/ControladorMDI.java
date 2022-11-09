package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.*;
import modelo.*;

/**
 *
 * @author Sebastian Leal S
 */
public class ControladorMDI implements ActionListener{
    frmMDI frmInicial;
    frmRegMDI frmRegistro;
    tableConsulta tableConsulta;
    Formulario objF;

    public ControladorMDI() {
        this.frmInicial = new frmMDI();
        this.frmRegistro = new frmRegMDI();
        this.tableConsulta = new tableConsulta();
        this.objF = new Formulario();
    }
    
    public void iniciar() {
        frmInicial.setTitle("Proyecto Vehiculo con MDI");
        frmInicial.setLocationRelativeTo(null);
        frmInicial.setVisible(true);
        
        frmInicial.getOpcRegistrar().addActionListener(this);
        frmInicial.getOpcListado().addActionListener(this);
        frmInicial.getOpcSalir().addActionListener(this);
        
        frmInicial.getTbBtnRegistrar().addActionListener(this);
        frmInicial.getTbBtnListado().addActionListener(this);
        frmInicial.getTbBtnSalir().addActionListener(this);
        frmInicial.getTbTbtnFechaSist().addActionListener(this);
        frmInicial.getTbTbtnHoraSist().addActionListener(this);
        
        frmInicial.getTbInferior().setVisible(true);
        
        frmRegistro.getBtnSiguiente().addActionListener(this);
        frmRegistro.getBtnAnterior().addActionListener(this);
        frmRegistro.getBtnRegistrar().addActionListener(this);
        
        tableConsulta.getBtngTipoVeh().add(tableConsulta.getRbtnCarro());
        tableConsulta.getBtngTipoVeh().add(tableConsulta.getRbtnMoto());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(frmInicial.getOpcRegistrar()) ||
                ae.getSource().equals(frmInicial.getTbBtnRegistrar())) {
            frmInicial.getEscritorio().add(frmRegistro);
            frmRegistro.setVisible(true);
        }
        if(ae.getSource().equals(frmInicial.getOpcListado()) || 
                ae.getSource().equals(frmInicial.getTbBtnListado())) {
            frmInicial.getEscritorio().add(tableConsulta);
            tableConsulta.setVisible(true);
        }
        if(ae.getSource().equals(frmInicial.getOpcSalir())) {
            int resp = JOptionPane.showConfirmDialog(frmInicial, "Desea Terminar la Ejecucion?", 
                    "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                frmInicial.dispose();
            }
        }
        if(ae.getSource().equals(frmInicial.getTbTbtnFechaSist())) {
            if (frmInicial.getTbTbtnFechaSist().isSelected()) {
                Fecha fecha = new Fecha();
                frmInicial.getLblFechaSis().setText(fecha.toString());
                frmInicial.getTbInferior().setVisible(true);
            } else {
                frmInicial.getTbInferior().setVisible(false);
            }
        }
        if(ae.getSource().equals(frmInicial.getTbTbtnHoraSist())) {
            if (frmInicial.getTbTbtnFechaSist().isSelected()) {
                Hora hora = new Hora();
                frmInicial.getLblHoraSis().setText(hora.toString());
                frmInicial.getTbInferior().setVisible(true);
            }else{
                frmInicial.getTbInferior().setVisible(false);
            }
        }
        if(ae.getSource().equals(frmRegistro.getBtnAnterior())) {
            frmRegistro.getTabbedPane().setSelectedIndex(0);
        }
        if(ae.getSource().equals(frmRegistro.getBtnSiguiente())) {
            frmRegistro.getTabbedPane().setSelectedIndex(1);
        }   
        if(ae.getSource().equals(frmRegistro.getBtnRegistrar())) {
            objF.getPropietario().setId(frmRegistro.getTxtIdentificacion().getText());
            objF.getPropietario().setNombre(frmRegistro.getTxtNombre().getText());
            objF.getPropietario().setTel(frmRegistro.getTxtTelefono().getText());
            objF.getPropietario().setEmail(frmRegistro.getTxtCorreo().getText());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String []fecha = formato.format(frmRegistro.getCalendarProp().getDate()).split("/");
            objF.getPropietario().setfNac(
                    new Fecha(
                        Integer.parseInt(fecha[0]),
                        Integer.parseInt(fecha[1]),
                        Integer.parseInt(fecha[2])
                ));
            //Selecciona el tipo de vehiculo incresado y segun el seleccionado lo
            //instancia y guarda en la instancia de tipo formulario
            try{
                if (frmRegistro.getCmbTipoVehiculo().getSelectedIndex() == 0) {
                    Auto objA = new Auto();
                    objA.setPlaca(frmRegistro.getTxtPlaca().getText());
                    objA.setMarca(frmRegistro.getListMarca().getSelectedValue());
                    objA.setModelo(Integer.parseInt(frmRegistro.getSpnModelo().getValue().toString()));
                    objA.setValor(Double.parseDouble(frmRegistro.getTxtValor().getText()));
                    objA.valorImpuesto();
                    objF.setObjV(objA);
                }
                if (frmRegistro.getCmbTipoVehiculo().getSelectedIndex() == 1) {
                    Moto objM = new Moto();
                    objM.setPlaca(frmRegistro.getTxtPlaca().getText());
                    objM.setMarca(frmRegistro.getListMarca().getSelectedValue());
                    objM.setModelo(Integer.parseInt(frmRegistro.getSpnModelo().getValue().toString()));
                    objM.setValor(Double.parseDouble(frmRegistro.getTxtValor().getText()));
                    objM.setCilindraje(Double.parseDouble(frmRegistro.getTxtCilindraje().getText()));
                    objM.valorImpuesto();
                    objF.setObjV(objM);
                }
            }catch (NumberFormatException e){
                //System.out.println("Error de formato" +  e.getMessage()); //Error en consola
                //JOptionPane.showMessageDialog(frmInicial, "Error: " + e.toString()); //Error completo en ventana 
                String []dato = e.getMessage().split(":");
                JOptionPane.showMessageDialog(frmInicial, "Error: Datos numerico no validos" + dato[1]); //Error en ventana emergente
            }
            
            agregarDatosTabla(objF, tableConsulta.getTablaRegistro());
            
            JOptionPane.showMessageDialog(null, objF, toString(), 1);
            
            frmInicial.getEscritorio().add(tableConsulta);
            tableConsulta.setVisible(true);
        }
    }
    
    public void agregarDatosTabla(Formulario form, JTable tabla) {
        Object datos[] = {
            form.getNroF(),                                     //NroFormulario
            form.getPropietario().getNombre(),                  //Nombre Propietario
            form.getObjV() instanceof Auto ? "Auto" : "Moto",   //Tipo Vehiculo
            form.getObjV().getPlaca(),                          //Placa Vehiculo
            form.getObjV().getMarca(),                          //Marca Vehiculo
            form.getObjV().getModelo(),                         //Modelo Vehiculo
            form.getObjV() instanceof Auto ? "No Aplica" : ((Moto)(form.getObjV())).getCilindraje(),
            conversionDouble(form.getObjV().getValor()),        //Valor Vehiculo
            form.getObjV().valorImpuesto()                      //ValorImpuesto Vehiculo
        };
        
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        plantilla.addRow(datos);
    }
    
    public String conversionDouble(double conv) {
      Locale.setDefault(Locale.US);
      DecimalFormat num = new DecimalFormat("#,###");
      return num.format(conv);
    }
}
