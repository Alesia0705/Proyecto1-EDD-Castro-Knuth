/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Funciones.CargarJSON;
import Gestion.GestionGrafo;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Victoria Knuth
 */
public class CargarRed extends javax.swing.JFrame {

    public static Bienvenido v1;
    public static GestionGrafo grafoGestion = new GestionGrafo(3);
    
    public CargarRed(Bienvenido v1) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        Titulo2 = new javax.swing.JLabel();
        Ruta_Fichero2 = new javax.swing.JTextField();
        buscarRuta2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Archivo_Cargado = new javax.swing.JTextArea();
        cargarRed = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo2.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        Titulo2.setText("Cargar Red de Transporte");
        jPanel3.add(Titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));
        jPanel3.add(Ruta_Fichero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 350, -1));

        buscarRuta2.setText("Buscar Archivo");
        buscarRuta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarRuta2ActionPerformed(evt);
            }
        });
        jPanel3.add(buscarRuta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 130, -1));

        Archivo_Cargado.setColumns(20);
        Archivo_Cargado.setRows(5);
        jScrollPane1.setViewportView(Archivo_Cargado);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 350, 250));

        cargarRed.setText("Cargar Red");
        cargarRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarRedActionPerformed(evt);
            }
        });
        jPanel3.add(cargarRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 350, -1));

        salir.setText("X");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel3.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 50, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarRuta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarRuta2ActionPerformed
        // Esto va dentro del constructor de tu JFrame o en el evento de un botón
        JFileChooser fc = new JFileChooser();

        // Creo el filtro para archivos .json
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");

        // Le indico el filtro
        fc.setFileFilter(filtro);

        // Abrimos la ventana, guardamos la opción seleccionada por el usuario
        int seleccion = fc.showOpenDialog(this);

        // Si el usuario presiona aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            // Selecciono el fichero
            File fichero = fc.getSelectedFile();

            // Escribo la ruta del fichero en un JTextField (si lo tienes)
            Ruta_Fichero2.setText(fichero.getAbsolutePath()); // Aquí debes usar el JTextField que tienes en el JFrame para mostrar la ruta del archivo
            try (FileReader fr = new FileReader(fichero)) {
                StringBuilder cadena = new StringBuilder();
                int valor = fr.read();

                // Leo el contenido del archivo JSON
                while (valor != -1) {
                    cadena.append((char) valor);
                    valor = fr.read();
                }

                // Modifico el valor del JTextArea para mostrar el contenido del archivo
                Archivo_Cargado.setText(cadena.toString());

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else {
            // Si el usuario no seleccionó ningún archivo, muestra un mensaje
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún archivo.");
        }
    }//GEN-LAST:event_buscarRuta2ActionPerformed

    private void cargarRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarRedActionPerformed
        if (!Archivo_Cargado.getText().trim().isEmpty()) {
            CargarJSON cargar = new CargarJSON();
            cargar.procesarRedTransporteJSON(Ruta_Fichero2.getText());
            grafoGestion.inicializar(cargar.getEstaciones());
            
            Menu menu = new Menu();
            menu.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Archivo Vacio");
        }
    }//GEN-LAST:event_cargarRedActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

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
            java.util.logging.Logger.getLogger(CargarRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarRed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarRed(v1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Archivo_Cargado;
    private javax.swing.JTextField Ruta_Fichero;
    private javax.swing.JTextField Ruta_Fichero1;
    private javax.swing.JTextField Ruta_Fichero2;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel Titulo1;
    private javax.swing.JLabel Titulo2;
    private javax.swing.JButton buscarRuta;
    private javax.swing.JButton buscarRuta1;
    private javax.swing.JButton buscarRuta2;
    private javax.swing.JButton cargarRed;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
