/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import static Interfaces.CargarRed.grafoGestion;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alesia Castro
 */
public class AgregarLineas extends javax.swing.JFrame {

    /**
     * Creates new form AgregarLinea
     */
    public static Menu v1;
    DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloCombo2 = new DefaultComboBoxModel();
    
    public AgregarLineas(Menu v1) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.ActualizarComboBox();
    }
    
    private void ActualizarComboBox(){
       this.ActualizarComboBox1();
       this.ActualizarComboBox2();
    }
    
    
    private void ActualizarComboBox1(){
        modeloCombo.removeAllElements();
        if (grafoGestion.verEstaciones()!= null) {
            for (int i = 0; i < grafoGestion.verEstaciones().getSize(); i++) {
                String nombre = (String) grafoGestion.verEstaciones().getValor(i);
                modeloCombo.addElement(nombre);
            }
        }
    
    }
    
    private void ActualizarComboBox2(){
        modeloCombo2.removeAllElements();
        if (grafoGestion.verEstaciones()!= null) {
            for (int i = 0; i < grafoGestion.verEstaciones().getSize(); i++) {
                String nombre = (String) grafoGestion.verEstaciones().getValor(i);
                modeloCombo2.addElement(nombre);
            }
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

        inputNewEstacion = new javax.swing.JTextField();
        AgregarLinea = new javax.swing.JLabel();
        agregarEstacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ciudadInicio = new javax.swing.JComboBox<>();
        ciudadLlegada = new javax.swing.JComboBox<>();
        agregarAdy = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputNewEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNewEstacionActionPerformed(evt);
            }
        });
        getContentPane().add(inputNewEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 280, -1));

        AgregarLinea.setBackground(new java.awt.Color(255, 255, 255));
        AgregarLinea.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        AgregarLinea.setText("Agregar Línea");
        getContentPane().add(AgregarLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 280, 60));

        agregarEstacion.setBackground(new java.awt.Color(0, 255, 204));
        agregarEstacion.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        agregarEstacion.setText("Agregar Estación");
        agregarEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEstacionActionPerformed(evt);
            }
        });
        getContentPane().add(agregarEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 160, -1));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel1.setText("Nombre de la Estación");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        ciudadInicio.setModel(modeloCombo);
        ciudadInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudadInicioActionPerformed(evt);
            }
        });
        getContentPane().add(ciudadInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 280, -1));

        ciudadLlegada.setModel(modeloCombo2);
        getContentPane().add(ciudadLlegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 280, -1));

        agregarAdy.setBackground(new java.awt.Color(153, 255, 204));
        agregarAdy.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        agregarAdy.setText("Agregar Adyacencia");
        agregarAdy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAdyActionPerformed(evt);
            }
        });
        getContentPane().add(agregarAdy, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 160, -1));

        volver.setBackground(new java.awt.Color(0, 204, 204));
        volver.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNewEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNewEstacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNewEstacionActionPerformed

    private void agregarEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEstacionActionPerformed
        if(!"".equals(inputNewEstacion.getText())){
            String nombre = inputNewEstacion.getText();
            grafoGestion.añadirEstacion(nombre);
            this.ActualizarComboBox();
        }else{
            JOptionPane.showMessageDialog(null, "El TextField está vacio.");
        }
    }//GEN-LAST:event_agregarEstacionActionPerformed

    private void ciudadInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudadInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadInicioActionPerformed

    private void agregarAdyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAdyActionPerformed
        if(!ciudadInicio.getSelectedItem().equals(ciudadLlegada.getSelectedItem())){
            String nombreEstacion1 = (String) ciudadInicio.getSelectedItem();
            String nombreEstacion2 = (String) ciudadLlegada.getSelectedItem();

            grafoGestion.conectarEstacion(nombreEstacion1, nombreEstacion2);
            this.ActualizarComboBox();
        }else{
            JOptionPane.showMessageDialog(null, "No se puede realizar una conexión hacia si mismo. La ciudad Inicio y Final deben ser diferentes.");
        }
    }//GEN-LAST:event_agregarAdyActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarLineas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarLineas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarLineas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarLineas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarLineas(v1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgregarLinea;
    private javax.swing.JButton agregarAdy;
    private javax.swing.JButton agregarEstacion;
    private javax.swing.JComboBox<String> ciudadInicio;
    private javax.swing.JComboBox<String> ciudadLlegada;
    private javax.swing.JTextField inputNewEstacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
