/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author amazo_000
 */
public class Visitante {
    
    int id;
    String tipDoc;
    String documento;
    String nombres;
    String apellidos;
    String fechaIgreso;
    String idApartamento;

    public Visitante() {
    }

    public Visitante(String tipDoc, String documento, String nombres, String apellidos, String fechaIgreso, String idApartamento) {
        this.tipDoc = tipDoc;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIgreso = fechaIgreso;
        this.idApartamento = idApartamento;
    }
    
    

    public Visitante(int id,String tipDoc, String documento, String nombres, String apellidos, String fechaIgreso, String idApartamento) {
        this.id = id;
        this.tipDoc = tipDoc;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIgreso = fechaIgreso;
        this.idApartamento = idApartamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaIgreso() {
        return fechaIgreso;
    }

    public void setFechaIgreso(String fechaIgreso) {
        this.fechaIgreso = fechaIgreso;
    }

    public String getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(String idApartamento) {
        this.idApartamento = idApartamento;
    }
    
    
    
    
          
    
}
