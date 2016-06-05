/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadisticas;

import Consultas.*;
import Registro.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Luis Diego
 */
public class EstadisticaEmpleados extends javax.swing.JPanel {
    ArrayList llavesPais= new ArrayList();
     ArrayList llavesProvincia= new ArrayList();
    /**
     * Creates new form RegistroFermentacion
     */
    public EstadisticaEmpleados() {
        initComponents();
        TotalEmpleados();
        CB_Nombre.removeAllItems();
        
        
    }
    
    
private void TotalEmpleados(){
        try {
            Connection con = proyectocerveza.dbConnection.conectDB();
            Statement cstmt = con.createStatement();
            ResultSet rs = cstmt.executeQuery("{call cerveceria.TotalEmpleados}");
            while(rs.next()){
                TotalEmpleados.setText(Integer.toString(rs.getInt(1)));
            }
            con.close();
            rs.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
  
    }
     private void UpdateTable(){
         String consulta = null;
         String dato=CB_Nombre.getSelectedItem().toString();
        Connection con = proyectocerveza.dbConnection.conectDB();
        try {
            Statement cstmt = con.createStatement();
            if ("Pais".equals(CB_Nombre.getSelectedItem().toString())){
                 //consulta="{call cerveceria.estadistica_pais}";
            }
           
            ResultSet rs = cstmt.executeQuery(consulta);
            Cantidad.setText(Integer.toString(rs.getInt(1)));
            con.close();
            rs.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
        }
     }
     
     public final  void llenarpais() 
    {
        CB_Nombre.removeAllItems();
        llavesPais.clear();
            try {
            Connection con = proyectocerveza.dbConnection.conectDB();
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getPais");
                while(rs.next()){
                   llavesPais.add(rs.getInt(1));
                   CB_Nombre.addItem(rs.getString("Descripción"));
                }
                
            } catch (SQLException ex) {
               
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

        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BT_Analizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        CB_Nombre = new javax.swing.JComboBox<String>();
        CB_Lugar = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TotalEmpleados = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Consulta Empleados");
        add(jLabel11);
        jLabel11.setBounds(320, 50, 180, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre: ");
        add(jLabel2);
        jLabel2.setBounds(110, 270, 80, 20);

        BT_Analizar.setText("Analizar");
        BT_Analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AnalizarActionPerformed(evt);
            }
        });
        add(BT_Analizar);
        BT_Analizar.setBounds(520, 270, 110, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad de personas:");
        add(jLabel3);
        jLabel3.setBounds(110, 320, 140, 14);

        Cantidad.setEditable(false);
        Cantidad.setBackground(new java.awt.Color(153, 255, 153));
        add(Cantidad);
        Cantidad.setBounds(270, 320, 40, 20);

        CB_Nombre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "País", "Provincia", "Cantón", "Distrito" }));
        add(CB_Nombre);
        CB_Nombre.setBounds(220, 270, 90, 20);

        CB_Lugar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "País", "Provincia", "Cantón", "Distrito" }));
        add(CB_Lugar);
        CB_Lugar.setBounds(220, 230, 90, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Analizar por: ");
        add(jLabel1);
        jLabel1.setBounds(110, 230, 100, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total de empleados:");
        add(jLabel4);
        jLabel4.setBounds(300, 110, 140, 15);

        TotalEmpleados.setEditable(false);
        TotalEmpleados.setBackground(new java.awt.Color(153, 255, 153));
        add(TotalEmpleados);
        TotalEmpleados.setBounds(460, 110, 40, 20);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(340, 230, 110, 23);

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        jLabel5.setOpaque(true);
        add(jLabel5);
        jLabel5.setBounds(0, 0, 800, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_AnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AnalizarActionPerformed
        // TODO add your handling code here:
    

        
    }//GEN-LAST:event_BT_AnalizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if ("País".equals(CB_Lugar.getSelectedItem().toString())){
            llenarpais();
         
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Analizar;
    private javax.swing.JComboBox<String> CB_Lugar;
    private javax.swing.JComboBox<String> CB_Nombre;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JTextField TotalEmpleados;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
