/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraLocalidad;
import Controladoras.ControladoraProvincia;
import Controladoras.ControladoraViaje;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre el JFrame en pantalla completa
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
        jLabel1.setText("Registrar viaje - Seleccionar origen, destino y fecha");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Provincia de origen:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Provincia de destino:");

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

        jCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Localidad de origen:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setText("Localidad de destino:");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jComboBox3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jComboBox4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(207, 207, 207)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(100, 100, 100)
                                        .addComponent(jButton1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(776, 776, 776)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)))
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
            // Crear un JLabel para personalizar el mensaje
            JLabel completarcampos = new JLabel("Por favor, complete todos los campos antes de guardar.");
            // Establecer la fuente del JLabel
            completarcampos.setFont(new Font("Arial", Font.PLAIN, 18));

            // Mostrar el cuadro de diálogo de error con el JLabel personalizado
            JOptionPane.showMessageDialog(this, completarcampos, "Error", JOptionPane.ERROR_MESSAGE);
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

        // Crear un JLabel para personalizar el mensaje
        JLabel guardarviaje = new JLabel("¿Seguro que desea guardar el viaje?");
        // Establecer la fuente del JLabel
        guardarviaje.setFont(new Font("Arial", Font.PLAIN, 18));

        // Crear un array de objetos para personalizar los botones del JOptionPane
        Object[] options = {"Si", "No"};

        // Mostrar el cuadro de diálogo de confirmación con el JLabel personalizado y las opciones de botones modificadas
        int opcion = JOptionPane.showOptionDialog(this, guardarviaje, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        // Dependiendo de la opción seleccionada
        if (opcion == JOptionPane.YES_OPTION) {
            // Guardar el Viaje en la base de datos
            controladoraViaje.guardarViaje(nuevoViaje);
            idViaje = nuevoViaje.getViajeID();
            
            // Mostrar mensaje de éxito
            // Crear un JLabel para personalizar el mensaje
            JLabel viajeguardado = new JLabel("Viaje guardado exitosamente.");
            // Establecer la fuente del JLabel
            viajeguardado.setFont(new Font("Arial", Font.PLAIN, 18));

            // Mostrar el cuadro de diálogo de información con el JLabel personalizado
            JOptionPane.showMessageDialog(this, viajeguardado, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            Menu menu = new Menu(rolUsuario);
            menu.setVisible(true);
            this.dispose();
           
        }
    } catch (Exception e) {
         // Crear un JLabel para personalizar el mensaje
         JLabel errorocurrido = new JLabel("Ha ocurrido un error al guardar el viaje.");
         // Establecer la fuente del JLabel
         errorocurrido.setFont(new Font("Arial", Font.PLAIN, 18));

         // Mostrar el cuadro de diálogo de error con el JLabel personalizado
         JOptionPane.showMessageDialog(this, errorocurrido, "Error", JOptionPane.ERROR_MESSAGE);
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
