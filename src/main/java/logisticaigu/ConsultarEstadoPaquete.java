/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraPaquete;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Configuracion;
import logisticalogica.Paquete;

/**
 *
 * @author ULTRA
 */
public class ConsultarEstadoPaquete extends javax.swing.JFrame {
    ControladoraPaquete controladoraPaquete = new ControladoraPaquete();
    private List<Paquete> paquetes;
    private Paquete paqueteSeleccionado; // Declaración de paqueteSeleccionado como variable de instancia
  private String rolUsuario;



    /**
     * Creates new form ConsultarEstadoPaquete
     */
    public ConsultarEstadoPaquete(String rolUsuario) {
        initComponents();
        this.rolUsuario = rolUsuario;
        mostrarTodosLosPaquetes();
        inicializarVentana();
        
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
        tablafiltrar.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Verificar si hay una fila seleccionada en la tabla
                if (!e.getValueIsAdjusting() && tablafiltrar.getSelectedRow() != -1) {
                    jButton2.setEnabled(true); // Habilitar el botón "Aceptar"
                } else {
                    jButton2.setEnabled(false); // Deshabilitar el botón "Aceptar"
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablafiltrar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estado del paquete");

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

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tablafiltrar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tablafiltrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo del paquete", "Descripcion", "Receptor", "Domicilio de entrega"
            }
        ));
        jScrollPane1.setViewportView(tablafiltrar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(100, 100, 100)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1888, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      int filaSeleccionada = tablafiltrar.getSelectedRow();

    if (filaSeleccionada != -1) {
        paqueteSeleccionado = paquetes.get(filaSeleccionada);

        // Aquí debes mostrar un JOptionPane con el estado del paquete
        mostrarEstadoPaquete();

    } else {
        // No se ha seleccionado ningún paquete
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Por favor, seleccione un paquete antes de continuar.",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    
    }//GEN-LAST:event_jButton2ActionPerformed
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu atras = new Menu(Configuracion.getRolUsuario());
        atras.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   private void mostrarPaquetesentabla(List<Paquete> paquetes) {
        DefaultTableModel modelo = (DefaultTableModel) tablafiltrar.getModel();
        modelo.setRowCount(0); // Elimina todas las filas existentes en la tabla

        for (Paquete paquete : paquetes) {
            modelo.addRow(new Object[]{
                paquete.getCodigo_paquete(),
                paquete.getDescripcion(),
                paquete.getReceptor().getNombre(),
                paquete.getDomicilioEntrega()
                
            });
        }
    }
    
   private void inicializarVentana() {
        tablafiltrar.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tablafiltrar.getSelectedRow();
            if (selectedRow >= 0) {
                paqueteSeleccionado = paquetes.get(selectedRow);
                // Realizar cualquier acción adicional que desees con el paquete seleccionado
                // por ejemplo: mostrar sus detalles en otra parte de la interfaz gráfica
            }
        });
    }
   
  private void mostrarPaquetesEnTabla(List<Paquete> paquetes) {
    DefaultTableModel modelo = (DefaultTableModel) tablafiltrar.getModel();
    modelo.setRowCount(0); // Elimina todas las filas existentes en la tabla

    for (Paquete paquete : paquetes) {
        String nombreReceptor = (paquete.getReceptor() != null) ? paquete.getReceptor().getNombre() : "Sin receptor";
        modelo.addRow(new Object[]{
            paquete.getCodigo_paquete(),
            paquete.getDescripcion(),
            nombreReceptor,
            paquete.getDomicilioEntrega()
            // Agrega más columnas según la información que desees mostrar
        });
    }
}

   private void mostrarTodosLosPaquetes() {
        paquetes = controladoraPaquete.obtenerTodosLosPaquetes();
        mostrarPaquetesEnTabla(paquetes);
    }
   
   private void filtrarPaquetes() {
    String codigoPaqueteTexto = jTextField1.getText();

    if (!codigoPaqueteTexto.isEmpty()) {
        List<Paquete> paquetesFiltrados = new ArrayList<>();
        int codigoPaquete;
        try {
            codigoPaquete = Integer.parseInt(codigoPaqueteTexto);
            for (Paquete paquete : paquetes) {
                if (String.valueOf(paquete.getCodigo_paquete()).contains(codigoPaqueteTexto)) {
                    paquetesFiltrados.add(paquete);
                }
            }
            mostrarPaquetesEnTabla(paquetesFiltrados);
        } catch (NumberFormatException ex) {
            System.out.println("Ingrese un número válido para el código de paquete.");
        }
    } else {
        // Si el campo está vacío, muestra todos los paquetes
        mostrarTodosLosPaquetes();
    }
   }
   private void mostrarEstadoPaquete() {
    // Muestra un JOptionPane con el estado del paquete
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Estado del paquete: " + paqueteSeleccionado.getEstado(),
            "Estado del Paquete",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablafiltrar;
    // End of variables declaration//GEN-END:variables
}
