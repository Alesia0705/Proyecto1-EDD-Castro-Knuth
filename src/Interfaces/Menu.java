/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import static Interfaces.CargarRed.grafoGestion;

/**
 *
 * @author Victoria knuth
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //grafoGestion.getGrafo().mostrarGrafo();
        
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
        mostrarGrafo = new javax.swing.JButton();
        establecerT = new javax.swing.JButton();
        colocarSucursal = new javax.swing.JButton();
        coberturas = new javax.swing.JButton();
        AgregarLineas = new javax.swing.JButton();
        cargarRed = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        mostrarGrafo.setText("Mostrar Grafo");
        mostrarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarGrafoActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 160, -1));

        establecerT.setText("Establecer T");
        establecerT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                establecerTActionPerformed(evt);
            }
        });
        jPanel1.add(establecerT, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        colocarSucursal.setText("Colocar Sucursal");
        colocarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colocarSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(colocarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 150, -1));

        coberturas.setText("Coberturas");
        coberturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coberturasActionPerformed(evt);
            }
        });
        jPanel1.add(coberturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        AgregarLineas.setText("Agregar Lineas");
        AgregarLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarLineasActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarLineas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        cargarRed.setText("Cargar Red");
        cargarRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarRedActionPerformed(evt);
            }
        });
        jPanel1.add(cargarRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarGrafoActionPerformed
//        VisualizadorGrafo visualizador = new VisualizadorGrafo(grafoGestion.getGrafo());
//        visualizador.mostrarGrafo();
    }//GEN-LAST:event_mostrarGrafoActionPerformed

    private void establecerTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_establecerTActionPerformed
//        ModificarT ventana4 = new ModificarT(this);
//        this.setVisible(false);
//        ventana4.setVisible(true);
    }//GEN-LAST:event_establecerTActionPerformed

    private void colocarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colocarSucursalActionPerformed
//        Sucursales ventana6 = new Sucursales(this);
//        this.setVisible(false);
    }//GEN-LAST:event_colocarSucursalActionPerformed

    private void coberturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coberturasActionPerformed
        Coberturas ventana5 = new Coberturas(this);
        this.setVisible(false);
        ventana5.setVisible(true);
    }//GEN-LAST:event_coberturasActionPerformed

    private void AgregarLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarLineasActionPerformed
//        AgregarLineas ventana7 = new AgregarLineas(this);
//        ventana7.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_AgregarLineasActionPerformed

    private void cargarRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarRedActionPerformed
//        grafoGestion.destruirGestor();
//        this.v1.setVisible(true);
//        this.setVisible(false);
    }//GEN-LAST:event_cargarRedActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarLineas;
    private javax.swing.JButton cargarRed;
    private javax.swing.JButton coberturas;
    private javax.swing.JButton colocarSucursal;
    private javax.swing.JButton establecerT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mostrarGrafo;
    // End of variables declaration//GEN-END:variables
}
