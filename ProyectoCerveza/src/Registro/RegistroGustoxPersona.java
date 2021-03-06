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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Luis Diego
 */

public class RegistroGustoxPersona extends javax.swing.JPanel {
    ArrayList llavesPersona= new ArrayList();
    ArrayList llavesNombre= new ArrayList();
    ArrayList llavesApellido1= new ArrayList();
    ArrayList llavesApellido2= new ArrayList();
    ArrayList llavesCerveza= new ArrayList();

    /**
     * Creates new form RegistroFermentacion
     */
    public RegistroGustoxPersona() {
        initComponents();
        LlenarIdentificacion();
        LlenarCerveza();
        UpdateTable();
        
    }
    
    
    public final void LlenarIdentificacion()
    {
       jComboBox1.removeAllItems();
       llavesPersona.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getPersona");
                while(rs.next()){
                   int identificacion=rs.getInt(1);
                   llavesPersona.add(rs.getInt(1));
                   llavesNombre.add(rs.getString(2));
                   llavesApellido1.add(rs.getString(3));
                   llavesApellido2.add(rs.getString(4));
                   jComboBox1.addItem(Integer.toString(identificacion));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
    
    
     public final void LlenarCampos()
     {
         jTextField1.setText((String) llavesNombre.get(jComboBox1.getSelectedIndex()));
         jTextField2.setText((String) llavesApellido1.get(jComboBox1.getSelectedIndex()));
         jTextField3.setText((String) llavesApellido2.get(jComboBox1.getSelectedIndex()));
         
         
     }
    public final void LlenarCerveza()
    {
       jComboBox2.removeAllItems();
       llavesCerveza.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getCerveza");
                while(rs.next()){
                   llavesCerveza.add(rs.getInt(1));
                   jComboBox2.addItem(rs.getString("Descripcion"));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
    private void UpdateTable(){
        
        Connection con = proyectocerveza.dbConnection.conectDB();
        try {
            Statement cstmt = con.createStatement();
            ResultSet rs = cstmt.executeQuery("{call getGustosPersona("+(int)llavesPersona.get(jComboBox1.getSelectedIndex())+ ")}");
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
            rs.close();
            
        } catch (SQLException ex) {
            
        }
  
    }
    private void InsertGusto(){
        int idPersona=(int) llavesPersona.get(jComboBox1.getSelectedIndex());
        int idCerveza=(int) llavesCerveza.get(jComboBox2.getSelectedIndex());
        int Cantidad=Integer.parseInt(jTextField4.getText());
        Connection con= null;
        con= proyectocerveza.dbConnection.conectDB();
        CallableStatement proc;
        try {
            proc = con.prepareCall("insert into gustosxpersona(Cerveza_idCerveza,Persona_idPersona,cantidad) values("+idCerveza+","+idPersona+","+Cantidad+")");
            proc.execute();
            jTextField4.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(RegistroGustoxPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
     
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void EliminarGusto(){
        int cerveza=Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        int id=(int) llavesPersona.get(jComboBox1.getSelectedIndex());
        Connection con= null;
        con= proyectocerveza.dbConnection.conectDB();
        CallableStatement proc;
        try {
            proc = con.prepareCall("{call DeleteGustos(?,?)}");
            proc.setInt(1, cerveza);
            proc.setInt(2, id);
            proc.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ModificarCantidad(){
        int cerveza=Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        int id=(int) llavesPersona.get(jComboBox1.getSelectedIndex());
        String cervezaMo=jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        Connection con= null;
        con= proyectocerveza.dbConnection.conectDB();
        CallableStatement proc;
        try {
            int  cantidad=Integer.parseInt(JOptionPane.showInputDialog("Digite la Nueva Cantidad de Cerveza "+cervezaMo+": "));
            proc = con.prepareCall("{call ModificarCantidad(?,?,?)}");
            proc.setInt(1, cerveza);
            proc.setInt(2, id);
            proc.setInt(3, cantidad);
            proc.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setLayout(null);

        jTable1.setBackground(new java.awt.Color(238, 238, 184));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(251, 231, 150));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 150, 730, 260);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(500, 420, 110, 40);

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Modificar Cantidad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(290, 420, 160, 40);

        jComboBox1.setBackground(new java.awt.Color(248, 248, 163));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(170, 30, 380, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Persona:");
        add(jLabel1);
        jLabel1.setBounds(60, 30, 90, 20);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(240, 240, 158));
        jTextField1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(170, 70, 130, 20);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(240, 240, 158));
        jTextField2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(330, 70, 140, 20);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(240, 240, 158));
        jTextField3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(500, 70, 130, 20);

        jComboBox2.setBackground(new java.awt.Color(248, 248, 163));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox2);
        jComboBox2.setBounds(160, 100, 340, 30);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cerveza:");
        add(jLabel2);
        jLabel2.setBounds(60, 100, 60, 20);

        jTextField4.setBackground(new java.awt.Color(240, 240, 158));
        jTextField4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        add(jTextField4);
        jTextField4.setBounds(660, 110, 59, 22);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad: ");
        add(jLabel3);
        jLabel3.setBounds(560, 110, 80, 14);

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(110, 420, 110, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(0, -30, 840, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jComboBox1){
            if(jComboBox1.getSelectedItem()!=null){
                LlenarCampos();
                UpdateTable();
            }
        }
    
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jTextField4.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar El campo de Cantidad.",null,JOptionPane.ERROR_MESSAGE);

        }else{
            InsertGusto();
            UpdateTable();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()!=-1){
            ModificarCantidad();
            UpdateTable();
        }
        else{
           JOptionPane.showMessageDialog(this, "Error: Seleccione Una Cerveza a Modificar ",null,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()!=-1){
            EliminarGusto();
            UpdateTable();
        }
        else{
           JOptionPane.showMessageDialog(this, "Error: Seleccione Una Cerveza a Borrar ",null,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
