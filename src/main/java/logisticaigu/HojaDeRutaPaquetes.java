/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package logisticaigu;

import Controladoras.ControladoraPaquete;
import com.itextpdf.text.BaseColor;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import logisticalogica.Paquete;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;



/**
 *
 * @author ULTRA
 */
public class HojaDeRutaPaquetes extends javax.swing.JFrame {

    /**
     * Creates new form HojaDeRutaPaquetes
     */
    private int viajeID;
    private ControladoraPaquete ctrlPaquete;
    private String rolUsuario;
    private String modeloVehiculo;
    private String patenteVehiculo;
    public HojaDeRutaPaquetes(int viajeID,String modeloVehiculo, String patenteVehiculo, String rolUsuario) {
        initComponents();
        this.viajeID = viajeID;
        this.rolUsuario = rolUsuario;
        this.modeloVehiculo = modeloVehiculo;
        this.patenteVehiculo = patenteVehiculo;
        this.ctrlPaquete = new ControladoraPaquete();
        cargarPaquetesPlanificados();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre el JFrame en pantalla completa

        // Crear un renderizador personalizado para los encabezados de las columnas
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT); // Alinear a la izquierda horizontalmente
        headerRenderer.setVerticalAlignment(SwingConstants.CENTER); // Centrar verticalmente
        headerRenderer.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18)); // Establecer la fuente a Arial 18
        // Aplicar el renderizador personalizado a los encabezados de las columnas
        jTable1.getTableHeader().setDefaultRenderer(headerRenderer);
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° Paquete", "Origen", "Domicilio Origen", "Destino", "Domicilio Destino", "Emisor", "Receptor", "Descripcion"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Descargar PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hoja de ruta - Paquetes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
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
        HojaDeRuta atras = new HojaDeRuta(rolUsuario);
        atras.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Document documento = new Document(PageSize.A4.rotate());
    try {
        String ruta = System.getProperty("user.home") + "/Desktop/HojaDeRuta.pdf";
        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        documento.open();
        Image logo = Image.getInstance("C:\\Users\\ULTRA\\Downloads\\c84c0eb8add148d089791e382f332189.png"); // Reemplaza con la ruta real de tu logo
        logo.scaleToFit(200, 100); // Ajusta el tamaño del logo
        logo.setAlignment(Element.ALIGN_LEFT); // Alinea el logo a la izquierda
        documento.add(logo);
         Paragraph vehiculoInfo = new Paragraph("Vehículo: " + modeloVehiculo + "\nPatente: " + patenteVehiculo);
        vehiculoInfo.setAlignment(Element.ALIGN_LEFT); 
        documento.add(vehiculoInfo);
        // Título del documento
        Font fontTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
        Paragraph titulo = new Paragraph("Encomiendas Patria - Hoja de Ruta", fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);
        
        // Separador
        documento.add(new Paragraph("\n"));
        
        // Tabla para los datos del origen
        PdfPTable tablaOrigen = new PdfPTable(4);
        tablaOrigen.setWidthPercentage(100);
        tablaOrigen.setSpacingBefore(10f);
        tablaOrigen.setSpacingAfter(10f);
        
        // Título de la tabla de origen
        Font fontTituloOrigen = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        PdfPCell celdaTituloOrigen = new PdfPCell(new Phrase("Origen del Paquete", fontTituloOrigen));
        celdaTituloOrigen.setColspan(4);
        celdaTituloOrigen.setHorizontalAlignment(Element.ALIGN_CENTER);
        celdaTituloOrigen.setBackgroundColor(new BaseColor(200, 200, 200)); // Color de fondo para el título
        tablaOrigen.addCell(celdaTituloOrigen);
        
        String[] headersOrigen = {"Numero de Paquete", "Origen", "Domicilio retiro", "Emisor"};
        for (String header : headersOrigen) {
            PdfPCell cell = new PdfPCell(new Phrase(header));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaOrigen.addCell(cell);
        }
        
        // Tabla para los datos del destino
        PdfPTable tablaDestino = new PdfPTable(5); // Se ha cambiado el número de columnas a 5
        tablaDestino.setWidthPercentage(100);
        tablaDestino.setSpacingBefore(10f);
        tablaDestino.setSpacingAfter(10f);
        
        // Título de la tabla de destino
        Font fontTituloDestino = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        PdfPCell celdaTituloDestino = new PdfPCell(new Phrase("Destino del Paquete", fontTituloDestino));
        celdaTituloDestino.setColspan(5); // Ajuste del colspan al nuevo número de columnas
        celdaTituloDestino.setHorizontalAlignment(Element.ALIGN_CENTER);
        celdaTituloDestino.setBackgroundColor(new BaseColor(200, 200, 200)); // Color de fondo para el título
        tablaDestino.addCell(celdaTituloDestino);
        
        String[] headersDestino = {"Numero de Paquete", "Destino", "Domicilio entrega", "Receptor", "Descripcion"};
        for (String header : headersDestino) {
            PdfPCell cell = new PdfPCell(new Phrase(header));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDestino.addCell(cell);
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            // Datos del origen
            tablaOrigen.addCell(model.getValueAt(i, 0).toString());
            tablaOrigen.addCell(model.getValueAt(i, 1).toString());
            tablaOrigen.addCell(model.getValueAt(i, 2).toString());
            tablaOrigen.addCell(model.getValueAt(i, 5).toString());
            
            // Datos del destino
            tablaDestino.addCell(model.getValueAt(i, 0).toString());
            tablaDestino.addCell(model.getValueAt(i, 3).toString());
            tablaDestino.addCell(model.getValueAt(i, 4).toString());
            tablaDestino.addCell(model.getValueAt(i, 6).toString());
            tablaDestino.addCell(model.getValueAt(i, 7).toString());
        }

        documento.add(tablaOrigen);
        documento.add(tablaDestino);
        documento.close();
        // Crear un JLabel para personalizar el mensaje
        JLabel pdfcreado = new JLabel("PDF creado correctamente en el escritorio.");
        // Establecer la fuente del JLabel
        pdfcreado.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        // Mostrar el cuadro de diálogo de información con el JLabel personalizado y el título personalizado
        JOptionPane.showMessageDialog(null, pdfcreado, "Información", JOptionPane.INFORMATION_MESSAGE);
    } catch (DocumentException | IOException e) {
        // Crear un JLabel para personalizar el mensaje
        JLabel errorpdf = new JLabel("Error al crear el PDF: " + e.getMessage());
        // Establecer la fuente del JLabel
        errorpdf.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
        // Mostrar el cuadro de diálogo de error con el JLabel personalizado y el título personalizado
        JOptionPane.showMessageDialog(null, errorpdf, "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

 private void cargarPaquetesPlanificados() {
    List<Paquete> paquetesPlanificados = ctrlPaquete.obtenerPaquetesPlanificadosPorViaje(viajeID);

    // Ordenar los paquetes por la localidad y provincia del origen
    Collections.sort(paquetesPlanificados, new Comparator<Paquete>() {
        @Override
        public int compare(Paquete p1, Paquete p2) {
            // Comparar las localidades
            int localidadComparison = p1.getLocalidadOrigen().getNombre().compareTo(p2.getLocalidadOrigen().getNombre());
            if (localidadComparison != 0) {
                return localidadComparison;
            }
            // Si las localidades son iguales, comparar las provincias
            return p1.getOrigen().getNombre().compareTo(p2.getOrigen().getNombre());
        }
    });

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);

    for (Paquete paquete : paquetesPlanificados) {
        String nombreApellidoEmisor = paquete.getEmisor().getNombre() + " " + paquete.getEmisor().getApellido();
        String nombreApellidoReceptor = paquete.getReceptor().getNombre() + " " + paquete.getReceptor().getApellido();
        
        // Concatenar provincia y localidad para origen y destino
        String origenCompleto = paquete.getOrigen().getNombre() + ", " + paquete.getLocalidadOrigen().getNombre();
        String destinoCompleto = paquete.getDestino().getNombre() + ", " + paquete.getLocalidadDestino().getNombre();
        
        model.addRow(new Object[]{
            paquete.getPaqueteID(),
            origenCompleto,
            paquete.getDomicilioRetiro(),
            destinoCompleto,
            paquete.getDomicilioEntrega(),
            nombreApellidoEmisor,
            nombreApellidoReceptor,
            paquete.getDescripcion()
        });
    }
 }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
