/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import logica.ControlVisitas;
import persistencia.Visitante;
import presentacion.IUsuario;

/**
 *
 * @author amazo_000
 */
public class Ejecutar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IUsuario IU = new IUsuario();
        ControlVisitas CV= new ControlVisitas(IU);
        CV.getIU().setVisible(true);
        
        
        
    }
    
}
