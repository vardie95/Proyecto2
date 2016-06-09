/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Registro.RegistroCerveza;
import Registro.RegistroColor2;
import Registro.RegistroCuerpo2;
import Registro.RegistroEstilo2;
import Registro.RegistroFamilia2;
import Registro.RegistroFermentacion2;
import Registro.RegistroPersona;
import Registro.RegistroTipo2;
import java.awt.Panel;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis Diego
 */

public class Inicio extends javax.swing.JFrame {
    static boolean Inicio_Secion;
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        
        initComponents();
        proyectocerveza.dbConnection.conectDB();
        PanelInicio panelIni= new PanelInicio();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jM_Persona = new javax.swing.JMenuItem();
        jM_Persona2 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jM_Persona3 = new javax.swing.JMenuItem();
        jM_Persona4 = new javax.swing.JMenuItem();
        jM_Persona5 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jM_Persona1 = new javax.swing.JMenuItem();
        jM_Persona7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cervecería");
        setLocation(new java.awt.Point(300, 80));
        setMinimumSize(new java.awt.Dimension(800, 560));
        setResizable(false);

        jPanel1.setToolTipText("Cerveceria");
        jPanel1.setLayout(new java.awt.CardLayout());

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 56));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("                   Inicio");
        jMenu1.setPreferredSize(new java.awt.Dimension(190, 19));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu3.setBackground(new java.awt.Color(102, 102, 102));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("               Registro");
        jMenu3.setPreferredSize(new java.awt.Dimension(190, 19));
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenu2.setBackground(new java.awt.Color(102, 102, 102));
        jMenu2.setForeground(new java.awt.Color(248, 246, 246));
        jMenu2.setText("Ubicación");
        jMenu2.setOpaque(true);
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 30));

        jMenuItem12.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem12.setForeground(new java.awt.Color(253, 253, 253));
        jMenuItem12.setText("País");
        jMenuItem12.setPreferredSize(new java.awt.Dimension(100, 25));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem11.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem11.setForeground(new java.awt.Color(253, 253, 253));
        jMenuItem11.setText("Provincia");
        jMenuItem11.setPreferredSize(new java.awt.Dimension(100, 25));
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuItem10.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem10.setForeground(new java.awt.Color(253, 253, 253));
        jMenuItem10.setText("Cantón");
        jMenuItem10.setPreferredSize(new java.awt.Dimension(100, 25));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem9.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem9.setForeground(new java.awt.Color(253, 253, 253));
        jMenuItem9.setText("Distrito");
        jMenuItem9.setPreferredSize(new java.awt.Dimension(100, 25));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenu3.add(jMenu2);

        jMenu6.setBackground(new java.awt.Color(102, 102, 102));
        jMenu6.setForeground(new java.awt.Color(248, 246, 246));
        jMenu6.setText("Gustos Persona");
        jMenu6.setOpaque(true);
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 30));

        jMenuItem18.setBackground(new java.awt.Color(153, 153, 153));
        jMenuItem18.setForeground(new java.awt.Color(253, 253, 253));
        jMenuItem18.setText("Registrar Compra");
        jMenuItem18.setPreferredSize(new java.awt.Dimension(150, 25));
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem18);

        jMenu3.add(jMenu6);

        jMenu7.setBackground(new java.awt.Color(102, 102, 102));
        jMenu7.setForeground(new java.awt.Color(248, 246, 246));
        jMenu7.setText("Persona");
        jMenu7.setOpaque(true);
        jMenu7.setPreferredSize(new java.awt.Dimension(150, 30));

        jM_Persona.setBackground(new java.awt.Color(102, 102, 102));
        jM_Persona.setForeground(new java.awt.Color(255, 255, 255));
        jM_Persona.setText("Registrar");
        jM_Persona.setPreferredSize(new java.awt.Dimension(150, 30));
        jM_Persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_PersonaActionPerformed(evt);
            }
        });
        jMenu7.add(jM_Persona);

        jM_Persona2.setBackground(new java.awt.Color(102, 102, 102));
        jM_Persona2.setForeground(new java.awt.Color(255, 255, 255));
        jM_Persona2.setText("Modificar");
        jM_Persona2.setPreferredSize(new java.awt.Dimension(150, 30));
        jM_Persona2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Persona2ActionPerformed(evt);
            }
        });
        jMenu7.add(jM_Persona2);

        jMenu3.add(jMenu7);

        jMenu8.setBackground(new java.awt.Color(102, 102, 102));
        jMenu8.setForeground(new java.awt.Color(248, 246, 246));
        jMenu8.setText("Cerveza");
        jMenu8.setOpaque(true);
        jMenu8.setPreferredSize(new java.awt.Dimension(150, 30));

        jM_Persona3.setBackground(new java.awt.Color(102, 102, 102));
        jM_Persona3.setForeground(new java.awt.Color(255, 255, 255));
        jM_Persona3.setText("Registrar");
        jM_Persona3.setPreferredSize(new java.awt.Dimension(150, 30));
        jM_Persona3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Persona3ActionPerformed(evt);
            }
        });
        jMenu8.add(jM_Persona3);

        jM_Persona4.setBackground(new java.awt.Color(102, 102, 102));
        jM_Persona4.setForeground(new java.awt.Color(255, 255, 255));
        jM_Persona4.setText("Modificar");
        jM_Persona4.setPreferredSize(new java.awt.Dimension(150, 30));
        jM_Persona4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Persona4ActionPerformed(evt);
            }
        });
        jMenu8.add(jM_Persona4);

        jM_Persona5.setBackground(new java.awt.Color(102, 102, 102));
        jM_Persona5.setForeground(new java.awt.Color(255, 255, 255));
        jM_Persona5.setText("Modificar Precio");
        jM_Persona5.setPreferredSize(new java.awt.Dimension(150, 30));
        jM_Persona5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Persona5ActionPerformed(evt);
            }
        });
        jMenu8.add(jM_Persona5);

        jMenu3.add(jMenu8);

        jMenu9.setBackground(new java.awt.Color(102, 102, 102));
        jMenu9.setForeground(new java.awt.Color(248, 246, 246));
        jMenu9.setText("Empleado");
        jMenu9.setOpaque(true);
        jMenu9.setPreferredSize(new java.awt.Dimension(150, 30));

        jM_Persona1.setBackground(new java.awt.Color(102, 102, 102));
        jM_Persona1.setForeground(new java.awt.Color(255, 255, 255));
        jM_Persona1.setText("Registro");
        jM_Persona1.setPreferredSize(new java.awt.Dimension(150, 30));
        jM_Persona1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Persona1ActionPerformed(evt);
            }
        });
        jMenu9.add(jM_Persona1);

        jM_Persona7.setBackground(new java.awt.Color(102, 102, 102));
        jM_Persona7.setForeground(new java.awt.Color(255, 255, 255));
        jM_Persona7.setText("Usuario");
        jM_Persona7.setPreferredSize(new java.awt.Dimension(150, 30));
        jM_Persona7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_Persona7ActionPerformed(evt);
            }
        });
        jMenu9.add(jM_Persona7);

        jMenu3.add(jMenu9);

        jMenuItem2.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("Cuerpo");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem4.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem4.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem4.setText("Fermentación");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem6.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem6.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem6.setText("Estilo");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem7.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem7.setText("Familia");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem8.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem8.setText("Color");
        jMenuItem8.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem5.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem5.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setText("Tipo");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(150, 30));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(102, 102, 102));
        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("               Consultas");
        jMenu4.setPreferredSize(new java.awt.Dimension(190, 19));

        jMenuItem1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Cerveza");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem13.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem13.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem13.setText("Compradores");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuItem14.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem14.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem14.setText("Lugar");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuBar1.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(102, 102, 102));
        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setText("                  Estadística");
        jMenu5.setPreferredSize(new java.awt.Dimension(190, 19));

        jMenuItem15.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem15.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem15.setText("Cantidad de empleados");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem16.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem16.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem16.setText("Top 5 Compradores");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuItem17.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem17.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem17.setText("Top 5 Cervezas Compradas");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem17);

        jMenuBar1.add(jMenu5);

        jMenu10.setForeground(new java.awt.Color(255, 255, 255));
        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/logout-xxl.png"))); // NOI18N
        jMenu10.setText("                   ");
        jMenu10.setPreferredSize(new java.awt.Dimension(50, 19));
        jMenu10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu10MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jM_PersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_PersonaActionPerformed
           // TODO add your handling code here:
           
        RegistroPersona panelRegistro= new RegistroPersona();
        jPanel1.removeAll();
        jPanel1.add(panelRegistro);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jM_PersonaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
         RegistroFermentacion2 panelIni= new RegistroFermentacion2();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        PanelInicio panelIni= new PanelInicio();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        RegistroEstilo2 panelIni= new RegistroEstilo2();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        RegistroCuerpo2 panelIni= new RegistroCuerpo2();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();  
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        RegistroFamilia2 panelIni= new RegistroFamilia2();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        RegistroColor2 panelIni= new RegistroColor2();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        Registro.RegistroDistrito panelIni= new Registro.RegistroDistrito();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        RegistroTipo2 panelIni= new RegistroTipo2();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        Registro.RegistroProvincia panelIni= new Registro.RegistroProvincia();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Registro.RegistroCanton panelIni= new Registro.RegistroCanton();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        Registro.RegistroPais panelIni= new Registro.RegistroPais();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        Estadisticas.Top5Compradores panelEstadistica= new Estadisticas.Top5Compradores();
        jPanel1.removeAll();
        jPanel1.add(panelEstadistica);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        Estadisticas.Top5Cervezas panelEstadistica= new Estadisticas.Top5Cervezas();
        jPanel1.removeAll();
        jPanel1.add(panelEstadistica);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        Consultas.ConsultaLugar panelConsulta= new Consultas.ConsultaLugar();
        jPanel1.removeAll();
        jPanel1.add(panelConsulta);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        Consultas.ConsultaCompradores panelConsulta= new Consultas.ConsultaCompradores();
        jPanel1.removeAll();
        jPanel1.add(panelConsulta);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Consultas.ConsultaCerveza panelConsulta= new Consultas.ConsultaCerveza();
        jPanel1.removeAll();
        jPanel1.add(panelConsulta);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        Estadisticas.EstadisticaEmpleados panelEstadistica= new Estadisticas.EstadisticaEmpleados();
        jPanel1.removeAll();
        jPanel1.add(panelEstadistica);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        Registro.RegistroGustoxPersona panelIni= new Registro.RegistroGustoxPersona();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    
        
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jM_Persona1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Persona1ActionPerformed
        // TODO add your handling code here:
        Registro.RegistroEmpleado panelIni= new Registro.RegistroEmpleado();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jM_Persona1ActionPerformed

    private void jM_Persona2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Persona2ActionPerformed
        // TODO add your handling code here:
        Registro.ModificarPersona panelIni= new Registro.ModificarPersona();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    
    }//GEN-LAST:event_jM_Persona2ActionPerformed

    private void jM_Persona3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Persona3ActionPerformed
        // TODO add your handling code here:
        Registro.RegistroCerveza panelIni= new Registro.RegistroCerveza();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jM_Persona3ActionPerformed

    private void jM_Persona4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Persona4ActionPerformed
        // TODO add your handling code here:
        Registro.ModificarCerveza panelIni= new Registro.ModificarCerveza();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jM_Persona4ActionPerformed

    private void jM_Persona5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Persona5ActionPerformed
        // TODO add your handling code here:
        Registro.ModificarPrecio panelIni= new Registro.ModificarPrecio();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jM_Persona5ActionPerformed

    private void jM_Persona7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_Persona7ActionPerformed
        // TODO add your handling code here:
        Registro.RegistroUsuario panelIni= new Registro.RegistroUsuario();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    }//GEN-LAST:event_jM_Persona7ActionPerformed

    private void jMenu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu10MouseClicked
        // TODO add your handling code here:
        new InicioSesion().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu10MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jM_Persona;
    private javax.swing.JMenuItem jM_Persona1;
    private javax.swing.JMenuItem jM_Persona2;
    private javax.swing.JMenuItem jM_Persona3;
    private javax.swing.JMenuItem jM_Persona4;
    private javax.swing.JMenuItem jM_Persona5;
    private javax.swing.JMenuItem jM_Persona7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables

    public void Fermentacion(){
        RegistroFermentacion2 panelIni= new RegistroFermentacion2();
        jPanel1.removeAll();
        jPanel1.add(panelIni);
        jPanel1.repaint();
        jPanel1.revalidate();
    
    }
}
