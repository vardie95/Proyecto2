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
public class ModificarPrecio extends javax.swing.JPanel {
    ArrayList llave= new ArrayList();

    /**
     * Creates new form RegistroFermentacion
     */
    public ModificarPrecio() {
        initComponents();
        llenarpais();
    }
    public final  void llenarpais() {
        jComboBox2.removeAllItems();
        llave.clear();
            try {
            Connection con = proyectocerveza.dbConnection.conectDB();
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getCerveza");
                while(rs.next()){
                   llave.add(rs.getInt(1));
                   jComboBox2.addItem(rs.getString("Descripcion"));
                }
                
            } catch (SQLException ex) {
               
            }
    }
    public void ModificarPrecio(){
        Connection con= null;
            int precio=Integer.parseInt(jTextField2.getText());
            con= proyectocerveza.dbConnection.conectDB();
            try {
                int id_Cerveza=(int) llave.get(jComboBox2.getSelectedIndex());
                CallableStatement proc= con.prepareCall("{call ModificarPrecio(?,?)}");
                proc.setInt(1, id_Cerveza);
                proc.setInt(2,precio);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Precio Modificado Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
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

        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jTextField2.setBackground(new java.awt.Color(217, 217, 148));
        add(jTextField2);
        jTextField2.setBounds(290, 210, 225, 31);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cerveza: ");
        add(jLabel3);
        jLabel3.setBounds(200, 140, 74, 31);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio: ");
        add(jLabel4);
        jLabel4.setBounds(200, 220, 80, 20);

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(320, 310, 130, 50);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Modificar Precio Cerveza");
        add(jLabel13);
        jLabel13.setBounds(300, 50, 230, 22);

        add(jComboBox2);
        jComboBox2.setBounds(290, 140, 230, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, -40, 840, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (jTextField2.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            ModificarPrecio();
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
