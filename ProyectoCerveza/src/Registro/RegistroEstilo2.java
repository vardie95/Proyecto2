/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Diego
 */
public class RegistroEstilo2 extends javax.swing.JPanel {
    ArrayList llavesEstilo=new ArrayList();

    /**
     * Creates new form RegistroFermentacion
     */
    public RegistroEstilo2() {
        initComponents();
        Modificar.setVisible(false);
        Eliminar.setVisible(false);
    }
    public void InsertEstilo(){
        Connection con= null;
            String puesto=jTextField3.getText();
            con= proyectocerveza.dbConnection.conectDB();
            try {
                
                CallableStatement proc= con.prepareCall("{call insertEstilo(?)}");
                proc.setString(1, puesto);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Estilo Agregado Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                jTextField3.setText("");
                con.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error:"+ex,null,JOptionPane.ERROR_MESSAGE);

            }
    }
    public final void LlenarEstilo()
    {
       jComboBox1.removeAllItems();
       llavesEstilo.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getEstilo");
                while(rs.next()){
                   llavesEstilo.add(rs.getInt(1));
                   jComboBox1.addItem(rs.getString("Descripción"));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
    public void ModificarCuerpo(){
        Connection con= null;
            int pID=(int) llavesEstilo.get(jComboBox1.getSelectedIndex());
            String puesto=jTextField4.getText();
            con= proyectocerveza.dbConnection.conectDB();
            try {
                
                CallableStatement proc= con.prepareCall("{call modificarEstili(?,?)}");
                proc.setInt(1, pID);
                proc.setString(2, puesto);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Estilo Modificado Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                jTextField4.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Modificar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();

        setLayout(null);

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        Registro.setLayout(null);

        jLabel2.setText("Nombre: ");
        Registro.add(jLabel2);
        jLabel2.setBounds(160, 140, 74, 31);

        jTextField3.setBackground(new java.awt.Color(217, 217, 148));
        Registro.add(jTextField3);
        jTextField3.setBounds(290, 140, 225, 31);

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Registro Estilo");
        Registro.add(jLabel12);
        jLabel12.setBounds(320, 50, 180, 22);

        jLayeredPane1.add(Registro);

        Modificar.setLayout(null);

        jLabel3.setText("Nuevo Estilo:");
        Modificar.add(jLabel3);
        jLabel3.setBounds(190, 190, 80, 31);

        jTextField4.setBackground(new java.awt.Color(217, 217, 148));
        Modificar.add(jTextField4);
        jTextField4.setBounds(290, 190, 225, 31);

        jButton8.setText("Modificar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Modificar.add(jButton8);
        jButton8.setBounds(220, 320, 130, 50);

        jButton9.setText("Volver");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        Modificar.add(jButton9);
        jButton9.setBounds(400, 320, 130, 50);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Modificar Estilo");
        Modificar.add(jLabel13);
        jLabel13.setBounds(320, 50, 180, 22);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Modificar.add(jComboBox1);
        jComboBox1.setBounds(290, 140, 220, 30);

        jLabel5.setText("Estilo:");
        Modificar.add(jLabel5);
        jLabel5.setBounds(190, 140, 74, 31);

        jLayeredPane1.add(Modificar);

        Eliminar.setLayout(null);

        jLabel4.setText("Estilo:");
        Eliminar.add(jLabel4);
        jLabel4.setBounds(190, 140, 74, 31);

        jButton11.setText("Eliminar");
        Eliminar.add(jButton11);
        jButton11.setBounds(210, 320, 130, 50);

        jButton12.setText("Volver");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        Eliminar.add(jButton12);
        jButton12.setBounds(390, 320, 130, 50);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Eliminar Estilo");
        Eliminar.add(jLabel14);
        jLabel14.setBounds(320, 50, 180, 22);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Eliminar.add(jComboBox2);
        jComboBox2.setBounds(290, 140, 220, 30);

        jLayeredPane1.add(Eliminar);

        add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 0, 710, 430);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTextField3.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            InsertEstilo();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Modificar.setVisible(true);
        Registro.setVisible(false);
        LlenarEstilo();
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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        ModificarCuerpo();
        LlenarEstilo();
    }//GEN-LAST:event_jButton8ActionPerformed


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
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
