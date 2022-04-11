/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import persistencia.Visitante;
import persistencia.VisitantesDAO;
import presentacion.IUsuario;

/**
 *
 * @author amazo_000
 */
public class ControlVisitas implements ActionListener {
    
    private IUsuario IU;
    private VisitantesDAO vDao;

    public ControlVisitas(IUsuario IU) {
        this.IU = IU;
        this.vDao= new VisitantesDAO();
        this.IU.BotonCargar.addActionListener(this);
        this.IU.BotonGuardar.addActionListener(this);
        this.IU.BotonEliminar.addActionListener(this);
        this.IU.BotonCerrar.addActionListener(this);
    }

    public IUsuario getIU() {
        return IU;
    }

    public void setIU(IUsuario IU) {
        this.IU = IU;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.IU.BotonCargar){
            this.cargar();
        }
        
        if(e.getSource()==this.IU.BotonCerrar){
            this.cerrar();
        }
        
        if(e.getSource()==this.IU.BotonEliminar){
            this.eliminar();
        }
        
        if(e.getSource()==this.IU.BotonGuardar){
            this.guardar();
        }
        
        
    }
    
    
    public void cargar(){
        
        DefaultTableModel modelo = new DefaultTableModel(new Object [][] {},new String [] {"Fecha", "Documento", "Nombres","Apellidos"});
        
        String apartamento=String.valueOf(IU.boxApartamentos.getSelectedItem());
        ArrayList<Visitante> resp =vDao.cargarVisitantes(apartamento);
        Iterator<Visitante> vs = resp.iterator();
        
        while(vs.hasNext()){
        
            Visitante v = vs.next();
            String [] fila = new String[4];
            fila[0]= v.getFechaIgreso();
            fila[1]=v.getDocumento();
            fila[2]=v.getNombres();
            fila[3]=v.getApellidos();
            modelo.addRow(fila);
                 
            
        
        }
        IU.Tabla.setModel(modelo);
        
    }
     
    
    public void eliminar(){
        
        String documento=IU.textDocumento.getText();
        vDao.eliminar(documento);
        cargar();
    }
    
    
    public void guardar(){
        
        String tipDoc=String.valueOf(IU.boxDocumentos.getSelectedItem());
        String documento=IU.textDocumento.getText();
        String nombres=IU.textNombres.getText();
        String apellidos=IU.textApellidos.getText();
        String fechaIgreso=IU.textFechas.getText();
        String idApartamento= String.valueOf(IU.boxApartamentos.getSelectedItem());
        
        Visitante vs=new Visitante(tipDoc,documento,nombres,apellidos,fechaIgreso,idApartamento);
        vDao.insertar(vs);
        cargar();
    }
    
    
    public void cerrar(){
        IU.setVisible(false);;
    
    }
    
}
