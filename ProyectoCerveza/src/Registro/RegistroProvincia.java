/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Diego
 */
public class RegistroProvincia extends javax.swing.JPanel {
    ArrayList llave= new ArrayList();
    ArrayList llavesProvincia= new ArrayList();

    /**
     * Creates new form RegistroFermentacion
     */
    public RegistroProvincia() {
        initComponents();
        Modificar.setVisible(false);
        Eliminar.setVisible(false);
        llenarpais();
    }
    public final  void llenarpais() {
        jComboBox2.removeAllItems();
        llave.clear();
            try {
            Connection con = proyectocerveza.dbConnection.conectDB();
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getPais");
                while(rs.next()){
                   llave.add(rs.getInt(1));
                   jComboBox2.addItem(rs.getString("Descripción"));
                }
                
            } catch (SQLException ex) {
               
            }
    }
    
     public final void LlenarProvincia()
    {
       CB_Provincia.removeAllItems();
       llavesProvincia.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int id_pais=(int) llave.get(CB_Pais.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getProvincia("+id_pais+")");
                while(rs.next()){
                   llavesProvincia.add(rs.getInt(1));
                   CB_Provincia.addItem(rs.getString("Descripción"));
                }
                
              con.close();
            } catch (SQLException ex) {
                
            }
   
   }
    
    
    public void InsertProvincia(){
        Connection con= null;
            String puesto=jTextField2.getText();
            con= proyectocerveza.dbConnection.conectDB();
            try {
                int id_pais=(int) llave.get(jComboBox2.getSelectedIndex());
                CallableStatement proc= con.prepareCall("{call insertProvincia(?,?)}");
                proc.setInt(2, id_pais);
                proc.setString(1,puesto);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Provincia Agregada Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Registro = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        Modificar = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        CB_Provincia = new javax.swing.JComboBox();
        jButton13 = new javax.swing.JButton();
        CB_Pais = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();

        setLayout(null);

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        Registro.setLayout(null);

        jTextField2.setBackground(new java.awt.Color(217, 217, 148));
        Registro.add(jTextField2);
        jTextField2.setBounds(290, 210, 225, 31);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pais: ");
        Registro.add(jLabel3);
        jLabel3.setBounds(200, 140, 74, 31);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Provincia: ");
        Registro.add(jLabel4);
        jLabel4.setBounds(200, 220, 80, 20);

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Registro.add(jButton4);
        jButton4.setBounds(160, 360, 120, 50);

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Registro.add(jButton5);
        jButton5.setBounds(330, 360, 130, 50);

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Registro.add(jButton6);
        jButton6.setBounds(510, 360, 130, 50);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Registro Provincia");
        Registro.add(jLabel13);
        jLabel13.setBounds(320, 50, 180, 22);

        Registro.add(jComboBox2);
        jComboBox2.setBounds(290, 140, 230, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        Registro.add(jLabel1);
        jLabel1.setBounds(0, -30, 840, 590);

        jLayeredPane1.add(Registro);

        Modificar.setLayout(null);

        jTextField3.setBackground(new java.awt.Color(217, 217, 148));
        Modificar.add(jTextField3);
        jTextField3.setBounds(290, 270, 225, 31);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pais: ");
        Modificar.add(jLabel5);
        jLabel5.setBounds(190, 140, 74, 31);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nueva Provincia:");
        Modificar.add(jLabel6);
        jLabel6.setBounds(190, 280, 100, 20);

        jButton9.setText("Modicar");
        Modificar.add(jButton9);
        jButton9.setBounds(250, 360, 130, 50);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Modificar Provincia");
        Modificar.add(jLabel14);
        jLabel14.setBounds(320, 50, 180, 22);

        Modificar.add(CB_Provincia);
        CB_Provincia.setBounds(290, 200, 230, 30);

        jButton13.setText("Volver");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        Modificar.add(jButton13);
        jButton13.setBounds(430, 360, 130, 50);

        Modificar.add(CB_Pais);
        CB_Pais.setBounds(290, 140, 230, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Provincia: ");
        Modificar.add(jLabel9);
        jLabel9.setBounds(190, 210, 80, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        Modificar.add(jLabel2);
        jLabel2.setBounds(0, -30, 840, 590);

        jLayeredPane1.add(Modificar);

        Eliminar.setLayout(null);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pais: ");
        Eliminar.add(jLabel7);
        jLabel7.setBounds(200, 140, 74, 31);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Provincia: ");
        Eliminar.add(jLabel8);
        jLabel8.setBounds(200, 220, 80, 20);

        jButton11.setText("Volver");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        Eliminar.add(jButton11);
        jButton11.setBounds(430, 360, 130, 50);

        jButton12.setText("Eliminar");
        Eliminar.add(jButton12);
        jButton12.setBounds(250, 360, 130, 50);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Eliminar Provincia");
        Eliminar.add(jLabel15);
        jLabel15.setBounds(320, 50, 180, 22);

        Eliminar.add(jComboBox4);
        jComboBox4.setBounds(290, 210, 230, 30);

        Eliminar.add(jComboBox6);
        jComboBox6.setBounds(290, 140, 230, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        Eliminar.add(jLabel10);
        jLabel10.setBounds(0, -40, 840, 590);

        jLayeredPane1.add(Eliminar);

        add(jLayeredPane1);
        jLayeredPane1.setBounds(-2, 0, 840, 490);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTextField2.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            InsertProvincia();
        }
    
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

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        Modificar.setVisible(false);
        Registro.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        Registro.setVisible(true);
        Eliminar.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_Pais;
    private javax.swing.JComboBox CB_Provincia;
    private javax.swing.JPanel Eliminar;
    private javax.swing.JPanel Modificar;
    private javax.swing.JPanel Registro;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
