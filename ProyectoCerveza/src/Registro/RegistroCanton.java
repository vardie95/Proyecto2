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

/**
 *
 * @author Luis Diego
 */
public class RegistroCanton extends javax.swing.JPanel {
     ArrayList llavesPais= new ArrayList();
     ArrayList llavesProvincia= new ArrayList();
     ArrayList llavesCanton= new ArrayList();
     boolean modificar=false;
    /**
     * Creates new form RegistroFermentacion
     */
    public RegistroCanton() {
        initComponents();
        Eliminar.setVisible(false);
        Modificar.setVisible(false);
        llenarpais();
        LlenarProvincia();
       
    }
    
    public final  void llenarpais() 
    {
        CB_Pais.removeAllItems();
        CB_Pais2.removeAllItems();
        llavesPais.clear();
            try {
            Connection con = proyectocerveza.dbConnection.conectDB();
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getPais");
                while(rs.next()){
                   llavesPais.add(rs.getInt(1));
                   CB_Pais.addItem(rs.getString("Descripción"));
                   CB_Pais2.addItem(rs.getString("Descripción"));
                }
                
            } catch (SQLException ex) {
               
            }
    }

    public final void LlenarProvincia()
    {
       CB_Provincia.removeAllItems();
       CB_Provincia2.removeAllItems();
       llavesProvincia.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int id_pais;
                if (modificar)
                    id_pais=(int) llavesPais.get(CB_Pais2.getSelectedIndex());
                else
                    id_pais=(int) llavesPais.get(CB_Pais.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getProvincia("+id_pais+")");
                while(rs.next()){
                   llavesProvincia.add(rs.getInt(1));
                   CB_Provincia.addItem(rs.getString("Descripción"));
                   CB_Provincia2.addItem(rs.getString("Descripción"));
                }
                
              con.close();
            } catch (SQLException ex) {
                
            }
   
   }
    
    public final void LlenarCanton()
    {
       CB_Canton2.removeAllItems();
       llavesCanton.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int id_provincia=(int) llavesProvincia.get(CB_Provincia2.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getCanton("+id_provincia+")");
                while(rs.next()){
                   llavesCanton.add(rs.getInt(1));
                   CB_Canton2.addItem(rs.getString("Descripción"));
                }
                
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
   
   }
    
    
    public void InsertCanton(){
        Connection con= null;
            String canton=jTextField1.getText();
            con= proyectocerveza.dbConnection.conectDB();
            try {
                int id_provincia=(int) llavesProvincia.get(CB_Provincia.getSelectedIndex());
                CallableStatement proc= con.prepareCall("{call insertCanton(?,?)}");
                proc.setInt(1, id_provincia);
                proc.setString(2,canton);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Cantón Agregada Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                jTextField1.setText("");
                con.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error:"+ex,null,JOptionPane.ERROR_MESSAGE);

            }
    
    }
    public void ModificarCanton(){
        Connection con= null;
            
            con= proyectocerveza.dbConnection.conectDB();
            try {
                int id_Canton=(int) llavesCanton.get(CB_Canton2.getSelectedIndex());
                CallableStatement proc= con.prepareCall("{call modificar_canton(?,?)}");
                proc.setInt(1, id_Canton);
                proc.setString(2,TF_Nuevo.getText());
                proc.execute();
                JOptionPane.showMessageDialog(this, "Cantón Modificado Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                TF_Nuevo.setText("");
                
                con.close();
                LlenarCanton();
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        CB_Provincia = new javax.swing.JComboBox();
        CB_Pais = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        CB_Pais1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        Modificar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        CB_Provincia2 = new javax.swing.JComboBox();
        CB_Pais2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CB_Canton2 = new javax.swing.JComboBox();
        TF_Nuevo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setLayout(null);

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        Registro.setLayout(null);

        jTextField1.setBackground(new java.awt.Color(217, 217, 148));
        Registro.add(jTextField1);
        jTextField1.setBounds(270, 280, 225, 31);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantón: ");
        Registro.add(jLabel2);
        jLabel2.setBounds(190, 280, 80, 20);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Registro.add(jButton1);
        jButton1.setBounds(190, 380, 120, 50);

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Registro.add(jButton2);
        jButton2.setBounds(480, 380, 130, 50);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Registro Cantón");
        Registro.add(jLabel12);
        jLabel12.setBounds(300, 80, 180, 30);

        CB_Provincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ProvinciaActionPerformed(evt);
            }
        });
        Registro.add(CB_Provincia);
        CB_Provincia.setBounds(270, 220, 230, 30);

        CB_Pais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Costa Rica" }));
        CB_Pais.setToolTipText("");
        CB_Pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_PaisActionPerformed(evt);
            }
        });
        Registro.add(CB_Pais);
        CB_Pais.setBounds(270, 170, 230, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("País:");
        Registro.add(jLabel4);
        jLabel4.setBounds(190, 170, 50, 14);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Provincia:");
        Registro.add(jLabel3);
        jLabel3.setBounds(190, 220, 60, 14);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        Registro.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 550);

        jLayeredPane1.add(Registro);

        Eliminar.setLayout(null);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Canton: ");
        Eliminar.add(jLabel5);
        jLabel5.setBounds(220, 240, 80, 20);

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Volver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Eliminar.add(jButton5);
        jButton5.setBounds(405, 354, 120, 50);

        jButton7.setBackground(new java.awt.Color(102, 102, 102));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Eliminar");
        Eliminar.add(jButton7);
        jButton7.setBounds(219, 354, 130, 50);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Eliminar Cantón");
        Eliminar.add(jLabel13);
        jLabel13.setBounds(310, 49, 180, 22);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        Eliminar.add(jComboBox2);
        jComboBox2.setBounds(286, 160, 230, 30);

        CB_Pais1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Pais1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Costa Rica" }));
        CB_Pais1.setToolTipText("");
        CB_Pais1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Pais1ActionPerformed(evt);
            }
        });
        Eliminar.add(CB_Pais1);
        CB_Pais1.setBounds(286, 110, 230, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Provincia:");
        Eliminar.add(jLabel6);
        jLabel6.setBounds(216, 170, 60, 14);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pais:");
        Eliminar.add(jLabel7);
        jLabel7.setBounds(216, 120, 50, 14);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        Eliminar.add(jComboBox3);
        jComboBox3.setBounds(286, 235, 230, 30);

        jLabel16.setBackground(new java.awt.Color(51, 51, 51));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        jLabel16.setOpaque(true);
        Eliminar.add(jLabel16);
        jLabel16.setBounds(0, 0, 800, 550);

        jLayeredPane1.add(Eliminar);

        Modificar.setLayout(null);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Canton: ");
        Modificar.add(jLabel8);
        jLabel8.setBounds(210, 220, 80, 20);

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Volver");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Modificar.add(jButton6);
        jButton6.setBounds(405, 354, 120, 50);

        jButton8.setBackground(new java.awt.Color(102, 102, 102));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Modificar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Modificar.add(jButton8);
        jButton8.setBounds(219, 354, 130, 50);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Modificar Cantón");
        Modificar.add(jLabel14);
        jLabel14.setBounds(310, 49, 180, 22);

        CB_Provincia2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Provincia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Provincia2ActionPerformed(evt);
            }
        });
        Modificar.add(CB_Provincia2);
        CB_Provincia2.setBounds(290, 160, 230, 30);

        CB_Pais2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Pais2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Costa Rica" }));
        CB_Pais2.setToolTipText("");
        CB_Pais2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Pais2ActionPerformed(evt);
            }
        });
        Modificar.add(CB_Pais2);
        CB_Pais2.setBounds(290, 110, 230, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Provincia:");
        Modificar.add(jLabel9);
        jLabel9.setBounds(210, 170, 60, 14);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pais:");
        Modificar.add(jLabel10);
        jLabel10.setBounds(210, 120, 50, 14);

        CB_Canton2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Canton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Canton2ActionPerformed(evt);
            }
        });
        Modificar.add(CB_Canton2);
        CB_Canton2.setBounds(290, 210, 230, 30);

        TF_Nuevo.setBackground(new java.awt.Color(217, 217, 148));
        Modificar.add(TF_Nuevo);
        TF_Nuevo.setBounds(290, 270, 225, 31);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nuevo Canton: ");
        Modificar.add(jLabel11);
        jLabel11.setBounds(210, 280, 100, 20);

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        jLabel15.setOpaque(true);
        Modificar.add(jLabel15);
        jLabel15.setBounds(0, 0, 800, 550);

        jLayeredPane1.add(Modificar);

        add(jLayeredPane1);
        jLayeredPane1.setBounds(-2, -1, 810, 490);
    }// </editor-fold>//GEN-END:initComponents

    private void CB_PaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_PaisActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Pais){
            if(CB_Pais.getSelectedItem()!=null){
                LlenarProvincia();
            }
        }
    }//GEN-LAST:event_CB_PaisActionPerformed

    private void CB_ProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_ProvinciaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CB_ProvinciaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Registro.setVisible(false);
        Modificar.setVisible(true);
        LlenarCanton();
        modificar=true;
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            InsertCanton();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Registro.setVisible(true);
        Eliminar.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        LlenarCanton();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void CB_Pais1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Pais1ActionPerformed
        // TODO add your handling code here:
        LlenarProvincia();
        LlenarCanton();
    }//GEN-LAST:event_CB_Pais1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Modificar.setVisible(false);
        Registro.setVisible(true);
        modificar=false;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void CB_Provincia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Provincia2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Provincia2){
            if(CB_Provincia2.getSelectedItem()!=null){
                LlenarCanton();
            }
            else
                CB_Canton2.removeAllItems();
        }
    }//GEN-LAST:event_CB_Provincia2ActionPerformed

    private void CB_Pais2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Pais2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Pais2){
            if(CB_Pais2.getSelectedItem()!=null){
                LlenarProvincia();
            }
        }
        
        
        
    }//GEN-LAST:event_CB_Pais2ActionPerformed

    private void CB_Canton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Canton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_Canton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (TF_Nuevo.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            ModificarCanton();
        }
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CB_Canton2;
    private javax.swing.JComboBox<String> CB_Pais;
    private javax.swing.JComboBox<String> CB_Pais1;
    private javax.swing.JComboBox<String> CB_Pais2;
    private javax.swing.JComboBox CB_Provincia;
    private javax.swing.JComboBox CB_Provincia2;
    private javax.swing.JPanel Eliminar;
    private javax.swing.JPanel Modificar;
    private javax.swing.JPanel Registro;
    private javax.swing.JTextField TF_Nuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
