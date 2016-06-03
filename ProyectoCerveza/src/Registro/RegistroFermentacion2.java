/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Diego
 */
public class RegistroFermentacion2 extends javax.swing.JPanel {

    /**
     * Creates new form RegistroFermentacion
     */
    public RegistroFermentacion2() {
        initComponents();
    }
    public void InsertFermentacion(){
        Connection con= null;
            String nombre=jTextField2.getText();
            String Tiempo=jTextField1.getText();
            con= proyectocerveza.dbConnection.conectDB();
            try {
                
                CallableStatement proc= con.prepareCall("{call insertFermentacion(?,?)}");
                proc.setString(1, nombre);
                proc.setString(2, Tiempo);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Tipo de Fermentación Exitosamente Agregado",null,JOptionPane.INFORMATION_MESSAGE);
                jTextField2.setText("");
                jTextField1.setText("");
                con.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error:"+ex,null,JOptionPane.ERROR_MESSAGE);

            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setLayout(null);

        jTextField1.setBackground(new java.awt.Color(217, 217, 148));
        add(jTextField1);
        jTextField1.setBounds(290, 210, 225, 31);

        jLabel1.setText("Nombre: ");
        add(jLabel1);
        jLabel1.setBounds(160, 140, 74, 31);

        jLabel2.setText("Tiempo: ");
        add(jLabel2);
        jLabel2.setBounds(160, 220, 80, 20);

        jTextField2.setBackground(new java.awt.Color(217, 217, 148));
        add(jTextField2);
        jTextField2.setBounds(290, 140, 225, 31);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(160, 360, 120, 50);

        jButton2.setText("Modificar");
        add(jButton2);
        jButton2.setBounds(330, 360, 130, 50);

        jButton3.setText("Eliminar");
        add(jButton3);
        jButton3.setBounds(510, 360, 130, 50);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Registro Fermentación");
        add(jLabel11);
        jLabel11.setBounds(290, 60, 180, 22);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTextField2.getText().length()==0 || jTextField1.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            InsertFermentacion();
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
