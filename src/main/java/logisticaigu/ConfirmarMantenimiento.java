/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraMantenimiento;
import Controladoras.ControladoraMantenimientoRealizado;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import logisticalogica.MantenimientoRealizado;
import logisticalogica.Vehiculo;
/**
 *
 * @author ULTRA
 */
public class ConfirmarMantenimiento extends javax.swing.JFrame {

    Vehiculo vehiculoSeleccionado; 
    private Vehiculo vehiculo;
    private String rolUsuario;
    private ControladoraMantenimientoRealizado controladoraMantenimientoRealizado = new ControladoraMantenimientoRealizado();
    private MantenimientoRealizado mantenimientoExistente; // Agrega esta línea
    private boolean tieneMantenimientoRealizado; // Agrega esta línea
    private Date fechaSeleccionada; // Nueva variable para almacenar la fecha seleccionada del JCalendar
    public ConfirmarMantenimiento(Vehiculo vehiculo, String rolUsuario)  {
        this.vehiculo = vehiculo;
        this.rolUsuario = rolUsuario;
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre el JFrame en pantalla completa
        inicializarVentana(); // Llama a la inicialización después de haber asignado el vehículo

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Marca = new javax.swing.JLabel();
        Patente = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Confirmar fecha de mantenimiento");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Fecha:");

        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Marca.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Marca.setText("Marca:");

        Patente.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Patente.setText("Patente:");

        jCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(100, 100, 100)
                        .addComponent(jButton1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(473, 473, 473)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Patente, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(86, 86, 86)
                .addComponent(Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(Patente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private ControladoraMantenimiento controladoraMantenimiento = new ControladoraMantenimiento();

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    guardarDatosMantenimientoRealizado() ;
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       AvisoMantenimiento avisomante =  new AvisoMantenimiento(rolUsuario);
       avisomante.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
    if ("calendar".equals(evt.getPropertyName())) {
        // Obtener la fecha seleccionada del JCalendar
        Date selectedDate = jCalendar1.getDate();
        
        // Actualizar la variable fechaSeleccionada
        fechaSeleccionada = selectedDate;
    }    }//GEN-LAST:event_jCalendar1PropertyChange
  

    /**
     * @param args the command line arguments
     */
   void inicializarVentana() {
    if (vehiculo != null) {
        String patente = vehiculo.getPatente();
        String marca = vehiculo.getMarca().getModelo();

        // Actualizar las etiquetas con la información del vehículo
        Marca.setText("Marca: " + marca);
        Patente.setText("Patente: " + patente);
    }
}
private void guardarDatosMantenimientoRealizado() {
    MantenimientoRealizado nuevoMantenimiento = null; // Declarar la variable fuera del bloque try
    // Verificar si el campo de fecha está vacío
    if (fechaSeleccionada == null) {
        // Si no se selecciona ninguna fecha, establecer la fecha predeterminada como la fecha actual
        fechaSeleccionada = new Date(); // Obtener la fecha actual
    }
    // Obtener el último kilómetro recorrido del vehículo desde el parte diario
    int ultimoKmRecorrido = controladoraMantenimientoRealizado.obtenerKmRecorridosMasRecientes(vehiculo);
    // Comprobar si el vehículo ya tiene un mantenimiento realizado
    boolean tieneMantenimiento = controladoraMantenimientoRealizado.tieneMantenimientoRealizado(vehiculo);
    if (tieneMantenimiento) {
        // Si ya tiene un mantenimiento, actualizar la fecha y el kilometraje
        MantenimientoRealizado mantenimientoExistente = controladoraMantenimientoRealizado.obtenerUltimoMantenimientoRealizado(vehiculo);
        mantenimientoExistente.setFechaMantenimiento(fechaSeleccionada);
        mantenimientoExistente.setKmMantenimiento(ultimoKmRecorrido);
        controladoraMantenimientoRealizado.actualizarMantenimiento(mantenimientoExistente);
        System.out.println("Mantenimiento realizado actualizado exitosamente. ID: " + mantenimientoExistente.getMantenimientoRealizadoID());
        
        // Imprimir información para verificar qué se está pasando a TipoMantenimiento
        System.out.println("Mantenimiento Realizado Existente: " + mantenimientoExistente);
        // Crear una instancia de TipoMantenimiento y pasar el MantenimientoRealizado adecuado
        TipoMantenimiento tipoMantenimientoFrame = new TipoMantenimiento(mantenimientoExistente, rolUsuario);
        tipoMantenimientoFrame.setVisible(true);
    } else {
        // Si no tiene mantenimiento, crear uno nuevo
        nuevoMantenimiento = new MantenimientoRealizado(); // Asignar un valor a la variable dentro del bloque try
        nuevoMantenimiento.setFechaMantenimiento(fechaSeleccionada);
        nuevoMantenimiento.setVehiculo(vehiculo);
        nuevoMantenimiento.setKmMantenimiento(ultimoKmRecorrido);
        controladoraMantenimientoRealizado.guardarmantenimiento(nuevoMantenimiento);
        System.out.println("Mantenimiento realizado guardado exitosamente. ID: " + nuevoMantenimiento.getMantenimientoRealizadoID());
        
        // Imprimir información para verificar qué se está pasando a TipoMantenimiento
        System.out.println("Mantenimiento Realizado Nuevo: " + nuevoMantenimiento);
        // Crear una instancia de TipoMantenimiento y pasar el MantenimientoRealizado adecuado
        TipoMantenimiento tipoMantenimientoFrame = new TipoMantenimiento(nuevoMantenimiento, rolUsuario);
        tipoMantenimientoFrame.setVisible(true);
    }
    // Mostrar un mensaje de éxito
    // Crear un JLabel para personalizar el mensaje
    JLabel manteguardado = new JLabel("Mantenimiento realizado y guardado exitosamente");
    // Establecer la fuente del JLabel
    manteguardado.setFont(new Font("Arial", Font.PLAIN, 18));

    // Mostrar el cuadro de diálogo de información con el JLabel personalizado
    JOptionPane.showMessageDialog(this, manteguardado);
    // Cerrar la ventana actual después de abrir la nueva ventana
    this.dispose();
}


















   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Marca;
    private javax.swing.JLabel Patente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

   
}
