/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author amazo_000
 */
public class VisitantesDAO {
    
    
    private ConexionBD con;
    private Connection conSQL;
    private PreparedStatement ps;
    private ResultSet resultado;

    public VisitantesDAO() {
        
        this.con=new ConexionBD();
        this.conSQL = this.con.conectar();
        
    }
    
    public ArrayList<Visitante> cargarVisitantes(String apartamento){
    
        ArrayList<Visitante> visitantes = new ArrayList<>();
        String consultaSQL = "SELECT * FROM visitas WHERE idApartamento = ?";
        
        try{
        
            this.ps = this.conSQL.prepareStatement(consultaSQL);
            this.ps.setString(1, apartamento);
            this.resultado = ps.executeQuery();
            
            while(resultado.next()){
                
                Visitante vs = new Visitante(Integer.parseInt(resultado.getString("id")),resultado.getString("tipDoc"),resultado.getString("documento"),resultado.getString("nombres"),resultado.getString("apellidos"),resultado.getString("fechaIgreso"),resultado.getString("idApartamento"));
                visitantes.add(vs);  
            }
             
        }catch (Exception ex){  
            System.out.println("Error en la consulta"); 
        } 
        return visitantes;
    }
    
    
    public boolean insertar(Visitante v){
    
        boolean conf=false;
        String consultaSQL = "INSERT INTO visitas (tipDoc,documento,nombres,apellidos,fechaIgreso,idApartamento) VALUES (?,?,?,?,?,?)";
        
        try{
            this.ps = this.conSQL.prepareStatement(consultaSQL);
            this.ps.setString(1,v.getTipDoc());
            this.ps.setString(2,v.getDocumento());
            this.ps.setString(3,v.getNombres());
            this.ps.setString(4,v.getApellidos());
            this.ps.setString(5,v.getFechaIgreso());
            this.ps.setString(6,v.getIdApartamento());
            
            if(this.ps.executeUpdate()>0){
                conf=true;
                JOptionPane.showMessageDialog(null, "Visitante insertado correctamente");
            }else{
            
                JOptionPane.showMessageDialog(null, "No fue posible insertar el visitante");
            }
        
        
        }catch(Exception ex){
            System.out.println("Error= "+ex.getMessage());
        }
        
        
        
    
    return conf;
    }
    
    public boolean eliminar(String documento){
    
        boolean tarea=false;
        String consultaSQL = "DELETE FROM Visitas WHERE documento = ?";
        
        try{
            
            this.ps = this.conSQL.prepareStatement(consultaSQL);
            this.ps.setString(1,documento);
           
            if(this.ps.executeUpdate()>0){
                tarea=true;
                JOptionPane.showMessageDialog(null,"Visita eliminada");
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible eliminar el visitante");
            }
            
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
  
    return tarea;
    }
    
    
}
