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
        Modificar.setVisible(false);
        Eliminar.setVisible(false);
    }
    public void InsertFermentacion(){
        Connection con= null;
            String nombre=jTextField4.getText();
            String Tiempo=jTextField3.getText();
            con= proyectocerveza.dbConnection.conectDB();
            try {
                
                CallableStatement proc= con.prepareCall("{call insertFermentacion(?,?)}");
                proc.setString(1, nombre);
                proc.setString(2, Tiempo);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Tipo de Fermentación Exitosamente Agregado",null,JOptionPane.INFORMATION_MESSAGE);
                jTextField4.setText("");
                jTextField3.setText("");
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Registro = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Modificar = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();

        setLayout(null);

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        Registro.setLayout(null);

        jTextField3.setBackground(new java.awt.Color(217, 217, 148));
        Registro.add(jTextField3);
        jTextField3.setBounds(290, 210, 225, 31);

        jLabel3.setText("Nombre: ");
        Registro.add(jLabel3);
        jLabel3.setBounds(180, 140, 74, 31);

        jLabel4.setText("Tiempo: ");
        Registro.add(jLabel4);
        jLabel4.setBounds(180, 220, 80, 20);

        jTextField4.setBackground(new java.awt.Color(217, 217, 148));
        Registro.add(jTextField4);
        jTextField4.setBounds(290, 140, 225, 31);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Registro Fermentación");
        Registro.add(jLabel12);
        jLabel12.setBounds(290, 60, 180, 22);

        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Registro.add(jButton4);
        jButton4.setBounds(160, 330, 120, 50);

        jButton5.setText("Modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Registro.add(jButton5);
        jButton5.setBounds(330, 330, 130, 50);

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Registro.add(jButton6);
        jButton6.setBounds(510, 330, 130, 50);

        jLayeredPane1.add(Registro);

        Modificar.setLayout(null);

        jTextField5.setBackground(new java.awt.Color(217, 217, 148));
        Modificar.add(jTextField5);
        jTextField5.setBounds(290, 240, 225, 31);

        jLabel5.setText("Fermentación:");
        Modificar.add(jLabel5);
        jLabel5.setBounds(160, 120, 120, 31);

        jLabel6.setText("Nuevo Tiempo:");
        Modificar.add(jLabel6);
        jLabel6.setBounds(160, 250, 110, 20);

        jTextField6.setBackground(new java.awt.Color(217, 217, 148));
        Modificar.add(jTextField6);
        jTextField6.setBounds(290, 190, 225, 31);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Modificar Fermentación");
        Modificar.add(jLabel13);
        jLabel13.setBounds(280, 60, 200, 22);

        jButton8.setText("Modificar");
        Modificar.add(jButton8);
        jButton8.setBounds(240, 330, 130, 50);

        jButton9.setText("Volver");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        Modificar.add(jButton9);
        jButton9.setBounds(420, 330, 130, 50);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Modificar.add(jComboBox3);
        jComboBox3.setBounds(290, 120, 220, 30);

        jLabel9.setText("Nueva Fermentación:");
        Modificar.add(jLabel9);
        jLabel9.setBounds(160, 190, 130, 31);

        jLayeredPane1.add(Modificar);

        Eliminar.setLayout(null);

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(217, 217, 148));
        Eliminar.add(jTextField7);
        jTextField7.setBounds(290, 210, 225, 31);

        jLabel7.setText("Nombre: ");
        Eliminar.add(jLabel7);
        jLabel7.setBounds(180, 140, 74, 31);

        jLabel8.setText("Tiempo: ");
        Eliminar.add(jLabel8);
        jLabel8.setBounds(180, 220, 80, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Eliminar Fermentación");
        Eliminar.add(jLabel14);
        jLabel14.setBounds(290, 60, 180, 22);

        jButton11.setText("Eliminar");
        Eliminar.add(jButton11);
        jButton11.setBounds(220, 320, 130, 50);

        jButton12.setText("Volver");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        Eliminar.add(jButton12);
        jButton12.setBounds(400, 320, 130, 50);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Eliminar.add(jComboBox2);
        jComboBox2.setBounds(290, 140, 220, 30);

        jLayeredPane1.add(Eliminar);

        add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 0, 780, 420);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Modificar.setVisible(true);
        Registro.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Registro.setVisible(false);
        Eliminar.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Modificar.setVisible(false);
        Registro.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        Registro.setVisible(true);
        Eliminar.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Eliminar;
    private javax.swing.JPanel Modificar;
    private javax.swing.JPanel Registro;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
