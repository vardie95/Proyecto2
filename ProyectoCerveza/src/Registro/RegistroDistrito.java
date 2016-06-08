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
public class RegistroDistrito extends javax.swing.JPanel {
    ArrayList llavesPais= new ArrayList();
     ArrayList llavesProvincia= new ArrayList();
     ArrayList llavesCanton= new ArrayList();
     ArrayList llavesDistrito= new ArrayList();
     boolean modificar= false;
    /**
     * Creates new form RegistroFermentacion
     */
    public RegistroDistrito() {
        initComponents();
        Modificar.setVisible(false);
        Eliminar.setVisible(false);
        llenarpais();
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
                con.close();
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
       CB_Canton.removeAllItems();
       CB_Canton2.removeAllItems();
       llavesCanton.clear();
       
            try {
                int id_provincia;
                Connection con = proyectocerveza.dbConnection.conectDB();
                if (modificar)
                    id_provincia=(int) llavesProvincia.get(CB_Provincia2.getSelectedIndex());
                else
                    id_provincia=(int) llavesProvincia.get(CB_Provincia.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getCanton("+id_provincia+")");
                while(rs.next()){
                   llavesCanton.add(rs.getInt(1));
                   CB_Canton.addItem(rs.getString("Descripción"));
                   CB_Canton2.addItem(rs.getString("Descripción"));
                }
                
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
   
   }
    
    public final void LlenarDistrito()
    {
       CB_Distrito2.removeAllItems();
       llavesDistrito.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int id_provincia=(int) llavesCanton.get(CB_Canton2.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getDistrito("+id_provincia+")");
                while(rs.next()){
                   llavesDistrito.add(rs.getInt(1));
                   CB_Distrito2.addItem(rs.getString("Descripción"));
                }
                
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
   
   }
    
    public void InsertDistrito(){
        Connection con= null;
            String puesto=jTextField2.getText();
            con= proyectocerveza.dbConnection.conectDB();
            try {
                int id_Canton=(int) llavesCanton.get(CB_Canton.getSelectedIndex());
                CallableStatement proc= con.prepareCall("{call insertDistrito(?,?)}");
                proc.setInt(1, id_Canton);
                proc.setString(2,puesto);
                proc.execute();
                JOptionPane.showMessageDialog(this, "Distrito Agregado Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                jTextField2.setText("");
                con.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error:"+ex,null,JOptionPane.ERROR_MESSAGE);

            }
    }
    public void ModificarDistrito(){
        Connection con= null;
            
            con= proyectocerveza.dbConnection.conectDB();
            try {
                int id_Distrito=(int) llavesDistrito.get(CB_Distrito2.getSelectedIndex());
                CallableStatement proc= con.prepareCall("{call modificar_distrito(?,?)}");
                proc.setInt(1, id_Distrito);
                proc.setString(2,TF_Nuevo.getText());
                proc.execute();
                JOptionPane.showMessageDialog(this, "Distrito Modificado Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
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
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        CB_Pais = new javax.swing.JComboBox<String>();
        CB_Provincia = new javax.swing.JComboBox();
        CB_Canton = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Modificar = new javax.swing.JPanel();
        TF_Nuevo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        CB_Pais2 = new javax.swing.JComboBox<String>();
        CB_Provincia2 = new javax.swing.JComboBox();
        CB_Distrito2 = new javax.swing.JComboBox<String>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        CB_Canton2 = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Eliminar = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        CB_Pais3 = new javax.swing.JComboBox<String>();
        jComboBox7 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox<String>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        Registro.setLayout(null);

        jTextField2.setBackground(new java.awt.Color(217, 217, 148));
        Registro.add(jTextField2);
        jTextField2.setBounds(280, 250, 225, 31);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Distrito: ");
        Registro.add(jLabel6);
        jLabel6.setBounds(200, 260, 80, 20);

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

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Registro Distrito");
        Registro.add(jLabel12);
        jLabel12.setBounds(320, 50, 180, 22);

        jButton7.setBackground(new java.awt.Color(102, 102, 102));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Agregar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Registro.add(jButton7);
        jButton7.setBounds(170, 360, 120, 50);

        CB_Pais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Pais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Costa Rica" }));
        CB_Pais.setToolTipText("");
        CB_Pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_PaisActionPerformed(evt);
            }
        });
        Registro.add(CB_Pais);
        CB_Pais.setBounds(280, 100, 230, 30);

        CB_Provincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_ProvinciaActionPerformed(evt);
            }
        });
        Registro.add(CB_Provincia);
        CB_Provincia.setBounds(280, 150, 230, 30);

        CB_Canton.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Canton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_CantonActionPerformed(evt);
            }
        });
        Registro.add(CB_Canton);
        CB_Canton.setBounds(280, 200, 230, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Provincia:");
        Registro.add(jLabel7);
        jLabel7.setBounds(200, 160, 60, 14);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pais:");
        Registro.add(jLabel8);
        jLabel8.setBounds(200, 110, 50, 14);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Canton:");
        Registro.add(jLabel9);
        jLabel9.setBounds(203, 210, 50, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        Registro.add(jLabel1);
        jLabel1.setBounds(0, -30, 840, 590);

        jLayeredPane1.add(Registro);

        Modificar.setLayout(null);

        TF_Nuevo.setBackground(new java.awt.Color(217, 217, 148));
        Modificar.add(TF_Nuevo);
        TF_Nuevo.setBounds(280, 300, 225, 31);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nuevo Distrito:");
        Modificar.add(jLabel10);
        jLabel10.setBounds(190, 310, 100, 20);

        jButton8.setBackground(new java.awt.Color(102, 102, 102));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Modificar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Modificar.add(jButton8);
        jButton8.setBounds(220, 360, 130, 50);

        jButton9.setBackground(new java.awt.Color(102, 102, 102));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Volver");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        Modificar.add(jButton9);
        jButton9.setBounds(400, 360, 130, 50);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Modificar Distrito");
        Modificar.add(jLabel13);
        jLabel13.setBounds(320, 50, 180, 22);

        CB_Pais2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Pais2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Costa Rica" }));
        CB_Pais2.setToolTipText("");
        CB_Pais2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Pais2ActionPerformed(evt);
            }
        });
        Modificar.add(CB_Pais2);
        CB_Pais2.setBounds(280, 100, 230, 30);

        CB_Provincia2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Provincia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Provincia2ActionPerformed(evt);
            }
        });
        Modificar.add(CB_Provincia2);
        CB_Provincia2.setBounds(280, 150, 230, 30);

        CB_Distrito2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Distrito2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Distrito2ActionPerformed(evt);
            }
        });
        Modificar.add(CB_Distrito2);
        CB_Distrito2.setBounds(280, 250, 230, 30);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Provincia:");
        Modificar.add(jLabel14);
        jLabel14.setBounds(190, 160, 60, 14);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Pais:");
        Modificar.add(jLabel15);
        jLabel15.setBounds(190, 110, 50, 14);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Canton:");
        Modificar.add(jLabel16);
        jLabel16.setBounds(190, 210, 50, 14);

        CB_Canton2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CB_Canton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Canton2ActionPerformed(evt);
            }
        });
        Modificar.add(CB_Canton2);
        CB_Canton2.setBounds(280, 200, 230, 30);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Distrito: ");
        Modificar.add(jLabel11);
        jLabel11.setBounds(190, 260, 80, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        Modificar.add(jLabel2);
        jLabel2.setBounds(-20, -40, 840, 590);

        jLayeredPane1.add(Modificar);

        Eliminar.setLayout(null);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Distrito: ");
        Eliminar.add(jLabel17);
        jLabel17.setBounds(200, 260, 80, 20);

        jButton11.setBackground(new java.awt.Color(102, 102, 102));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Volver");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        Eliminar.add(jButton11);
        jButton11.setBounds(400, 360, 130, 50);

        jButton12.setBackground(new java.awt.Color(102, 102, 102));
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Eliminar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        Eliminar.add(jButton12);
        jButton12.setBounds(220, 360, 130, 50);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Eliminar Distrito");
        Eliminar.add(jLabel18);
        jLabel18.setBounds(320, 50, 180, 22);

        CB_Pais3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CB_Pais3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Costa Rica" }));
        CB_Pais3.setToolTipText("");
        CB_Pais3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_Pais3ActionPerformed(evt);
            }
        });
        Eliminar.add(CB_Pais3);
        CB_Pais3.setBounds(280, 100, 230, 30);

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        Eliminar.add(jComboBox7);
        jComboBox7.setBounds(280, 150, 230, 30);

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Eliminar.add(jComboBox8);
        jComboBox8.setBounds(280, 250, 230, 30);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Provincia:");
        Eliminar.add(jLabel19);
        jLabel19.setBounds(200, 160, 60, 14);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Pais:");
        Eliminar.add(jLabel20);
        jLabel20.setBounds(200, 110, 30, 14);

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Canton:");
        Eliminar.add(jLabel21);
        jLabel21.setBounds(203, 210, 50, 14);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Eliminar.add(jComboBox10);
        jComboBox10.setBounds(280, 200, 230, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        Eliminar.add(jLabel3);
        jLabel3.setBounds(-20, -40, 840, 590);

        jLayeredPane1.add(Eliminar);

        add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 0, 820, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (jTextField2.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            InsertDistrito();
        }
    
    }//GEN-LAST:event_jButton7ActionPerformed

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
        if(evt.getSource()==CB_Provincia){
            if(CB_Provincia.getSelectedItem()!=null){
                LlenarCanton();
            }
        }
        
    }//GEN-LAST:event_CB_ProvinciaActionPerformed

    private void CB_Pais2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Pais2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==CB_Pais2){
            if(CB_Pais2.getSelectedItem()!=null){
                LlenarProvincia();
            }
        }
    }//GEN-LAST:event_CB_Pais2ActionPerformed

    private void CB_Provincia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Provincia2ActionPerformed
        // TODO add your handling code here:
        
        if(evt.getSource()==CB_Provincia2){
            if(CB_Provincia2.getSelectedItem()!=null){
                LlenarCanton();
            }
            else{
                
                CB_Canton2.removeAllItems();
            }
        }
        
    }//GEN-LAST:event_CB_Provincia2ActionPerformed

    private void CB_Pais3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Pais3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_Pais3ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Modificar.setVisible(true);
        Registro.setVisible(false);
        modificar=true;
        LlenarDistrito();
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
        modificar=false;
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        Registro.setVisible(true);
        Eliminar.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void CB_CantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_CantonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_CantonActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (TF_Nuevo.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
        }
        else{
            ModificarDistrito();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void CB_Canton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Canton2ActionPerformed
 
        // TODO add your handling code here:
        if(evt.getSource()==CB_Canton2){
            if(CB_Canton2.getSelectedItem()!=null){
                LlenarDistrito();
            }
            else{
                
                CB_Canton2.removeAllItems();
                CB_Distrito2.removeAllItems();
            }
        }
        
                
    }//GEN-LAST:event_CB_Canton2ActionPerformed

    private void CB_Distrito2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_Distrito2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_Distrito2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Canton;
    private javax.swing.JComboBox<String> CB_Canton2;
    private javax.swing.JComboBox<String> CB_Distrito2;
    private javax.swing.JComboBox<String> CB_Pais;
    private javax.swing.JComboBox<String> CB_Pais2;
    private javax.swing.JComboBox<String> CB_Pais3;
    private javax.swing.JComboBox CB_Provincia;
    private javax.swing.JComboBox CB_Provincia2;
    private javax.swing.JPanel Eliminar;
    private javax.swing.JPanel Modificar;
    private javax.swing.JPanel Registro;
    private javax.swing.JTextField TF_Nuevo;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
