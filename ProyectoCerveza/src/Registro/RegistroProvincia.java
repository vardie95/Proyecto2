/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

/**
 *
 * @author Luis Diego
 */
public class RegistroProvincia extends javax.swing.JPanel {

    /**
     * Creates new form RegistroFermentacion
     */
    public RegistroProvincia() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setLayout(null);

        jTextField1.setBackground(new java.awt.Color(217, 217, 148));
        add(jTextField1);
        jTextField1.setBounds(290, 210, 225, 31);

        jLabel1.setText("Pais: ");
        add(jLabel1);
        jLabel1.setBounds(160, 140, 74, 31);

        jLabel2.setText("Provincia: ");
        add(jLabel2);
        jLabel2.setBounds(160, 220, 80, 20);

        jButton1.setText("Agregar");
        add(jButton1);
        jButton1.setBounds(160, 360, 120, 50);

        jButton2.setText("Modificar");
        add(jButton2);
        jButton2.setBounds(330, 360, 130, 50);

        jButton3.setText("Eliminar");
        add(jButton3);
        jButton3.setBounds(510, 360, 130, 50);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Registro Provincia");
        add(jLabel12);
        jLabel12.setBounds(320, 50, 180, 22);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1);
        jComboBox1.setBounds(290, 140, 230, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
