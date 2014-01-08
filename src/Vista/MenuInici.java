/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Utils.Tractar;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dolo
 * @author Federico
 */
public class MenuInici extends javax.swing.JFrame {

    /**
     * Creates new form Ejemplo
     */
    private Tractar tr;

    public MenuInici() {
        initComponents();
        tr = new Tractar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        examinar = new javax.swing.JButton();
        generar = new javax.swing.JButton();
        sortir = new javax.swing.JButton();
        txFitxer = new javax.swing.JTextField();
        JSmateries = new javax.swing.JScrollPane();
        jtMateries = new javax.swing.JList();
        fons = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestio Llistats");
        setBackground(new java.awt.Color(0, 102, 204));
        setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(0, 102, 204));
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Federico\\Documents\\NetBeansProjects\\GestioLlistatsEntrada\\GestioLListatsDisseny\\src\\imatges\\Llistat.png"));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        examinar.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        examinar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/Carpeta.png"))); // NOI18N
        examinar.setBorder(null);
        examinar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarActionPerformed(evt);
            }
        });
        getContentPane().add(examinar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 40, 50));

        generar.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/engra.png"))); // NOI18N
        generar.setText("Generar Llistes");
        generar.setBorder(null);
        generar.setBorderPainted(false);
        generar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generar.setEnabled(false);
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });
        getContentPane().add(generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 170, 40));

        sortir.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        sortir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/Sortir.png"))); // NOI18N
        sortir.setText("Sortir");
        sortir.setBorder(null);
        sortir.setBorderPainted(false);
        sortir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortirActionPerformed(evt);
            }
        });
        getContentPane().add(sortir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 90, 40));

        txFitxer.setEditable(false);
        txFitxer.setToolTipText("");
        txFitxer.setBorder(null);
        txFitxer.setDisabledTextColor(new java.awt.Color(51, 153, 255));
        txFitxer.setDoubleBuffered(true);
        txFitxer.setEnabled(false);
        txFitxer.setSelectedTextColor(new java.awt.Color(51, 153, 255));
        getContentPane().add(txFitxer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 290, 40));

        jtMateries.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jtMateries.setForeground(new java.awt.Color(0, 153, 153));
        jtMateries.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JSmateries.setViewportView(jtMateries);

        getContentPane().add(JSmateries, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 310, 150));

        fons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/Background_g.png"))); // NOI18N
        fons.setText("Selecciona les matèries de les quals vols generar llistes:");
        getContentPane().add(fons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarActionPerformed
        //Creació un nou filtre
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma-Separated Values(*.csv)", "csv");
        //Creació  fileChooser
        JFileChooser obrirFitxer = new JFileChooser();
        //Afegir el filtre
        obrirFitxer.setFileFilter(filter);
        //Indiquem el titol de la finestra
        obrirFitxer.setDialogTitle("Generador de llistats");
        //Creacio estructura que conte totes les matèries 
        Set<String> treeMateries = new TreeSet<String>();

        try {//Comprovar la acció realitzada
            if (obrirFitxer.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                //Creació fitxer seleccionat
                File file = obrirFitxer.getSelectedFile();
                //Visualització nom fitxer
                txFitxer.setText(file.getName());
                txFitxer.setEditable(false);
                //txFitxer.setEnabled(false);

                //Crida al mètode de creació de alumnes i retorna una array amb el total d'asignatures
                treeMateries = tr.asignatures(file.getAbsolutePath());

                //Visualització valors l'estructura Jlist requereix un ListModel per ser emplenada
                DefaultListModel defaultlistModel = new DefaultListModel();
                for (String aux : treeMateries) {
                    defaultlistModel.addElement(aux);
                }

                jtMateries.setModel(defaultlistModel);

            //si se ha seleccionat algun fitxer
                //activació botó Generació llistes
                if (txFitxer.getText().compareTo("") != 0) {
                    generar.setEnabled(true);
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error en obrir el fitxer", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_examinarActionPerformed

    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        //si el boto està enable i se ha seleccionat alguna materia
        if (generar.isEnabled() && !jtMateries.isSelectionEmpty()) {
            TreeSet<String> materiesSeleccio = new TreeSet<String>(jtMateries.getSelectedValuesList());

            FileNameExtensionFilter filter = new FileNameExtensionFilter("eXtensible Markup Language(*.xml)", "xml");
            //Creació  fileChooser
            JFileChooser desarFitxer = new JFileChooser();
            //Afegir el filtre
            desarFitxer.setFileFilter(filter);

            try {
                if (desarFitxer.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = desarFitxer.getSelectedFile();
                    String path = file.getAbsolutePath();
                    tr.desarFitxer(materiesSeleccio, path);

                    if (!(path.endsWith(".xml"))) {
                        path += ".xml";
                        File temp = new File(path);
                        //Rename Fitxer
                        file.renameTo(temp);
                    }
                    JOptionPane.showMessageDialog(null, "Fitxer desat correctament", null, JOptionPane.INFORMATION_MESSAGE);
                    //obrim el fitxer
                    Desktop.getDesktop().open(new File(path));
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Error en desar el fitxer", null, JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error en obrir el fitxer", null, JOptionPane.ERROR_MESSAGE);
            } catch (Exception exe) {
                JOptionPane.showMessageDialog(null, "Error", null, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Has de seleccionar una materia", null, WIDTH);
        }
    }//GEN-LAST:event_generarActionPerformed

    private void sortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sortirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                

}
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInici.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
        public void run() {
                new MenuInici().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSmateries;
    private javax.swing.JButton examinar;
    private javax.swing.JLabel fons;
    private javax.swing.JButton generar;
    private javax.swing.JList jtMateries;
    private javax.swing.JButton sortir;
    private javax.swing.JTextField txFitxer;
    // End of variables declaration//GEN-END:variables
}
