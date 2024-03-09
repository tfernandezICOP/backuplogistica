/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraPaquete;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Paquete;

/**
 *
 * @author ULTRA
 */
public class HistorialPaquete extends javax.swing.JFrame {
private int viajeID;
    private ControladoraPaquete controladoraPaquete;
    private String rolUsuario;
    private List<Paquete> paquetes;

    /**
     * Creates new form HistorialPaquete
     */
    public HistorialPaquete(int viajeID,String rolUsuario) {
        
        initComponents();
        this.rolUsuario = rolUsuario;
        this.viajeID = viajeID;
        this.controladoraPaquete = new ControladoraPaquete();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre el JFrame en pantalla completa

        // Crear un renderizador personalizado para los encabezados de las columnas
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT); // Alinear a la izquierda horizontalmente
        headerRenderer.setVerticalAlignment(SwingConstants.CENTER); // Centrar verticalmente
        headerRenderer.setFont(new Font("Arial", Font.PLAIN, 18)); // Establecer la fuente a Arial 18
        // Aplicar el renderizador personalizado a los encabezados de las columnas
        jTable1.getTableHeader().setDefaultRenderer(headerRenderer);
        
        jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            filtrarPaquetes();
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            filtrarPaquetes();
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            filtrarPaquetes();
        }
    });
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
  private void filtrarPaquetes() {
    String codigoPaqueteTexto = jTextField1.getText();

    if (!codigoPaqueteTexto.isEmpty()) {
        List<Paquete> paquetesFiltrados = new ArrayList<>();
        if (paquetes != null) {
            for (Paquete paquete : paquetes) {
                // Cambia la comparación para que busque coincidencias parciales del código de paquete
                if (String.valueOf(paquete.getCodigo_paquete()).contains(codigoPaqueteTexto)) {
                    paquetesFiltrados.add(paquete);
                }
            }
            mostrarPaquetes(paquetesFiltrados);
        } else {
            System.out.println("La lista de paquetes está vacía o no ha sido inicializada.");
        }
    } else {
        mostrarPaquetes(paquetes);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo del paquete", "Destino", "Domicilio", "Receptor", "Descripcion", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Codigo del paquete:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Historial de paquetes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       HistorialViajes atras = new HistorialViajes(rolUsuario);
       atras.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

  
 private void llenarTabla() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    paquetes = controladoraPaquete.obtenerPaquetesPorViaje(viajeID); // Obtener los paquetes asociados a este viaje

    for (Paquete paquete : paquetes) {
         String nombreApellidoReceptor = paquete.getReceptor().getNombre() + " " + paquete.getReceptor().getApellido();
            
            String provinciaLocalidadDestino = paquete.getDestino().getNombre() + ", " + paquete.getLocalidadDestino().getNombre();
        model.addRow(new Object[]{
            paquete.getCodigo_paquete(), 
            provinciaLocalidadDestino,
            paquete.getDomicilioEntrega(), 
            nombreApellidoReceptor,
            paquete.getDescripcion(), 
            paquete.getEstado()
        });
    }
}

 
 

private void mostrarPaquetes(List<Paquete> paquetesMostrados) {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
    
    for (Paquete paquete : paquetesMostrados) {
        model.addRow(new Object[]{
            paquete.getCodigo_paquete(),
            paquete.getDescripcion(),
            paquete.getDomicilioEntrega(),
            paquete.getEstado()
        });
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
