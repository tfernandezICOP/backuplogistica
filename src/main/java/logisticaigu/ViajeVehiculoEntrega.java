/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraPaquete;
import Controladoras.ControladoraViaje;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Paquete;
import logisticalogica.Viaje;

/**
 *
 * @author ULTRA
 */
public class ViajeVehiculoEntrega extends javax.swing.JFrame {
private Viaje viaje;
    private int vehiculoID;
    String modelo;
    String patente;
private ControladoraPaquete controladoraPaquete;
    /**
     * Creates new form ViajeVehiculoEntrega
     */
    
private String rolUsuario;
    private ControladoraViaje controladoraviaje;
    public ViajeVehiculoEntrega(int vehiculoID ,String modelo, String patente, String rolUsuario) {
        initComponents();
        System.out.println("Vehículo ID: " + vehiculoID);
       


        this.vehiculoID = vehiculoID;
        this.modelo = modelo;
        this.patente = patente;
        this.controladoraPaquete = new ControladoraPaquete();
        this.rolUsuario = rolUsuario;
        this.viaje = new Viaje();
        this.controladoraviaje = new ControladoraViaje();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre el JFrame en pantalla completa

        // Crear un renderizador personalizado para los encabezados de las columnas
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT); // Alinear a la izquierda     horizontalmente
        headerRenderer.setVerticalAlignment(SwingConstants.CENTER); // Centrar verticalmente
        headerRenderer.setFont(new Font("Arial", Font.PLAIN, 18)); // Establecer la fuente a Arial 18  
        // Aplicar el renderizador personalizado a los encabezados de las columnas
        jTable1.getTableHeader().setDefaultRenderer(headerRenderer);

        llenarTabla();
        jLabel1.setText(modelo); 
        jLabel2.setText(patente);   
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "N° Viaje", "Origen", "Localidad de origen", "Destino", "Localidad de destino", "Fecha de viaje", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Gestionar entrega - Seleccionar viaje");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Modelo:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Patente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(100, 100, 100)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
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
      int idViajeSeleccionado = obtenerIdViajeSeleccionado();

    if (idViajeSeleccionado != -1) {
        // Verificar si el viaje seleccionado tiene paquetes "EN CAMINO" asociados
        if (hayPaquetesEnCamino(idViajeSeleccionado)) {
            ConfirmarEntrega confirmaentrega = new ConfirmarEntrega(vehiculoID, modelo,patente,idViajeSeleccionado, rolUsuario);
            confirmaentrega.setVisible(true);
            dispose();
        } else {
            // Crear un JLabel para personalizar el mensaje
            JLabel nohaypaqueencamino = new JLabel("El viaje seleccionado no tiene paquetes 'EN CAMINO'.");
            // Establecer la fuente del JLabel
            nohaypaqueencamino.setFont(new Font("Arial", Font.PLAIN, 18));
            // Mostrar el cuadro de diálogo de advertencia con el JLabel personalizado y el título personalizado
            JOptionPane.showMessageDialog(this, nohaypaqueencamino, "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        // Crear un JLabel para personalizar el mensaje
        JLabel selecviaje = new JLabel("Por favor, seleccione un viaje.");
        // Establecer la fuente del JLabel
        selecviaje.setFont(new Font("Arial", Font.PLAIN, 18));
        // Mostrar el cuadro de diálogo de advertencia con el JLabel personalizado y el título personalizado
        JOptionPane.showMessageDialog(this, selecviaje, "Alerta", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ViajesEntrega atras = new ViajesEntrega(rolUsuario);
        atras.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

   
private void llenarTabla() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);
   List<Viaje> viajes = controladoraviaje.obtenerViajesActivosPorVehiculo(vehiculoID);

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    for (Viaje viaje : viajes) {
        String fechaFormateada = dateFormat.format(viaje.getFecha());
        model.addRow(new Object[]{
            viaje.getViajeID(),
            viaje.getOrigen().getNombre(),
            viaje.getLocalidadOrigen().getNombre(),
            viaje.getDestino().getNombre(),
            viaje.getLocalidadDestino().getNombre(),
            fechaFormateada,
            viaje.getEstado()
        });
    }
}

private boolean hayPaquetesEnCamino(int idViaje) {
    List<Paquete> paquetes = controladoraPaquete.obtenerPaquetesEnCaminoPorViaje(idViaje);
    return !paquetes.isEmpty();
}



   
    private int obtenerIdViajeSeleccionado() {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada != -1) {
        return (int) jTable1.getValueAt(filaSeleccionada, 0 );
    }
    return -1; 
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
