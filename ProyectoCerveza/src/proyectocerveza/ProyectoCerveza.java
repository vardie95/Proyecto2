/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocerveza;

import Interfaz.Inicio;

/**
 *
 * @author Luis Diego
 */
public class ProyectoCerveza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Inicio().setVisible(true);
        //new Interfaz.InicioSesion().setVisible(true);
      }
    });
    }
    
}
