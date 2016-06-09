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
public class RegistroCerveza extends javax.swing.JPanel {
    ArrayList llavesFamilia= new ArrayList();
    ArrayList llavesCuerpo= new ArrayList();
    ArrayList llavesFermentacion= new ArrayList();
    ArrayList llavesEstilo= new ArrayList();
    ArrayList llavesTipo= new ArrayList();
    ArrayList llavesColor= new ArrayList();
    /**
     * Creates new form RegistroCerveza
     */
    public RegistroCerveza() {
        initComponents();
        LlenarFamilia();
        LlenarCuerpo();
        LlenarFermentacion();
        LlenarEstilo();
        LlenarColor();
    }
    public final void LlenarFamilia()
    {
       jComboBox5.removeAllItems();
       llavesFamilia.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getFamilia");
                while(rs.next()){
                   llavesFamilia.add(rs.getInt(1));
                   jComboBox5.addItem(rs.getString("Descripcion"));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
    public final void LlenarCuerpo()
    {
       jComboBox1.removeAllItems();
       llavesCuerpo.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getCuerpo");
                while(rs.next()){
                   llavesCuerpo.add(rs.getInt(1));
                   jComboBox1.addItem(rs.getString("Descripción"));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
    public final void LlenarColor()
    {
       jComboBox2.removeAllItems();
       llavesColor.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getColor");
                while(rs.next()){
                   llavesColor.add(rs.getInt(1));
                   jComboBox2.addItem(rs.getString("Descripción"));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
     public final void LlenarFermentacion()
    {
       jComboBox3.removeAllItems();
       llavesFermentacion.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getFermentacion");
                while(rs.next()){
                   llavesFermentacion.add(rs.getInt(1));
                   jComboBox3.addItem(rs.getString("Descripción"));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
   public final void LlenarEstilo()
    {
       jComboBox4.removeAllItems();
       llavesEstilo.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getEstilo");
                while(rs.next()){
                   llavesEstilo.add(rs.getInt(1));
                   jComboBox4.addItem(rs.getString("Descripción"));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
   public final void LlenarTipo()
    {
       jComboBox6.removeAllItems();
       llavesTipo.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int idFamilia=(int)llavesFamilia.get(jComboBox5.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call gettipo("+idFamilia+")");
                while(rs.next()){
                   llavesTipo.add(rs.getInt(1));
                   jComboBox6.addItem(rs.getString("Descripcion"));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
public final void InsertCerveza(){
        String nombre=TF_Descripcion1.getText();
        String Temp=TF_Descripcion2.getText();
        String precio=TF_Descripcion3.getText();
        Connection con= null;
        con= proyectocerveza.dbConnection.conectDB();
            try {
                CallableStatement proc= con.prepareCall("{call insertCerveza(?,?,?,?,?,?,?,?)}");
                proc.setString(1, nombre);
                proc.setString(2, Temp);
                proc.setString(3, precio);
                proc.setInt(4, (int) llavesCuerpo.get(jComboBox1.getSelectedIndex()));
                proc.setInt(5, (int) llavesColor.get(jComboBox2.getSelectedIndex()));
                proc.setInt(6, (int) llavesFermentacion.get(jComboBox3.getSelectedIndex()));
                proc.setInt(7, (int) llavesEstilo.get(jComboBox4.getSelectedIndex()));
                proc.setInt(8, (int) llavesTipo.get(jComboBox6.getSelectedIndex()));
                proc.execute();
                JOptionPane.showMessageDialog(this," Cerveza Registrada Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                TF_Descripcion1.setText("");
                TF_Descripcion2.setText("");
                TF_Descripcion3.setText("");
                con.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error:"+ex,null,JOptionPane.ERROR_MESSAGE);

            }
    
    
    
    
    }
    private static boolean isNumeric(String cadena){
            try {
                    Integer.parseInt(cadena);
                    return true;
            } catch (NumberFormatException nfe){
                    return false;
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        TF_Descripcion1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TF_Descripcion2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        TF_Descripcion3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre");
        add(jLabel1);
        jLabel1.setBounds(60, 70, 80, 16);

        jComboBox1.setBackground(new java.awt.Color(251, 251, 140));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(200, 110, 210, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cuerpo");
        add(jLabel2);
        jLabel2.setBounds(60, 110, 80, 20);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Color");
        add(jLabel3);
        jLabel3.setBounds(60, 160, 80, 16);

        jComboBox2.setBackground(new java.awt.Color(251, 251, 140));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox2);
        jComboBox2.setBounds(200, 160, 210, 20);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fermentación: ");
        add(jLabel4);
        jLabel4.setBounds(60, 210, 100, 16);

        jComboBox3.setBackground(new java.awt.Color(251, 251, 140));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox3);
        jComboBox3.setBounds(200, 210, 210, 20);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estilo: ");
        add(jLabel5);
        jLabel5.setBounds(60, 260, 100, 16);

        jComboBox4.setBackground(new java.awt.Color(251, 251, 140));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox4);
        jComboBox4.setBounds(200, 260, 210, 20);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Familia: ");
        add(jLabel6);
        jLabel6.setBounds(60, 320, 100, 16);

        jComboBox5.setBackground(new java.awt.Color(251, 251, 140));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        add(jComboBox5);
        jComboBox5.setBounds(200, 310, 210, 20);

        jComboBox6.setBackground(new java.awt.Color(251, 251, 140));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox6);
        jComboBox6.setBounds(200, 360, 210, 20);

        TF_Descripcion1.setBackground(new java.awt.Color(222, 222, 172));
        TF_Descripcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_Descripcion1ActionPerformed(evt);
            }
        });
        add(TF_Descripcion1);
        TF_Descripcion1.setBounds(200, 60, 164, 20);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tipo: ");
        add(jLabel8);
        jLabel8.setBounds(57, 370, 100, 16);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Temperatura: ");
        add(jLabel9);
        jLabel9.setBounds(60, 400, 100, 16);

        TF_Descripcion2.setBackground(new java.awt.Color(222, 222, 172));
        TF_Descripcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_Descripcion2ActionPerformed(evt);
            }
        });
        add(TF_Descripcion2);
        TF_Descripcion2.setBounds(200, 400, 140, 20);

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(560, 200, 120, 50);

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Precio:   ");
        add(jLabel10);
        jLabel10.setBounds(60, 430, 80, 16);

        TF_Descripcion3.setBackground(new java.awt.Color(222, 222, 172));
        TF_Descripcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_Descripcion3ActionPerformed(evt);
            }
        });
        add(TF_Descripcion3);
        TF_Descripcion3.setBounds(200, 440, 120, 20);

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Registro Cerveza");
        add(jLabel11);
        jLabel11.setBounds(280, 20, 200, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        add(jLabel7);
        jLabel7.setBounds(0, 0, 870, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void TF_Descripcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_Descripcion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_Descripcion1ActionPerformed

    private void TF_Descripcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_Descripcion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_Descripcion2ActionPerformed

    private void TF_Descripcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_Descripcion3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_Descripcion3ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jComboBox5){
            if(jComboBox5.getSelectedItem()!=null){
                LlenarTipo();
            }
        }
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (TF_Descripcion1.getText().length()==0  || TF_Descripcion2.getText().length()==0 || TF_Descripcion3.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else if(isNumeric(TF_Descripcion2.getText()) || isNumeric(TF_Descripcion3.getText())){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos con datos correctos.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            InsertCerveza();
        }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_Descripcion1;
    private javax.swing.JTextField TF_Descripcion2;
    private javax.swing.JTextField TF_Descripcion3;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables


}
