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

public class RegistroPais extends javax.swing.JPanel {

    /**
     * Creates new form RegistroFermentacion
     */
    public RegistroPais() {
        initComponents();
    }
    public void InsertPais(){
        Connection con= null;
            String puesto=jTextField2.getText();
            con=proyectocerveza.dbConnection.conectDB();
            try {
                CallableStatement proc= con.prepareCall("{call insertPais(?)}");
                proc.setString(1, puesto);
                proc.execute();
                JOptionPane.showMessageDialog(this, "País Agregado Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                jTextField2.setText("");
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

        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setText("Pais: ");
        add(jLabel1);
        jLabel1.setBounds(160, 140, 74, 31);

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Registro Pais");
        add(jLabel12);
        jLabel12.setBounds(320, 50, 180, 22);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTextField2.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE); 
        }
        else{
            InsertPais();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
