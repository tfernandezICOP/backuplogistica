/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraMarca;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Marca;

/**
 *
 * @author ULTRA
 */
public class MarcaIGU extends javax.swing.JFrame {
        private final ControladoraMarca controladoraMarca;
    private Marca marcaSeleccionada;
    private ViajeIGU viajeIGU;  // Declare viajeIGU variable
    private Object ventanaQueLlama; // Agregar atributo para guardar la ventana que llama a MarcaIGU

    private VehiculosTotales vehiculosTotales; 
    /**
     * Creates new form RegistrarMarca
     */
   public MarcaIGU(Object ventanaQueLlama) { // Modificar constructor para aceptar la ventana que lo llama
        initComponents();
        controladoraMarca = new ControladoraMarca();
        llenarTabla();
        this.ventanaQueLlama = ventanaQueLlama; // Guardar la ventana que llama a MarcaIGU

    

    jTextField1.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) {
            filtrarPorModelo();
        }

        public void removeUpdate(DocumentEvent e) {
            filtrarPorModelo();
        }

        public void changedUpdate(DocumentEvent e) {
            filtrarPorModelo();
        }
    });

    jTextField2.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) {
            filtrarPorTipo();
        }

        public void removeUpdate(DocumentEvent e) {
            filtrarPorTipo();
        }

        public void changedUpdate(DocumentEvent e) {
            filtrarPorTipo();
        }
    });
}
   
private void filtrarPorModelo() {
    String modelo = jTextField1.getText();

    // Si el campo de modelo está vacío, muestra todas las marcas
    if (modelo.isEmpty()) {
        llenarTabla();
    } else {
        List<Marca> marcasFiltradas = controladoraMarca.filtrarMarcasPorModelo(modelo);
        actualizarTabla(marcasFiltradas);
    }
}

private void filtrarPorTipo() {
    String tipo = jTextField2.getText();

    // Si el campo de tipo está vacío, muestra todas las marcas
    if (tipo.isEmpty()) {
        llenarTabla();
    } else {
        List<Marca> marcasFiltradas = controladoraMarca.filtrarMarcasPorTipo(tipo);
        actualizarTabla(marcasFiltradas);
    }
}

private void actualizarTabla(List<Marca> marcas) {
    DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{"Modelo", "Tipo"}, 0);

    for (Marca marca : marcas) {
        Object[] fila = {marca.getModelo(), marca.getTipo()};
        modeloTabla.addRow(fila);
    }

    jTable1.setModel(modeloTabla);
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Marca");

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Registrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Modelo:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(17, 17, 17))
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

        abrirVentanaRegistrarMarca();
        }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        marcaSeleccionada = obtenerMarcaSeleccionada();
        abrirVentanaRegistrarVehiculo(marcaSeleccionada);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Verificar el tipo de ventana que llama a MarcaIGU
    if (ventanaQueLlama instanceof ViajeIGU) {
        // Si la ventana que llama es ViajeIGU, abre una instancia de ViajeIGU
        ViajeIGU viajeIGU = (ViajeIGU) ventanaQueLlama;
        viajeIGU.setVisible(true);
    } else if (ventanaQueLlama instanceof VehiculosTotales) {
        // Si la ventana que llama es VehiculosTotales, abre una instancia de VehiculosTotales
        VehiculosTotales vehiculosTotales = (VehiculosTotales) ventanaQueLlama;
        vehiculosTotales.setVisible(true);
    }
    // Cierra la ventana actual
    dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public void mostrarMarcaIGU() {
        this.setVisible(true);
        llenarTabla();  // Actualiza la tabla al mostrar la ventana
    }
       private void llenarTabla() {
        List<Marca> listaMarcas = controladoraMarca.obtenerTodasLasMarcas();
        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{"Modelo", "Tipo"}, 0);

        for (Marca marca : listaMarcas) {
            Object[] fila = {marca.getModelo(), marca.getTipo()};
            modeloTabla.addRow(fila);
        }

        jTable1.setModel(modeloTabla);
    }

        
      private void abrirVentanaRegistrarMarca() {
    RegistrarMarca ventanaRegistrarMarca = new RegistrarMarca(this);
    ventanaRegistrarMarca.setVisible(true);
    this.dispose();  // Cierra la ventana actual si es necesario
}
        
       
  public Marca obtenerMarcaSeleccionada() {
        // Lógica para obtener la marca seleccionada en la tabla
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            String modelo = jTable1.getValueAt(filaSeleccionada, 0).toString();
            String tipo = jTable1.getValueAt(filaSeleccionada, 1).toString();
            return controladoraMarca.obtenerMarcaPorModeloYTipo(modelo, tipo);
        } else {
            return null;
        }
    }      
  
  private void abrirVentanaRegistrarVehiculo(Marca marcaSeleccionada) {
    // Crea una instancia de la ventana RegistrarVehiculo
    RegistrarVehiculo ventanaRegistrarVehiculo;

    // Verifica si la ventana que llama es MarcaIGU y pasa su referencia a la ventana RegistrarVehiculo
    if (ventanaQueLlama instanceof MarcaIGU) {
    ventanaRegistrarVehiculo = new RegistrarVehiculo(marcaSeleccionada, ventanaQueLlama);
} else {
    ventanaRegistrarVehiculo = new RegistrarVehiculo(marcaSeleccionada, ventanaQueLlama);
}


    // Hace visible la ventana RegistrarVehiculo
    ventanaRegistrarVehiculo.setVisible(true);

    // Cierra la ventana actual si es necesario
    this.dispose();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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