/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author amazo_000
 */
public class ConexionBD {
    
    private Connection conex;
    
    public Connection conectar(){
    
    try{
        
        String ruta = System.getProperty("user.dir");
        Class.forName("org.sqlite.JDBC");
        this.conex = DriverManager.getConnection("jdbc:sqlite:" +ruta + "\\BDatos.db");
        System.out.println("Conexion Exitosa");
        
    }catch(Exception ex){
    
    System.out.println("Se ha producido un error en el metodo getCon: " + ex.getMessage());
    
    }
        return conex;
    
    }
    
    
}
