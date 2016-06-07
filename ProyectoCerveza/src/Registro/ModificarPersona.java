/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

import Interfaz.PanelInicio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Luis Diego
 */
public class ModificarPersona extends javax.swing.JPanel {
    ArrayList llavesPais= new ArrayList();
     ArrayList llavesProvincia= new ArrayList();
     ArrayList llavesCanton= new ArrayList();
     ArrayList llavesDistrito= new ArrayList();
     String direccionArchivo=null;
     RegistroCerveza panelIni= new RegistroCerveza();
     
    ArrayList llavesPersona= new ArrayList();
    ArrayList llavesNombre= new ArrayList();
    ArrayList llavesApellido1= new ArrayList();
    ArrayList llavesApellido2= new ArrayList();

    /**
     * Creates new form RegistroPersona
     */
    public ModificarPersona() {
        initComponents();
        llenarpais();
        LlenarIdentificacion();     
    }
    public final  void llenarpais() 
    {
        jComboBox1.removeAllItems();
        llavesPais.clear();
            try {
            Connection con = proyectocerveza.dbConnection.conectDB();
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getPais");
                while(rs.next()){
                   llavesPais.add(rs.getInt(1));
                   jComboBox1.addItem(rs.getString("Descripción"));
                }
                
            } catch (SQLException ex) {
               
            }
    }
    public final void LlenarIdentificacion()
    {
       jComboBox5.removeAllItems();
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
                   jComboBox5.addItem(Integer.toString(identificacion));
                } 
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
                
            }
   
   }
    
    public final void LlenarProvincia()
    {
       jComboBox2.removeAllItems();
       llavesProvincia.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int id_pais=(int) llavesPais.get(jComboBox1.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getProvincia("+id_pais+")");
                while(rs.next()){
                   llavesProvincia.add(rs.getInt(1));
                   jComboBox2.addItem(rs.getString("Descripción"));
                }
                
              con.close();
            } catch (SQLException ex) {
                
            }
   
   }
    
    public final void LlenarCanton()
    {
       jComboBox3.removeAllItems();
       llavesCanton.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int id_provincia=(int) llavesProvincia.get(jComboBox2.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getCanton("+id_provincia+")");
                while(rs.next()){
                   llavesCanton.add(rs.getInt(1));
                   jComboBox3.addItem(rs.getString("Descripción"));
                }
                
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
   
   }
    public final void LlenarDistrito()
    {
       jComboBox4.removeAllItems();
       llavesDistrito.clear();
       
            try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int id_provincia=(int) llavesCanton.get(jComboBox3.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getDistrito("+id_provincia+")");
                while(rs.next()){
                   llavesDistrito.add(rs.getInt(1));
                   jComboBox4.addItem(rs.getString("Descripción"));
                }
                
              con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
   
   }
    
    private void llenarDatos(){
        try {
                Connection con = proyectocerveza.dbConnection.conectDB();
                int id_provincia=(int) llavesPersona.get(jComboBox5.getSelectedIndex());
                Statement cstmt = con.createStatement();
                ResultSet rs = cstmt.executeQuery("call getDatosPersona("+id_provincia+")");
                while(rs.next()){
                   TF_Nombre.setText(rs.getString(1));
                   TF_Apellido1.setText(rs.getString(2));
                   TF_Apellido2.setText(rs.getString(3));
                   TF_Direccion.setText(rs.getString(4));
                   direccionArchivo=rs.getString(5);
                   ImageIcon image= new ImageIcon(direccionArchivo);
                    jLabel5.setIcon(image);
                    jComboBox1.setSelectedItem(llavesPais.get(rs.getInt(9)-1));
                    jComboBox2.setSelectedItem(rs.getString(8));
                    jComboBox3.setSelectedItem(rs.getString(7));
                    jComboBox4.setSelectedItem(rs.getString(6));
                }
                
              con.close();
              rs.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
    
    
    
    
    }
    public final void ModificarPersona(){
        int identificacion=Integer.parseInt(jComboBox5.getSelectedItem().toString());
        String Nombre= TF_Nombre.getText();
        String Apellido1=TF_Apellido1.getText();
        String Apellido2=TF_Apellido2.getText();
        String Direccion=TF_Direccion.getText();
        int idDistrito=(int) llavesDistrito.get(jComboBox4.getSelectedIndex());
        Connection con= null;
        con= proyectocerveza.dbConnection.conectDB();
            try {
                CallableStatement proc= con.prepareCall("{call modificarPersona(?,?,?,?,?,?,?)}");
                proc.setInt(1, identificacion);
                proc.setString(2, Nombre);
                proc.setString(3, Apellido1);
                proc.setString(4, Apellido2);
                proc.setString(5, Direccion);
                proc.setString(6, direccionArchivo);
                proc.setInt(7, idDistrito);
                proc.execute();
                TF_Nombre.setText("");
                TF_Apellido1.setText("");
                TF_Apellido2.setText("");
                TF_Direccion.setText("");
                jLabel5.setIcon(null);
                direccionArchivo=null;
                JOptionPane.showMessageDialog(this, "Persona Registrada Exitosamente",null,JOptionPane.INFORMATION_MESSAGE);
                
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
        TF_Nombre = new javax.swing.JTextField();
        TF_Apellido1 = new javax.swing.JTextField();
        TF_Apellido2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TF_Direccion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jComboBox4 = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BT_AgregarFoto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BT_Agregar1 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Identificación:");
        add(jLabel1);
        jLabel1.setBounds(70, 60, 130, 16);

        TF_Nombre.setBackground(new java.awt.Color(244, 244, 179));
        TF_Nombre.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        add(TF_Nombre);
        TF_Nombre.setBounds(210, 100, 180, 20);

        TF_Apellido1.setBackground(new java.awt.Color(244, 244, 179));
        TF_Apellido1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        add(TF_Apellido1);
        TF_Apellido1.setBounds(210, 140, 180, 20);

        TF_Apellido2.setBackground(new java.awt.Color(244, 244, 179));
        TF_Apellido2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        add(TF_Apellido2);
        TF_Apellido2.setBounds(210, 190, 180, 20);

        TF_Direccion.setBackground(new java.awt.Color(244, 244, 179));
        TF_Direccion.setColumns(20);
        TF_Direccion.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        TF_Direccion.setRows(5);
        jScrollPane1.setViewportView(TF_Direccion);

        add(jScrollPane1);
        jScrollPane1.setBounds(90, 320, 460, 129);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        add(jLabel2);
        jLabel2.setBounds(70, 100, 110, 16);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido 1: ");
        add(jLabel3);
        jLabel3.setBounds(70, 140, 110, 16);

        jLabel4.setBackground(new java.awt.Color(217, 217, 152));
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección: ");
        add(jLabel4);
        jLabel4.setBounds(50, 300, 110, 16);

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "País" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(60, 270, 130, 20);

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Provincia" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        add(jComboBox2);
        jComboBox2.setBounds(213, 270, 120, 20);

        jComboBox3.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cantón" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        add(jComboBox3);
        jComboBox3.setBounds(360, 270, 120, 20);

        jComboBox4.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Distrito" }));
        add(jComboBox4);
        jComboBox4.setBounds(510, 270, 120, 20);

        jLabel5.setBackground(new java.awt.Color(244, 244, 179));
        jLabel5.setOpaque(true);
        add(jLabel5);
        jLabel5.setBounds(580, 60, 120, 130);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Foto:");
        add(jLabel6);
        jLabel6.setBounds(540, 64, 34, 20);

        BT_AgregarFoto.setBackground(new java.awt.Color(102, 102, 102));
        BT_AgregarFoto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        BT_AgregarFoto.setForeground(new java.awt.Color(255, 255, 255));
        BT_AgregarFoto.setText("Agregar Foto");
        BT_AgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_AgregarFotoActionPerformed(evt);
            }
        });
        add(BT_AgregarFoto);
        BT_AgregarFoto.setBounds(570, 200, 140, 30);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Apellido 2: ");
        add(jLabel8);
        jLabel8.setBounds(70, 190, 110, 16);

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Modificar Persona");
        add(jLabel11);
        jLabel11.setBounds(340, 20, 200, 30);

        BT_Agregar1.setBackground(new java.awt.Color(102, 102, 102));
        BT_Agregar1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        BT_Agregar1.setForeground(new java.awt.Color(255, 255, 255));
        BT_Agregar1.setText("Modificar");
        BT_Agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_Agregar1ActionPerformed(evt);
            }
        });
        add(BT_Agregar1);
        BT_Agregar1.setBounds(600, 350, 100, 50);

        jComboBox5.setBackground(new java.awt.Color(248, 248, 163));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        add(jComboBox5);
        jComboBox5.setBounds(210, 60, 280, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/fondoCerveza.jpg"))); // NOI18N
        add(jLabel7);
        jLabel7.setBounds(0, -10, 840, 590);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jComboBox1){
            if(jComboBox1.getSelectedItem()!=null){
                LlenarProvincia();
            }
        }
    
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jComboBox2){
            if(jComboBox2.getSelectedItem()!=null){
                LlenarCanton();
            }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jComboBox3){
            if(jComboBox3.getSelectedItem()!=null){
                LlenarDistrito();
            }
        }
    
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void BT_AgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_AgregarFotoActionPerformed
        // TODO add your handling code here:
        JFileChooser fotoFile= new JFileChooser();
        fotoFile.setCurrentDirectory(new java.io.File("user.home"));
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("JPG y PNG","jpg","png");
        fotoFile.setFileFilter(filtro);
        fotoFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if(fotoFile.showOpenDialog(BT_AgregarFoto)==JFileChooser.APPROVE_OPTION){
            direccionArchivo =fotoFile.getSelectedFile().getAbsolutePath();
            ImageIcon image= new ImageIcon(direccionArchivo);
            jLabel5.setIcon(image);
           
        
        }
    }//GEN-LAST:event_BT_AgregarFotoActionPerformed

    private void BT_Agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_Agregar1ActionPerformed
        // TODO add your handling code here:
        int confirmacion=JOptionPane.showConfirmDialog(this,"¿Esta Seguro que desea Modificar esta persona?");
       switch (confirmacion) {
                case JOptionPane.NO_OPTION:
                break;
                case JOptionPane.YES_OPTION:
                    if (TF_Nombre.getText().length()==0 || TF_Apellido1.getText().length()==0 || TF_Apellido2.getText().length()==0 ){
                        JOptionPane.showMessageDialog(this, "Debe de llenar todos los campos obligatorios.",null,JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        ModificarPersona();
                    }
                
                break;
                case JOptionPane.CLOSED_OPTION:
                break;
                default:
                break;
            }
    }//GEN-LAST:event_BT_Agregar1ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==jComboBox5){
            if(jComboBox5.getSelectedItem()!=null){
                llenarDatos();
            }
        }

    }//GEN-LAST:event_jComboBox5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Agregar1;
    private javax.swing.JButton BT_AgregarFoto;
    private javax.swing.JTextField TF_Apellido1;
    private javax.swing.JTextField TF_Apellido2;
    private javax.swing.JTextArea TF_Direccion;
    private javax.swing.JTextField TF_Nombre;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
