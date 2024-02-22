/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraMarca;
import Controladoras.ControladoraVehiculo;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;
import logisticalogica.Marca;
import logisticalogica.Vehiculo;

/**
 *
 * @author ULTRA
 */
public class RegistrarMarcaVehiculo extends javax.swing.JFrame {
private ControladoraMarca controladoramarca;
private ControladoraVehiculo controladoravehiculo;
    private Set<Integer> numerosDisponibles;
    private List<Marca> marcas; 
private Object ventanaQueLlama; 
    private String rolUsuario;

    /**
     * Creates new form RegistrarMarcaVehiculo
     */
    public RegistrarMarcaVehiculo(Object ventanaQueLlama, String rolUsuario) {
        initComponents();
        inicializarNumerosDisponibles();
        controladoravehiculo = new ControladoraVehiculo();
        this.rolUsuario = rolUsuario;
        this.ventanaQueLlama = ventanaQueLlama;
                
        controladoramarca = new ControladoraMarca(); 
        llenarComboBox(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Marca:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tipo:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("Registrar Marca");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Capacidad de carga (Kg):");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Patente:");

        jTextField2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Registrar Tipo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(219, 219, 219)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(211, 211, 211)
                                        .addComponent(jLabel2)))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(100, 100, 100)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void llenarComboBox() {
    this.marcas = controladoramarca.obtenerTodasLasMarcas(); // Obtener todas las marcas

    // Crear un conjunto para almacenar modelos únicos en el orden de la base de datos
    LinkedHashSet<String> modelosOrdenados = new LinkedHashSet<>();
    
    // Recorrer la lista de marcas y agregar los modelos al conjunto en el orden en que se registraron
    for (Marca marca : marcas) {
        modelosOrdenados.add(marca.getModelo());
    }

    // Limpiar el ComboBox de modelos
    jComboBox2.removeAllItems(); 

    // Agregar los modelos al ComboBox en el orden obtenido de la base de datos
    for (String modelo : modelosOrdenados) {
        jComboBox2.addItem(modelo);
    }

    // Seleccionar el último modelo si hay modelos disponibles
    if (!modelosOrdenados.isEmpty()) {
        jComboBox2.setSelectedIndex(modelosOrdenados.size() - 1);
    }
}


    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
            actualizarComboBox1();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  String modelo = ingresarModelo();

    if (modelo != null && !modelo.isEmpty()) {
        if (controladoramarca.marcaExiste(modelo)) {
            JOptionPane.showMessageDialog(this, "El modelo ingresado ya tiene marcas registradas.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        Marca nuevaMarca = new Marca();
        nuevaMarca.setModelo(modelo);
        
        String[] tiposAutomaticos = {"Automovil", "Camion", "Camioneta", "SUV"};
        for (String tipo : tiposAutomaticos) {
            Marca marcaExistente = controladoramarca.obtenerMarcaPorModeloYTipo(modelo, tipo);
            if (marcaExistente == null) {
                Marca nuevaMarcaTipo = new Marca();
                nuevaMarcaTipo.setModelo(modelo);
                nuevaMarcaTipo.setTipo(tipo);
                controladoramarca.guardarMarca(nuevaMarcaTipo);
                
                jComboBox1.addItem(tipo);
            }
        }
        
        JOptionPane.showMessageDialog(this, "Marca registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        jComboBox2.addItem(modelo);
        jComboBox2.setSelectedItem(modelo);
        
        llenarComboBox();
    } else {
        JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de modelo válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
       }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String marcaSeleccionadaNombre = (String) jComboBox2.getSelectedItem();
    String capacidadCargaStr = jTextField1.getText();
    String patente = jTextField2.getText();

    if (!capacidadCargaStr.isEmpty() && !patente.isEmpty()) {
        // Verificar si ya existe un vehículo con la misma patente
        if (controladoravehiculo.existeVehiculoConPatente(patente)) {
            JOptionPane.showMessageDialog(this, "Ya existe un vehículo registrado con la misma patente.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método sin guardar el vehículo
        }

        try {
            int capacidadCarga = Integer.parseInt(capacidadCargaStr);

            Vehiculo nuevoVehiculo = new Vehiculo();
            nuevoVehiculo.setCapacidad_carga(capacidadCarga);
            nuevoVehiculo.setPatente(patente);
            int nrovehiculo = obtenerNumeroVehiculo();
            nuevoVehiculo.setNro_vehiculo(nrovehiculo);
            String nombreMarcaSeleccionada = (String) jComboBox2.getSelectedItem();

            // Buscar la instancia de Marca que coincide con el nombre seleccionado
            Marca marcaSeleccionada = null;
            for (Marca marca : marcas) {
                if (marca.getModelo().equals(nombreMarcaSeleccionada)) {
                    marcaSeleccionada = marca;
                    break;
                }
            }

            // Verificar si se encontró la marca seleccionada
            if (marcaSeleccionada != null) {
                // Asignar la marca seleccionada al vehículo
                nuevoVehiculo.setMarca(marcaSeleccionada);

                // Resto del código para actualizar la interfaz o volver a la ventana anterior

                // Guardar el vehículo en la base de datos
                controladoravehiculo.guardarvehiculo(nuevoVehiculo);
                System.out.println("Vehículo guardado exitosamente. ID: " + nuevoVehiculo.getVehiculoID()); // Mensaje de depuración

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Vehículo guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Verificar el tipo de ventana que llama a MarcaIGU
                if (ventanaQueLlama instanceof ViajeIGU) {
                    ViajeIGU viajeIGU = (ViajeIGU) ventanaQueLlama;
                    viajeIGU.mostrarVentana();

                } else if (ventanaQueLlama instanceof VehiculosTotales) {
                    VehiculosTotales vehiculosTotales = (VehiculosTotales) ventanaQueLlama;
                     vehiculosTotales.mostrarVentana();

                }
                // Cierra la ventana actual
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la marca seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La capacidad de carga debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (ventanaQueLlama instanceof ViajeIGU) {
        ViajeIGU viajeIGU = (ViajeIGU) ventanaQueLlama;
        viajeIGU.setVisible(true);
    } else if (ventanaQueLlama instanceof VehiculosTotales) {


        VehiculosTotales vehiculosTotales = (VehiculosTotales) ventanaQueLlama;
        vehiculosTotales.setVisible(true);
    }
    // Cierra la ventana actual
    dispose();        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         String nuevoTipo = seleccionarTipo();
    
    if (nuevoTipo != null) {
        String modeloSeleccionado = (String) jComboBox2.getSelectedItem();
        
        boolean tipoExistente = false;
        for (Marca marca : marcas) {
            if (marca.getModelo().equals(modeloSeleccionado) && marca.getTipo().equals(nuevoTipo)) {
                tipoExistente = true;
                break;
            }
        }
        
        if (!tipoExistente) {
            Marca nuevaMarca = new Marca();
            nuevaMarca.setModelo(modeloSeleccionado);
            nuevaMarca.setTipo(nuevoTipo);
            
            controladoramarca.guardarMarca(nuevaMarca);
            
            jComboBox1.addItem(nuevoTipo);
            JOptionPane.showMessageDialog(this, "Tipo registrado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "El tipo ingresado ya existe para el modelo seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

   


private String ingresarModelo() {
    return JOptionPane.showInputDialog(this, "Ingrese el modelo:", "Registrar Modelo", JOptionPane.QUESTION_MESSAGE);
}


private void actualizarTipos() {
    String modeloSeleccionado = (String) jComboBox2.getSelectedItem();
    
    // Limpiar los elementos del jComboBox1
    jComboBox1.removeAllItems();
    
    // Buscar la marca correspondiente al modelo seleccionado
    Marca marcaSeleccionada = null;
    for (Marca marca : marcas) {
        if (marca.getModelo().equals(modeloSeleccionado)) {
            marcaSeleccionada = marca;
            break;
        }
    }
    
    
    // Si se encuentra la marca seleccionada, agregar los tipos de carrocerías al jComboBox1
    if (marcaSeleccionada != null) {
        // Obtener el conjunto de tipos de la marca seleccionada
        Set<String> tiposCarroceria = new HashSet<>();
        for (Marca marca : marcas) {
            if (marca.getModelo().equals(modeloSeleccionado)) {
                tiposCarroceria.add(marca.getTipo());
            }
        }
        
        // Agregar los tipos de carrocería al jComboBox1
        for (String tipo : tiposCarroceria) {
            jComboBox1.addItem(tipo);
        }
    }
}


  private String seleccionarTipo() {
    String[] tipos = {"Camion", "Camioneta", "SUV", "Automovil"};
    return (String) JOptionPane.showInputDialog(this, "Seleccione el tipo:", "Registrar Tipo", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
}
private void inicializarNumerosDisponibles() {
        numerosDisponibles = new HashSet<>();
        for (int i = 1; i <= 1000; i++) {
            numerosDisponibles.add(i);
        }
    }

    private int obtenerNumeroVehiculo() {
        if (numerosDisponibles.isEmpty()) {
            // Puedes tomar medidas adicionales, como reiniciar los números disponibles
            inicializarNumerosDisponibles();
        }

        Random random = new Random();
        int numero = random.nextInt(1000) + 1;

        while (!numerosDisponibles.contains(numero)) {
            // Si el número ya está en uso, genera otro
            numero = random.nextInt(1000) + 1;
        }

        numerosDisponibles.remove(numero);
        return numero;
    }
    private void actualizarComboBox1() {
    String modeloSeleccionado = (String) jComboBox2.getSelectedItem();

    // Limpiar los elementos del jComboBox1
    jComboBox1.removeAllItems();

    // Buscar la marca correspondiente al modelo seleccionado
    Marca marcaSeleccionada = null;
    for (Marca marca : marcas) {
        if (marca.getModelo().equals(modeloSeleccionado)) {
            marcaSeleccionada = marca;
            break;
        }
    }

    // Si se encuentra la marca seleccionada, agregar los tipos de carrocerías al jComboBox1
    if (marcaSeleccionada != null) {
        // Obtener el conjunto de tipos de la marca seleccionada
        Set<String> tiposCarroceria = new HashSet<>();
        for (Marca marca : marcas) {
            if (marca.getModelo().equals(modeloSeleccionado)) {
                tiposCarroceria.add(marca.getTipo());
            }
        }

        // Agregar los tipos de carrocería al jComboBox1
        for (String tipo : tiposCarroceria) {
            jComboBox1.addItem(tipo);
        }
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
