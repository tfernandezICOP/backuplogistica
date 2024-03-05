/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraVehiculo;
import java.awt.Font;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Vehiculo;

/**
 *
 * @author ULTRA
 */
public class VehiculosTotales extends javax.swing.JFrame {
    private ControladoraVehiculo controladoraVehiculo = new ControladoraVehiculo();
    private List<Vehiculo> vehiculos;
    private String rolUsuario;

    /**
     * Creates new form VehiculosTotales
     */
    public VehiculosTotales(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre el JFrame en pantalla completa
        mostrarTodosLosVehiculos();
        
        // Crear un renderizador personalizado para los encabezados de las columnas
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT); // Alinear a la izquierda horizontalmente
        headerRenderer.setVerticalAlignment(SwingConstants.CENTER); // Centrar verticalmente
        headerRenderer.setFont(new Font("Arial", Font.PLAIN, 18)); // Establecer la fuente a Arial 18
        
        // Aplicar el renderizador personalizado a los encabezados de las columnas
        jTable1.getTableHeader().setDefaultRenderer(headerRenderer);
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Verificar si hay una fila seleccionada en la tabla
            if (!jTable1.getSelectionModel().isSelectionEmpty()) {
                // Habilitar el botón "Dar de baja"
                jButton2.setEnabled(true);
            } else {
                // Deshabilitar el botón "Dar de baja"
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
          if (!rolUsuario.equals("Administrador")) {
        jButton3.setVisible(false);
        jButton4.setVisible(false);

    }     
}
    
    private void mostrarTodosLosVehiculos() {
    // Asignar los vehículos obtenidos a la lista de vehículos de la clase
    vehiculos = controladoraVehiculo.obtenerTodosLosVehiculos();
    // Filtrar vehículos por estado "Activo"
    vehiculos = vehiculos.stream().filter(v -> "Activo".equalsIgnoreCase(v.getEstado())).collect(Collectors.toList());
    mostrarVehiculosEnTabla(vehiculos);
    }

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
                vehiculo.getNro_vehiculo(),
                vehiculo.getPatente(),
                vehiculo.getEstado()
            });
        }
    }
}
  
private void darDeBajaVehiculo() {
    int selectedRow = jTable1.getSelectedRow();

    if (selectedRow >= 0) {
        Vehiculo vehiculoSeleccionado = vehiculos.get(selectedRow);

        Object[] options = {"Si", "No"};
        JLabel mensajeConfirmacion = new JLabel("¿Seguro que desea dar de baja el vehículo con patente " + vehiculoSeleccionado.getPatente() + "?");
        mensajeConfirmacion.setFont(new Font("Arial", Font.PLAIN, 18));
        
        int opcion = JOptionPane.showOptionDialog(
                this,
                mensajeConfirmacion,
                "Confirmar Baja",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (opcion == JOptionPane.YES_OPTION) {
            // Llama al método que cambia el estado del vehículo a "Baja"
            controladoraVehiculo.darDeBajaVehiculo(vehiculoSeleccionado.getVehiculoID());

            // Actualiza la lista de vehículos y la tabla
            mostrarTodosLosVehiculos();

            JLabel mensajeExito = new JLabel("Vehículo dado de baja exitosamente.");
            mensajeExito.setFont(new Font("Arial", Font.PLAIN, 18));
            JOptionPane.showMessageDialog(
                    this,
                    mensajeExito,
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    } else {
        JLabel mensajeError = new JLabel("Por favor, seleccione un vehículo antes de dar de baja.");
        mensajeError.setFont(new Font("Arial", Font.PLAIN, 18));
        JOptionPane.showMessageDialog(
                this,
                mensajeError,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
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

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Modelo:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Patente:");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Vehiculo", "Modelo", "N° Vehiculo", "Patente", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de vehiculos");

        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setText("Dar de baja");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton4.setText("Editar vehiculo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(100, 100, 100)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(100, 100, 100)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        darDeBajaVehiculo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu atras = new Menu(rolUsuario);
        atras.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        RegistrarMarcaVehiculo marcavehiculo = new RegistrarMarcaVehiculo(this, rolUsuario);
        marcavehiculo.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada == -1) {
        JLabel mensaje = new JLabel("Seleccione un vehículo para editar.");
        mensaje.setFont(new Font("Arial", Font.PLAIN, 18));
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    Vehiculo vehiculoSeleccionado = vehiculos.get(filaSeleccionada);

    EditarVehiculo editarVehiculo = new EditarVehiculo(vehiculoSeleccionado, rolUsuario);
   
    editarVehiculo.setVisible(true);
    dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

   
public void mostrarVentana() {
    mostrarTodosLosVehiculos();
    this.setVisible(true);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
