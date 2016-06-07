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
public class ModificarCerveza extends javax.swing.JPanel {
    ArrayList llavesFamilia= new ArrayList();
    ArrayList llavesCuerpo= new ArrayList();
    ArrayList llavesFermentacion= new ArrayList();
    ArrayList llavesEstilo= new ArrayList();
    ArrayList llavesTipo= new ArrayList();
    ArrayList llavesColor= new ArrayList();
    ArrayList llavesCerveza= new ArrayList();
    /**
     * Creates new form RegistroCerveza
     */
    public ModificarCerveza() {
        initComponents();
        LlenarFamilia();
        LlenarCuerpo();
        LlenarFermentacion();
        LlenarEstilo();
        LlenarColor();
        LlenarCerveza();
    }
    public final void LlenarCerveza()
    {
       CB_Nombre.removeAllItems();
       llavesCerveza.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getCerveza");
                while(rs.next()){
                   llavesCerveza.add(rs.getInt(1));
                   CB_Nombre.addItem(rs.getString("Descripcion"));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
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
   
   public final void LlenarDatos()
    {
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int idFamilia=(int)llavesCerveza.get(CB_Nombre.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getDatosCerveza("+idFamilia+")");
                while(rs.next()){
                       TF_Nombre.setText(CB_Nombre.getSelectedItem().toString());
                       TF_Temperatura.setText(rs.getString(1));
                       jComboBox2.setSelectedIndex(rs.getInt(3)-1);
                       jComboBox1.setSelectedIndex(rs.getInt(4)-1);
                       jComboBox4.setSelectedIndex(rs.getInt(5)-1);
                       jComboBox3.setSelectedIndex(rs.getInt(6)-1);
                       jComboBox5.setSelectedIndex(rs.getInt(7)-1);
                       jComboBox6.setSelectedItem(rs.getString(2));
                       
                      
                       
                       
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
public final void ModficarCerveza(){
        int idCerveza=(int) llavesCerveza.get(CB_Nombre.getSelectedIndex());
        String Temp=TF_Temperatura.getText();
        String Temp2=TF_Nombre.getText();
        //El modificar es muy parecido al codigo del insert ud pasa por parametro todo los datos como estan
        //y ademas manda el idCerveza que esta arriba 
        Connection con= null;
        con= proyectocerveza.dbConnection.conectDB();
            try {
                CallableStatement proc= con.prepareCall("call modificar_cerveza(?,?,?,?,?,?,?,?)");
                proc.setInt(1, idCerveza);
                proc.setString(2, Temp2);//Nombre
                proc.setString(3, Temp);//Temperatura
                proc.setInt(4, (int) llavesCuerpo.get(jComboBox1.getSelectedIndex()));
                proc.setInt(5, (int) llavesColor.get(jComboBox2.getSelectedIndex()));
                proc.setInt(6, (int) llavesFermentacion.get(jComboBox3.getSelectedIndex()));
                proc.setInt(7, (int) llavesEstilo.get(jComboBox4.getSelectedIndex()));
                proc.setInt(8, (int) llavesTipo.get(jComboBox6.getSelectedIndex()));
                proc.execute();
                JOptionPane.showMessageDialog(this," Cerveza Modificada Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
               
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
        jComboBox1 = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<String>();
        jComboBox6 = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TF_Temperatura = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        CB_Nombre = new javax.swing.JComboBox<String>();
        TF_Nombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Nombre:");
        add(jLabel1);
        jLabel1.setBounds(60, 110, 120, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(200, 150, 160, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cuerpo:");
        add(jLabel2);
        jLabel2.setBounds(60, 150, 80, 20);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Color:");
        add(jLabel3);
        jLabel3.setBounds(60, 200, 80, 16);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox2);
        jComboBox2.setBounds(200, 200, 160, 20);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fermentación: ");
        add(jLabel4);
        jLabel4.setBounds(60, 250, 100, 16);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox3);
        jComboBox3.setBounds(200, 250, 160, 20);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estilo: ");
        add(jLabel5);
        jLabel5.setBounds(60, 300, 100, 16);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox4);
        jComboBox4.setBounds(200, 300, 160, 20);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Familia: ");
        add(jLabel6);
        jLabel6.setBounds(60, 360, 100, 16);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        add(jComboBox5);
        jComboBox5.setBounds(200, 350, 160, 20);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox6);
        jComboBox6.setBounds(200, 400, 160, 20);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tipo: ");
        add(jLabel8);
        jLabel8.setBounds(60, 410, 100, 16);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Temperatura: ");
        add(jLabel9);
        jLabel9.setBounds(60, 440, 100, 16);

        TF_Temperatura.setBackground(new java.awt.Color(222, 222, 172));
        TF_Temperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_TemperaturaActionPerformed(evt);
            }
        });
        add(TF_Temperatura);
        TF_Temperatura.setBounds(200, 440, 140, 20);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(560, 190, 120, 50);

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Modificar Cerveza");
        add(jLabel11);
        jLabel11.setBounds(280, 20, 200, 30);

        CB_Nombre.setBackground(new java.awt.Color(248, 248, 163));
        CB_Nombre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_NombreActionPerformed(evt);
            }
        });
        add(CB_Nombre);
        CB_Nombre.setBounds(200, 60, 340, 30);

        TF_Nombre.setBackground(new java.awt.Color(222, 222, 172));
        TF_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_NombreActionPerformed(evt);
            }
        });
        add(TF_Nombre);
        TF_Nombre.setBounds(200, 110, 250, 20);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre");
        add(jLabel7);
        jLabel7.setBounds(60, 70, 80, 16);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        add(jLabel12);
        jLabel12.setBounds(0, 0, 860, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void TF_TemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_TemperaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_TemperaturaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        int confirmacion=JOptionPane.showConfirmDialog(this,"¿Esta Seguro que desea Modificar esta persona?");
       switch (confirmacion) {
                case JOptionPane.NO_OPTION:
                break;
                case JOptionPane.YES_OPTION:
                if (TF_Temperatura.getText().length()==0 || TF_Nombre.getText().length()==0 ){
                    JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
                }
                else{
                    ModficarCerveza();
                }
                break;
                case JOptionPane.CLOSED_OPTION:
                break;
                default:
                break;
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jComboBox5){
            if(jComboBox5.getSelectedItem()!=null){
                LlenarTipo();
            }
        }
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void CB_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_NombreActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Nombre){
            if(CB_Nombre.getSelectedItem()!=null){
                LlenarDatos();
            }
        }
    
    }//GEN-LAST:event_CB_NombreActionPerformed

    private void TF_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_NombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Nombre;
    private javax.swing.JTextField TF_Nombre;
    private javax.swing.JTextField TF_Temperatura;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
