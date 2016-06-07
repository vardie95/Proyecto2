/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Registro.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Luis Diego
 */
public class ConsultaLugar extends javax.swing.JPanel {

    /**
     * Creates new form RegistroFermentacion
     */
    public ConsultaLugar() {
        initComponents();
    }
private void UpdateTable(){
         String consulta;
         String dato=PT_Nombre.getText();
        Connection con = proyectocerveza.dbConnection.conectDB();
        try {
            Statement cstmt = con.createStatement();
            if ("País".equals(CB_Ubicacion.getSelectedItem().toString())){
                 consulta="{call cerveceria.consulta_pais(\'"+dato+"\')}";
            }
            else if ("Provincia".equals(CB_Ubicacion.getSelectedItem().toString())){
                 consulta="{call cerveceria.consulta_provincia(\'"+dato+"\')}";
            }
            else if ("Cantón".equals(CB_Ubicacion.getSelectedItem().toString())){
                 consulta="{call cerveceria.consulta_canton(\'"+dato+"\')}";
            }
            else {
                 consulta="{call cerveceria.consulta_distrito(\'"+dato+"\')}";
            }
            ResultSet rs = cstmt.executeQuery(consulta);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            con.close();
            rs.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            
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
        BT_Buscar = new javax.swing.JButton();
        PT_Nombre = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        CB_Ubicacion = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Consulta Mejores Compradores por Lugar");
        add(jLabel11);
        jLabel11.setBounds(190, 50, 370, 22);

        BT_Buscar.setBackground(new java.awt.Color(102, 102, 102));
        BT_Buscar.setForeground(new java.awt.Color(255, 255, 255));
        BT_Buscar.setText("Buscar");
        BT_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_BuscarActionPerformed(evt);
            }
        });
        add(BT_Buscar);
        BT_Buscar.setBounds(530, 120, 80, 34);

        PT_Nombre.setBackground(new java.awt.Color(217, 217, 148));
        PT_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PT_NombreActionPerformed(evt);
            }
        });
        add(PT_Nombre);
        PT_Nombre.setBounds(230, 150, 150, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar por: ");
        add(jLabel4);
        jLabel4.setBounds(120, 120, 100, 15);

        CB_Ubicacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "País", "Provincia", "Cantón", "Distrito" }));
        add(CB_Ubicacion);
        CB_Ubicacion.setBounds(230, 110, 99, 22);

        jTable1.setBackground(new java.awt.Color(236, 236, 199));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Identificación", "Nombre", "Apellido1", "Apellido2", "Correo"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 200, 740, 210);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, -30, 840, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void BT_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_BuscarActionPerformed
        // TODO add your handling code here:
       UpdateTable();
    }//GEN-LAST:event_BT_BuscarActionPerformed

    private void PT_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PT_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PT_NombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Buscar;
    private javax.swing.JComboBox<String> CB_Ubicacion;
    private javax.swing.JFormattedTextField PT_Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
