/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraMantenimiento;
import Controladoras.ControladoraMantenimientoRealizado;
import Controladoras.ControladoraParteDiario;
import Controladoras.ControladoraVehiculo;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logisticalogica.MantenimientoRealizado;
import logisticalogica.ParteDiario;
import logisticalogica.Vehiculo;

/**
 *
 * @author ULTRA
 */
public  class AvisoMantenimiento extends javax.swing.JFrame {
 private ControladoraMantenimiento controladoramante = new ControladoraMantenimiento();
    private ControladoraVehiculo controladoravehiculo = new ControladoraVehiculo();
    private Vehiculo vehiculoseleccionado;
    private ControladoraMantenimientoRealizado controladoramanterealizado = new ControladoraMantenimientoRealizado();
    private ControladoraParteDiario controladoraPD = new ControladoraParteDiario();
     private List<ParteDiario> parteDiarioList;
        private String rolUsuario;

    /**
     * Creates new form AvisoMantenimiento
     */
    public AvisoMantenimiento(String rolUsuario) {
        initComponents();
                    JOptionPane.showMessageDialog(this, "¡Bienvenido, " + rolUsuario + "!");

        actualizarTablaAvisoMantenimiento();
            this.rolUsuario = rolUsuario;
// Llama al método para actualizar la tabla al crear la ventana

 jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Verificar si se ha seleccionado una fila en la tabla
            if (!jTable1.getSelectionModel().isSelectionEmpty()) {
                // Habilitar el botón "Aceptar"
                jButton1.setEnabled(true);
            } else {
                // Deshabilitar el botón "Aceptar"
                jButton1.setEnabled(false);
            }
        }
    });
    
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Vehiculo", "Tipo", "Patente", "Kilometros", "Estado", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Avisos de Mantenimiento");

        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1894, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
  int filaSeleccionada = jTable1.getSelectedRow();

    // Verificar si se ha seleccionado una fila válida
    if (filaSeleccionada != -1) {
        // Obtener el ID del vehículo seleccionado en la tabla
        int idVehiculoSeleccionado = (int) jTable1.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID del vehículo está en la primera columna

        // Obtener el vehículo correspondiente a partir del ID en la base de datos
        vehiculoseleccionado = controladoravehiculo.obtenerVehiculoPorID(idVehiculoSeleccionado);

        // Mostrar un cuadro de diálogo de confirmación
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro que quieres seleccionar el vehículo con patente " + vehiculoseleccionado.getPatente() + "?", "Confirmar selección", JOptionPane.YES_NO_OPTION);

        // Verificar la opción seleccionada por el usuario
        if (opcion == JOptionPane.YES_OPTION) {
            // Resto del código para mostrar la ventana ConfirmarMantenimiento y cerrar la ventana actual
            ConfirmarMantenimiento confirmarMantenimientoFrame = new ConfirmarMantenimiento(vehiculoseleccionado, rolUsuario); // Pasar el rolUsuario
            confirmarMantenimientoFrame.setVisible(true);

            // Cerrar la ventana actual
            this.dispose();
        }
    } else {
        // Mostrar un mensaje si no se ha seleccionado ninguna fila válida
        JOptionPane.showMessageDialog(this, "Seleccione un vehículo primero", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Menu atras = new Menu( rolUsuario);
        atras.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
 public void actualizarTablaAvisoMantenimiento() {
      System.out.println("Actualizando tabla de avisos");
    
     DefaultTableModel modeloTabla = (DefaultTableModel) jTable1.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevas filas

        // Llenar la tabla con los vehículos que necesitan mantenimiento
        mostrarVehiculosEnTabla();
    }
 private void mostrarVehiculosEnTabla() {
     
     List<Vehiculo> vehiculos = controladoravehiculo.obtenerTodosLosVehiculos();

    // Crear el modelo de tabla
    DefaultTableModel modeloTabla = new DefaultTableModel();
    modeloTabla.addColumn("ID");
    modeloTabla.addColumn("Vehiculo");
    modeloTabla.addColumn("Tipo");
    modeloTabla.addColumn("Patente");
    modeloTabla.addColumn("Kilometros");
    modeloTabla.addColumn("Estado");

    // Llenar el modelo con los vehículos que cumplen con las condiciones
    for (Vehiculo vehiculo : vehiculos) {
        // Obtener el último mantenimiento realizado
        MantenimientoRealizado ultimoMantenimiento = controladoramanterealizado.obtenerUltimoMantenimientoRealizado(vehiculo);
        // Obtener todos los ParteDiario para el vehículo
        parteDiarioList = controladoraPD.obtenerParteDiarioPorVehiculo(vehiculo);

        // Calcular los kilómetros totales recorridos desde el último mantenimiento
        int kmTotales = 0;
        if (!parteDiarioList.isEmpty()) {
            for (ParteDiario parteDiario : parteDiarioList) {
                kmTotales += parteDiario.getKm();
            }
        }

        if (ultimoMantenimiento != null) {
            kmTotales -= ultimoMantenimiento.getKmMantenimiento();
        }

        boolean necesitaMantenimiento = (ultimoMantenimiento != null && kmTotales >= 10000) ||
            (ultimoMantenimiento == null && (vehiculo.getMantenimiento() != null && vehiculo.getMantenimiento().getKm() >= 10000 || vehiculo.getMantenimiento() == null && kmTotales >= 10000));

        if (!necesitaMantenimiento || !"Activo".equalsIgnoreCase(vehiculo.getEstado())) {
            continue;
        }

        Object[] fila = {
            vehiculo.getVehiculoID(),
            vehiculo.getMarca().getModelo(),
            vehiculo.getMarca().getTipo(),
            vehiculo.getPatente(),
            kmTotales,
            vehiculo.getEstado()
        };
        modeloTabla.addRow(fila);
    }

    // Establecer el modelo en la tabla
    jTable1.setModel(modeloTabla);
}
public void mostrarVentana() {
        mostrarVehiculosEnTabla(); // Llama al método para actualizar la tabla cada vez que se muestra la ventana
        setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
