/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraCliente;
import Controladoras.ControladoraPaquete;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Cliente;
import logisticalogica.Paquete;


/**
 *
 * @author ULTRA
 */
public class BuscarClienteReceptor extends javax.swing.JFrame {
    private ControladoraCliente controladoraCliente;
    private DefaultTableModel tableModel;
    private Paquete paquete; 
    private Paquete paqueteTemporal; // Asegúrate de tener este atributo en tu clase
    private ControladoraPaquete controladoraPaquete;
    private int idClienteEmisorSeleccionado;
    private String clienteEmisorSeleccionado;

    private RegistrarPaquete registrarEnvio;
    private String rolUsuario;
    private Cliente clienteEmisor;

    /**
     * Creates new form BuscarClienteReceptor
     */
    public BuscarClienteReceptor(Paquete paqueteTemporal, String rolUsuario) {

    initComponents();
    this.rolUsuario = rolUsuario;
    setLocationRelativeTo(null);
    setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre el JFrame en pantalla completa
    this.paqueteTemporal = paqueteTemporal;
    mostrarNombreClienteEmisor();
    tableModel = (DefaultTableModel) jTable1.getModel();
    controladoraCliente = new ControladoraCliente();
    cargarClientesEnTabla();
    inicializarVentana();
    registrarEnvio = new RegistrarPaquete(rolUsuario); // Esto es un ejemplo, ajusta según tu implementación
    paquete = new Paquete();
    
    // Crear un renderizador personalizado para los encabezados de las columnas
    DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
    headerRenderer.setHorizontalAlignment(SwingConstants.LEFT); // Alinear a la izquierda horizontalmente
    headerRenderer.setVerticalAlignment(SwingConstants.CENTER); // Centrar verticalmente
    headerRenderer.setFont(new Font("Arial", Font.PLAIN, 18)); // Establecer la fuente a Arial 18
    // Aplicar el renderizador personalizado a los encabezados de las columnas
    jTable1.getTableHeader().setDefaultRenderer(headerRenderer);
  
    // Inicializar campos del paquete
    paquete.setEstado("PENDIENTE");
    paquete.setFechaRecibido(new java.sql.Date(System.currentTimeMillis())); // Utiliza la fecha actual
    paquete.setFechaEntrega(null); // Establecer la fecha de entrega como null inicialmente
    
    // Validación para el campo de número de documento
    ingresardocumento.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    });

    // Validación para el campo de nombre y apellido
    jTextField1.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!(Character.isLetter(c) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    });
}
    private void mostrarInfoPaqueteTemporal(Paquete paqueteTemporal) {
        if (paqueteTemporal != null) {
            System.out.println("Datos de paqueteTemporal:");
            System.out.println("Código de paquete: " + paqueteTemporal.getCodigo_paquete());
            System.out.println("Domicilio de entrega: " + paqueteTemporal.getDomicilioEntrega());
            // Mostrar otros atributos según sea necesario
        } else {
            System.out.println("paqueteTemporal es nulo.");
        }
    }
     public void setPaqueteTemporal(Paquete paqueteTemporal) {
    this.paqueteTemporal = paqueteTemporal;
    if (paqueteTemporal != null) {
        Codpaquete.setText("Cod paquete: " + String.valueOf(paqueteTemporal.getCodigo_paquete()));
    } else {
        Codpaquete.setText("Paquete temporal es nulo");
    }
}


    public void setIdClienteEmisorSeleccionado(int idClienteEmisorSeleccionado) {
        this.idClienteEmisorSeleccionado = idClienteEmisorSeleccionado;
    }
    private void cargarClientesEnTabla() {
    // Limpiar la tabla antes de cargar nuevos datos
    tableModel.setRowCount(0);

    // Obtener la lista de clientes activos
    List<Cliente> clientesActivos = controladoraCliente.filtrarClientesPorEstado("Activo");

    // Iterar sobre la lista de clientes activos y agregarlos a la tabla
    for (Cliente cliente : clientesActivos) {
        String nombreCompleto = cliente.getNombre() + " " + cliente.getApellido();

        Object[] rowData = {
            nombreCompleto,
            cliente.getNro_documento(),
            cliente.getNro_telefono(),
            cliente.getCorreoElectronico(),
            cliente.getEstado()
        };
        tableModel.addRow(rowData);
    }
}

    private void inicializarVentana() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow >= 0) {
                        // Habilitar el botón "Aceptar" cuando se selecciona una fila en la tabla
                        botonAceptar.setEnabled(true);
                    } else {
                        // Deshabilitar el botón "Aceptar" si no hay fila seleccionada
                        botonAceptar.setEnabled(false);
                    }
                }
            }
        });
        ingresardocumento.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            filtrarClientes();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            filtrarClientes();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            filtrarClientes();
        }
    });
    jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarClientespornombreyape();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarClientespornombreyape();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarClientespornombreyape();
            }
        });
    
    }

    private Cliente obtenerClienteDesdeFilaSeleccionada(int filaSeleccionada) {
        List<Cliente> clientes = controladoraCliente.obtenerTodosLosClientes();
        if (filaSeleccionada >= 0 && filaSeleccionada < clientes.size()) {
            return clientes.get(filaSeleccionada);
        } else {
            return null;
        }
    }
      private void filtrarClientes() {
    String numeroDocumentoStr = ingresardocumento.getText().trim();

    if (numeroDocumentoStr.isEmpty()) {
        cargarClientesEnTabla(); 
    } else {
        try {
            int numeroDocumento = Integer.parseInt(numeroDocumentoStr);

            // Realizar la búsqueda de clientes según los valores ingresados
            List<Cliente> clientes = controladoraCliente.filtrarClientesPorNumeroDocumento(numeroDocumento);

            // Limpiar la tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            for (Cliente cliente : clientes) {
                String nombreCompleto = cliente.getNombre() + " " + cliente.getApellido();

                Object[] rowData = {
                    nombreCompleto,
                    cliente.getNro_documento(),
                    cliente.getNro_telefono()
                };
                tableModel.addRow(rowData);
            }
        } catch (NumberFormatException e) {
            // Manejo de error si el texto no es un número válido
            // Crear un JPanel para contener el mensaje
            JPanel panelMensaje = new JPanel();
            panelMensaje.setLayout(new FlowLayout()); // Ajustar el layout si es necesario

            // Crear un JLabel para el mensaje, estableciendo el mensaje, la fuente y el tamaño
            JLabel numerovalido = new JLabel("Ingrese un número válido para el documento.");
            numerovalido.setFont(new Font("Arial", Font.PLAIN, 18)); // Configurar la fuente Arial y tamaño 18

            // Añadir la etiqueta al panel
            panelMensaje.add(numerovalido);

            // Mostrar el JOptionPane con el panel personalizado como contenido
            JOptionPane.showMessageDialog(null, panelMensaje);
        }
    }
}

        
       private void filtrarClientespornombreyape() {
    String nombre = jTextField1.getText().trim(); // Obtener el nombre desde el campo correspondiente
    String apellido = ingresardocumento.getText().trim(); // Obtener el apellido desde el campo de número de documento

    if (nombre.isEmpty() && apellido.isEmpty()) {
        cargarClientesEnTabla(); 
    } else {
        // Realizar la búsqueda de clientes según los valores ingresados
        List<Cliente> clientes = controladoraCliente.filtrarNombreyApellido(nombre + " " + apellido);

        // Limpiar la tabla antes de cargar nuevos datos
        tableModel.setRowCount(0);

        for (Cliente cliente : clientes) {
            String nombreCompleto = cliente.getNombre() + " " + cliente.getApellido();

            Object[] rowData = {
                nombreCompleto,
                cliente.getNro_documento(),
                cliente.getNro_telefono()
            };
            tableModel.addRow(rowData);
        }
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
         
   
public void seleccionarClienteReceptor() {
    if (paqueteTemporal != null) {
        // Obtén la fila seleccionada en la tabla
        int filaSeleccionada = jTable1.getSelectedRow();

        // Asegúrate de que haya una fila seleccionada
        if (filaSeleccionada >= 0) {
            // Obtén el cliente desde la fila seleccionada
            Cliente clienteSeleccionado = obtenerClienteDesdeFilaSeleccionada(filaSeleccionada);

            // Verifica si el cliente seleccionado está activo
            if (clienteSeleccionado != null && clienteSeleccionado.getEstado().equals("Activo")) {
                // El cliente está activo, procede con la selección               
                // Mostrar confirmación antes de establecer el cliente receptor
                
                // Crear un JLabel para personalizar la fuente
                JLabel message = new JLabel("<html>¿Deseas seleccionar al siguiente cliente como receptor?<br><br>" +
                        "Nombre: " + clienteSeleccionado.getNombre() + "<br>" +
                        "Apellido: " + clienteSeleccionado.getApellido() + "</html>");

                // Establecer la fuente del JLabel
                message.setFont(new Font("Arial", Font.PLAIN, 18));

                // Crear un array de objetos para personalizar los botones del JOptionPane
                Object[] options = {"Si", "No"};

                // Mostrar un cuadro de confirmación antes de seleccionar al cliente receptor
                int confirmacion = JOptionPane.showOptionDialog(this,
                        message,
                        "Confirmar selección", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
                if (confirmacion == JOptionPane.YES_OPTION) {
                    // El usuario confirmó la selección, establecer el cliente receptor en el paqueteTemporal
                    paqueteTemporal.setReceptor(clienteSeleccionado);

                    // Añade mensajes de depuración
                    System.out.println("PaqueteTemporal en BuscarClienteReceptor:");
                    mostrarInfoPaqueteTemporal(paqueteTemporal);

                    // Actualizar estado y fecha de recibido
                    paqueteTemporal.setEstado("PENDIENTE");
                    paqueteTemporal.setFechaRecibido(new java.sql.Date(System.currentTimeMillis()));

                    // Llamar al método para persistir el paquete en la base de datos
                    persistirPaqueteEnBD();
                    
                // Crear un JLabel para personalizar la fuente
                JLabel message2 = new JLabel("<html>¿Quieres seguir registrando paquetes?</html>");

                // Establecer la fuente del JLabel
                message2.setFont(new Font("Arial", Font.PLAIN, 18));
     
                int opcion = JOptionPane.showOptionDialog(this,
                        message2,
                        "Confirmar",JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,
                        
                new Object[]{"Si", "No"},
                "Si");

                // Verificar la opción seleccionada
                if (opcion == JOptionPane.YES_OPTION) {
                // Si el usuario elige "Sí", cerrar la ventana actual
                dispose();

        // Abrir la pantalla para registrar un nuevo envío
        registrarEnvio.mostrarVentana();
    } else {
        // Si el usuario elige "No", salir del programa
        Menu menu = new Menu(rolUsuario);
        menu.setVisible(true);
        this.dispose();
    }
                } else {
                    // El usuario optó por no confirmar la selección
                    System.out.println("Selección del cliente cancelada.");
                    return; // Puedes agregar más lógica aquí según tus necesidades
                }
            } else {
                // El cliente no está activo, muestra un mensaje de error
                // Crear un JLabel para personalizar el mensaje
                JLabel clientenoactivo = new JLabel("El cliente seleccionado no está activo.");
                // Establecer la fuente del JLabel
                clientenoactivo.setFont(new Font("Arial", Font.PLAIN, 18));
                // Mostrar el cuadro de diálogo de error con el JLabel personalizado y el título personalizado
                JOptionPane.showMessageDialog(this, clientenoactivo, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // No se ha seleccionado ninguna fila en la tabla, mostrar mensaje de error
            // Crear un JPanel para contener el mensaje
            JPanel panelMensaje = new JPanel();
            panelMensaje.setLayout(new FlowLayout()); // Ajustar el layout si es necesario

            // Crear un JLabel para el mensaje, estableciendo el mensaje, la fuente y el tamaño
            JLabel seleccliente = new JLabel("Por favor, selecciona un cliente.");
            seleccliente.setFont(new Font("Arial", Font.PLAIN, 18)); // Configurar la fuente Arial y tamaño 18

            // Añadir la etiqueta al panel
            panelMensaje.add(seleccliente);

            // Mostrar el JOptionPane con el panel personalizado como contenido
            JOptionPane.showMessageDialog(this, panelMensaje, "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        System.out.println("El paquete es nulo. Verifica su inicialización.");
    }
}

private void persistirPaqueteEnBD() {
    if (paqueteTemporal != null) {
        System.out.println("Código de paquete: " + paqueteTemporal.getCodigo_paquete());

        // Resto del código para persistir el paquete en la base de datos
        try {
            // Actualizar estado y fecha de recibido antes de persistir
            paqueteTemporal.setEstado("PENDIENTE");
            paqueteTemporal.setFechaRecibido(new java.sql.Date(System.currentTimeMillis()));

            // Ejemplo: Guardar el paquete en la base de datos utilizando la controladora del paquete
            ControladoraPaquete controladoraPaquete = new ControladoraPaquete();
            controladoraPaquete.guardarPaquete(paqueteTemporal);

            System.out.println("Paquete persistido en la base de datos correctamente.");
        } catch (Exception e) {
            // Manejo de excepciones en caso de error al persistir el paquete
            System.out.println("Error al persistir el paquete en la base de datos: " + e.getMessage());
            e.printStackTrace();
            // Puedes agregar más acciones según tus necesidades, como mostrar un mensaje de error al usuario.
        }

    } else {
        System.out.println("paqueteTemporal es nulo.");
        // Manejo de la situación cuando paqueteTemporal es nulo
        // Puedes agregar mensajes de error, lanzar excepciones u otras acciones según tus necesidades
    }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        numerodocclienteemisor = new javax.swing.JLabel();
        ingresardocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Codpaquete = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre y Apellido", "N° Documento", "N° Telefono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        numerodocclienteemisor.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        numerodocclienteemisor.setText("N° Documento:");

        ingresardocumento.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        ingresardocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresardocumentoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Nombre y Apellido:");

        jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        Codpaquete.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Codpaquete.setText("Codigo del paquete:");

        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setText("Registrar cliente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        botonAceptar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registrar Paquete - Seleccionar cliente receptor");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Cliente Emisor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(numerodocclienteemisor)
                                .addGap(18, 18, 18)
                                .addComponent(ingresardocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Codpaquete))))
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAceptar)
                        .addGap(100, 100, 100)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresardocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numerodocclienteemisor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Codpaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void ingresardocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresardocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresardocumentoActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
      seleccionarClienteReceptor();      

    }//GEN-LAST:event_botonAceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarClientes buscarclientes = new BuscarClientes(paqueteTemporal, rolUsuario);
    buscarclientes.setPaqueteTemporal(paqueteTemporal); // Restaura el paqueteTemporal en la nueva ventana
    buscarclientes.mostrarVentana(); // Muestra la ventana RegistrarPaquete
    this.dispose(); // Cierra la ventana actual (BuscarClientes)
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    RegistrarClienteRecep registrarclienterecep = new RegistrarClienteRecep(paqueteTemporal, rolUsuario);
        registrarclienterecep.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    // ... (otros métodos de la clase)  

private void mostrarNombreClienteEmisor() {
    if (clienteEmisor != null) {
        jLabel1.setText("ID del Cliente Emisor: " + clienteEmisor.getNombre()); 
    } else {
        jLabel1.setText("ID del Cliente Emisor: Cliente no encontrado"); 
    }
}
public void actualizarIDClienteEmisor(int idClienteEmisor) {
    jLabel1.setText("ID del Cliente Emisor: " + idClienteEmisor);
}

public void actualizarNombreApellidoClienteEmisor(String nombreApellidoClienteEmisor) {
    jLabel1.setText("Cliente Emisor: " + nombreApellidoClienteEmisor);
}
private void asignarClientesAlPaquete(Cliente clienteEmisor, Cliente clienteReceptor) {
    paquete.setEmisor(clienteEmisor);
    paquete.setReceptor(clienteReceptor);
}
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Codpaquete;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JTextField ingresardocumento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel numerodocclienteemisor;
    // End of variables declaration//GEN-END:variables
}
