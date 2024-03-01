/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraVehiculo;
import Controladoras.ControladoraViaje;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Vehiculo;

/**
 *
 * @author ULTRA
 */
public class PaquetesEncamino extends javax.swing.JFrame {

    /**
     * Creates new form PaquetesEncamino
     */
     /**
     * Creates new form Viajes
     */private ControladoraVehiculo controladoraVehiculo = new ControladoraVehiculo();
    private List<Vehiculo> vehiculos;
    private String rolUsuario;
    private ControladoraViaje controladoraviaje = new ControladoraViaje();
    public PaquetesEncamino(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
      mostrarTodosLosVehiculos();
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!jTable1.getSelectionModel().isSelectionEmpty()) {
                jButton2.setEnabled(true);
            } else {
                jButton2.setEnabled(false);
            }
        }
    });
        // Agregar DocumentListener a los campos de texto
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarVehiculos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarVehiculos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método es generalmente ignorado para JTextField
            }
        });

        jTextField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarVehiculos();
            }

            public void removeUpdate(DocumentEvent e) {
                filtrarVehiculos();
            }

            public void changedUpdate(DocumentEvent e) {
                // Este método es generalmente ignorado para JTextField
            }
        });
        

    }
 private void mostrarTodosLosVehiculos() {
    // Asignar los vehículos obtenidos a la lista de vehículos de la clase
    vehiculos = controladoraVehiculo.obtenerTodosLosVehiculos();
    // Filtrar vehículos por estado "Activo"
    vehiculos = vehiculos.stream().filter(v -> "Activo".equalsIgnoreCase(v.getEstado())).collect(Collectors.toList());
    mostrarVehiculosEnTabla(vehiculos);
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Modelo:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Patente:");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nro Vehiculo", "Modelo", "Patente", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            int vehiculoID = (int) jTable1.getValueAt(filaSeleccionada, 0);
            String modelo = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String patente = (String) jTable1.getValueAt(filaSeleccionada, 2);
            // Verificar si el vehículo tiene viajes asociados
            boolean tieneViajesAsociados = controladoraviaje.obtenerViajesActivosPorVehiculo(vehiculoID).isEmpty();

            if (tieneViajesAsociados) {
                JOptionPane.showMessageDialog(this, "El vehículo seleccionado no tiene viajes asociados.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ViajesPaqueteEncamino viajeVehiculo = new ViajesPaqueteEncamino(vehiculoID,modelo, patente, rolUsuario);
                viajeVehiculo.setVisible(true);
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un vehículo.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu atras = new Menu(rolUsuario);
        atras.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

   private void filtrarVehiculos() {
        // Llamado al método de filtrado con el contenido actual de los campos
        mostrarVehiculosEnTabla(controladoraVehiculo.obtenerTodosLosVehiculos());
    }
 private void mostrarVehiculosEnTabla(List<Vehiculo> vehiculos) {
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0); // Elimina todas las filas existentes en la tabla

    String modeloFiltrado = jTextField1.getText().trim().toLowerCase(); // Obtener el modelo ingresado
    String patenteFiltrada = jTextField2.getText().trim().toLowerCase(); // Obtener la patente ingresada

    for (Vehiculo vehiculo : vehiculos) {
        // Filtrar por modelo y patente (ignorar mayúsculas y minúsculas)
        if ((modeloFiltrado.isEmpty() || vehiculo.getMarca().getModelo().toLowerCase().contains(modeloFiltrado)) &&
            (patenteFiltrada.isEmpty() || vehiculo.getPatente().toLowerCase().contains(patenteFiltrada)) &&
            "Activo".equalsIgnoreCase(vehiculo.getEstado())) {
            modelo.addRow(new Object[]{
                vehiculo.getVehiculoID(),
                vehiculo.getMarca().getModelo(),
                vehiculo.getPatente(),
                vehiculo.getEstado()
            });
        }
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
