/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.ListaSimple;
import static Interfaces.CargarRed.grafoGestion;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alesia Castro
 */
public class Sucursales extends javax.swing.JFrame {
    
    public static Menu v1;
    DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloCombo2 = new DefaultComboBoxModel();
    
    public Sucursales(Menu v1) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.ActualizarComboBox();
        
    }
    
    public void ActualizarComboBox(){
        modeloCombo.removeAllElements();
        modeloCombo2.removeAllElements();
        if(!grafoGestion.verEstacionesSinSucursal().EsVacio()){
            
            ListaSimple nombreSucursales = grafoGestion.verEstacionesSinSucursal();
            for (int i = 0; i < nombreSucursales.getSize(); i++) {
                modeloCombo.addElement(nombreSucursales.getValor(i));
            }
        }
        
        if(!grafoGestion.verEstacionesConSucursal().EsVacio()){
            ListaSimple nombreSucursales = grafoGestion.verEstacionesConSucursal();
            for (int i = 0; i < nombreSucursales.getSize(); i++) {
                modeloCombo2.addElement(nombreSucursales.getValor(i));
            }
        }
    }

    /**
     * Creates new form Sucursales
     */
    public Sucursales() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sinSucursal = new javax.swing.JComboBox<>();
        agregarSucursal = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        conSucursal = new javax.swing.JComboBox<>();
        eliminarSucursal = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setFont(new java.awt.Font("Bookman Old Style", 1, 34)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 34)); // NOI18N
        jLabel1.setText("Sucursales");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 13)); // NOI18N
        jLabel2.setText("Agregar Sucursal");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel3.setText("Selecciona la estación donde deseas agregar la sucursal:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        sinSucursal.setModel(modeloCombo);
        jPanel1.add(sinSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 300, -1));

        agregarSucursal.setBackground(new java.awt.Color(0, 204, 204));
        agregarSucursal.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        agregarSucursal.setText("Agregar");
        agregarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(agregarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 300, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 470, 20));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 13)); // NOI18N
        jLabel4.setText("Eliminar Sucursal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel5.setText("Seleccionar el centro geográfico de la sucursal:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        conSucursal.setModel(modeloCombo2);
        jPanel1.add(conSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 300, -1));

        eliminarSucursal.setBackground(new java.awt.Color(51, 255, 204));
        eliminarSucursal.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        eliminarSucursal.setText("Eliminar");
        eliminarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 300, -1));

        volver.setBackground(new java.awt.Color(0, 204, 204));
        volver.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSucursalActionPerformed
        String nombreSucursal = (String) sinSucursal.getSelectedItem();
        grafoGestion.establecerSucursal(nombreSucursal);
        if(grafoGestion.verificarCoberturaTotal()){
            JOptionPane.showMessageDialog(null, "Cobertura total alcanzada");
        }else{
            JOptionPane.showMessageDialog(null, "No hay cobertura total");
        }

        this.ActualizarComboBox();
    }//GEN-LAST:event_agregarSucursalActionPerformed

    private void eliminarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarSucursalActionPerformed
        String nombreSucursal = (String) sinSucursal.getSelectedItem();
        grafoGestion.removerSucursal(nombreSucursal);
        this.ActualizarComboBox();
    }//GEN-LAST:event_eliminarSucursalActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.setVisible(false);
        this.v1.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

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
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sucursales(v1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarSucursal;
    private javax.swing.JComboBox<String> conSucursal;
    private javax.swing.JButton eliminarSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> sinSucursal;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
