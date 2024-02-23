/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraLocalidad;
import Controladoras.ControladoraProvincia;
import Controladoras.ControladoraViaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import logisticalogica.Localidad;
import logisticalogica.Provincia;
import logisticalogica.Vehiculo;
import logisticalogica.Viaje;

/**
 *
 * @author ULTRA
 */
public class RegistrarViaje extends javax.swing.JFrame {
    private Vehiculo vehiculoSeleccionado;
    private ControladoraViaje controladoraViaje = new ControladoraViaje();
    private ControladoraLocalidad controladoralocalidad;
    private ControladoraProvincia controladoraprovincia;
    private Viaje viaje = new Viaje(); // Asegúrate de tener un objeto Viaje en el formulario
    private int idViaje; 
    private String rolUsuario;
    private List<Provincia> provincias ;
    /**
     * Creates new form RegistrarViaje
     */
    public RegistrarViaje(Vehiculo vehiculoSeleccionado, String rolUsuario) {
      initComponents();
    controladoraprovincia = new ControladoraProvincia();
    controladoralocalidad = new ControladoraLocalidad();
    this.vehiculoSeleccionado = vehiculoSeleccionado;
    this.rolUsuario = rolUsuario;
    llenarComboBoxProvincias();
    llenarComboBoxProvinciasDestino(); // Llenar jComboBox3 con todas las provincias
    jComboBox1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreProvincia = (String) jComboBox1.getSelectedItem();
            Provincia provinciaSeleccionada = null;
            for (Provincia provincia : provincias) {
                if (provincia.getNombre().equals(nombreProvincia)) {
                    provinciaSeleccionada = provincia;
                    break;
                }
            }
            llenarComboBoxLocalidades(provinciaSeleccionada);
        }
    });
    jComboBox3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreProvincia = (String) jComboBox3.getSelectedItem();
            Provincia provinciaSeleccionada = null;
            for (Provincia provincia : provincias) {
                if (provincia.getNombre().equals(nombreProvincia)) {
                    provinciaSeleccionada = provincia;
                    break;
                }
            }
            llenarComboBoxLocalidadesDestino(provinciaSeleccionada);
        }
    });
        
    }
private void llenarComboBoxProvincias() {
         provincias = controladoraprovincia.obtenerTodasLasProvincias();
        for (Provincia provincia : provincias) {
            jComboBox1.addItem(provincia.getNombre());
        }
        
    }
    
    // Método para llenar el JComboBox de localidades
    private void llenarComboBoxLocalidades(Provincia provincia) {
        jComboBox2.removeAllItems(); // Limpiar el JComboBox de localidades antes de agregar nuevos elementos
        List<Localidad> localidades = controladoralocalidad.obtenerLocalidadesPorProvincia(provincia);
        for (Localidad localidad : localidades) {
            jComboBox2.addItem(localidad.getNombre());
        }
    }
   private void llenarComboBoxProvinciasDestino() {
    // Limpia los elementos previos si existen
    jComboBox3.removeAllItems();
    for (Provincia provincia : provincias) {
        jComboBox3.addItem(provincia.getNombre());
    }
}

private void llenarComboBoxLocalidadesDestino(Provincia provincia) {
    jComboBox4.removeAllItems();
    if (provincia != null) {
        List<Localidad> localidades = controladoralocalidad.obtenerLocalidadesPorProvincia(provincia);
        for (Localidad localidad : localidades) {
            jComboBox4.addItem(localidad.getNombre());
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Envio");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Provincia Origen:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Provincia Destino:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Fecha:");

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

        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Localidad Origen:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("Localidad Destino:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(790, 790, 790)
                                .addComponent(jButton2)
                                .addGap(62, 62, 62)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(734, 734, 734)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(76, 76, 76)
                                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 773, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(696, 696, 696)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(360, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViajeIGU atras = new ViajeIGU(rolUsuario);
        atras.setVisible(true);
        dispose(); // Cierra la pantalla actual
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   try {
        // Obtener la provincia y la localidad seleccionadas
        String provinciaOrigen = (String) jComboBox1.getSelectedItem();
        String localidadOrigen = (String) jComboBox2.getSelectedItem();
        String provinciaDestino = (String) jComboBox3.getSelectedItem();
        String localidadDestino = (String) jComboBox4.getSelectedItem();

        Provincia provinciaOrigenObj = null;
        Provincia provinciaDestinoObj = null;
        Localidad localidadOrigenObj = null;
        Localidad localidadDestinoObj = null;

        for (Provincia provincia : provincias) {
            if (provincia.getNombre().equals(provinciaOrigen)) {
                provinciaOrigenObj = provincia;
            }
            if (provincia.getNombre().equals(provinciaDestino)) {
                provinciaDestinoObj = provincia;
            }
        }

        // Obtener la localidad correspondiente a la provincia seleccionada
        List<Localidad> localidadesOrigen = controladoralocalidad.obtenerLocalidadesPorProvincia(provinciaOrigenObj);
        for (Localidad localidad : localidadesOrigen) {
            if (localidad.getNombre().equals(localidadOrigen)) {
                localidadOrigenObj = localidad;
                break;
            }
        }

        List<Localidad> localidadesDestino = controladoralocalidad.obtenerLocalidadesPorProvincia(provinciaDestinoObj);
        for (Localidad localidad : localidadesDestino) {
            if (localidad.getNombre().equals(localidadDestino)) {
                localidadDestinoObj = localidad;
                break;
            }
        }

        // Obtener la fecha seleccionada del jCalendar1
        Date fechaSeleccionada = jCalendar1.getDate();

        // Verificar que todos los campos obligatorios estén llenos
        if (provinciaOrigenObj == null || localidadOrigenObj == null || provinciaDestinoObj == null || localidadDestinoObj == null || fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de guardar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un nuevo objeto Viaje
        Viaje nuevoViaje = new Viaje();
        nuevoViaje.setOrigen(provinciaOrigenObj);
        nuevoViaje.setDestino(provinciaDestinoObj);
        nuevoViaje.setFecha(fechaSeleccionada);
        nuevoViaje.setLocalidadOrigen(localidadOrigenObj);
        nuevoViaje.setLocalidadDestino(localidadDestinoObj);

        nuevoViaje.setVehiculo(this.vehiculoSeleccionado);

        // Preguntar si desea guardar el viaje
        int opcion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar el viaje?", "Confirmar", JOptionPane.YES_NO_OPTION);

        // Dependiendo de la opción seleccionada
        if (opcion == JOptionPane.YES_OPTION) {
            // Guardar el Viaje en la base de datos
            controladoraViaje.guardarViaje(nuevoViaje);
            idViaje = nuevoViaje.getViajeID();
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Viaje guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            Menu menu = new Menu(rolUsuario);
            menu.setVisible(true);
            this.dispose();
           
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ha ocurrido un error al guardar el viaje.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jCalendar1PropertyChange

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


}
