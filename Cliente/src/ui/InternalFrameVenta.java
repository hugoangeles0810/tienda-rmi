package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import presentador.VentaPresentador;
import presentador.impl.VentaPresentadorImpl;
import remoto.entidad.BoletaCabecera;
import remoto.entidad.BoletaDetalle;
import remoto.entidad.Producto;
import util.UIHelper;
import util.Validator;
import vista.VentaVista;

public class InternalFrameVenta extends javax.swing.JInternalFrame
              implements VentaVista, DialogBuscadorProductos.OnProductoSelected {

  public InternalFrameVenta() {
    initComponents();
    
    presentador = new VentaPresentadorImpl(this);
    
    boletaDetalles = new ArrayList<>();
    jTableDetalles.getColumn("Acción").setCellRenderer(new InternalFrameVenta.TableButtonRenderer());
    jTableDetalles.getColumn("Acción").setCellEditor(new InternalFrameVenta.TableButtonEditor(new JCheckBox()));
    
    jTableDetalles.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
        recalcularMonto();
      }
    });
    
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelPrincipal = new javax.swing.JPanel();
    jPanelVenta = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextFieldCliente = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jTextFieldDireccion = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jTextFieldMonto = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jTextFieldProducto = new javax.swing.JTextField();
    jButtonBuscarProducto = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    jTextFieldUnidad = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jTextFieldCantidad = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTableDetalles = new javax.swing.JTable();
    jButtonGuardar = new javax.swing.JButton();
    jButtonCancelar = new javax.swing.JButton();
    jButtonAgregar = new javax.swing.JButton();
    jLabel7 = new javax.swing.JLabel();
    jTextFieldPrecio = new javax.swing.JTextField();

    setClosable(true);
    setIconifiable(true);
    setTitle("Procesos - Venta");

    jPanelVenta.setBorder(javax.swing.BorderFactory.createTitledBorder("Venta"));

    jLabel1.setText("Cliente");

    jLabel2.setText("Dirección");

    jLabel3.setText("Monto");

    jTextFieldMonto.setEditable(false);
    jTextFieldMonto.setEnabled(false);

    jLabel4.setText("Producto");

    jTextFieldProducto.setEditable(false);
    jTextFieldProducto.setEnabled(false);

    jButtonBuscarProducto.setText("Buscar");
    jButtonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonBuscarProductoActionPerformed(evt);
      }
    });

    jLabel5.setText("Unidad");

    jTextFieldUnidad.setEditable(false);
    jTextFieldUnidad.setEnabled(false);

    jLabel6.setText("Cant.");

    jTableDetalles.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "#", "Nombre", "Unidad", "P. Unit", "Cant.", "Acción"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false, true, true
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(jTableDetalles);

    jButtonGuardar.setText("Guardar");
    jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonGuardarActionPerformed(evt);
      }
    });

    jButtonCancelar.setText("Cancelar");
    jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonCancelarActionPerformed(evt);
      }
    });

    jButtonAgregar.setText("Agregar");
    jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonAgregarActionPerformed(evt);
      }
    });

    jLabel7.setText("Precio");

    jTextFieldPrecio.setEditable(false);
    jTextFieldPrecio.setEnabled(false);

    javax.swing.GroupLayout jPanelVentaLayout = new javax.swing.GroupLayout(jPanelVenta);
    jPanelVenta.setLayout(jPanelVentaLayout);
    jPanelVentaLayout.setHorizontalGroup(
      jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelVentaLayout.createSequentialGroup()
        .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelVentaLayout.createSequentialGroup()
            .addGap(74, 74, 74)
            .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarProducto))
              .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVentaLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanelVentaLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel1)
                  .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel2)
                  .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel3)
                  .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
              .addComponent(jScrollPane1))))
        .addContainerGap())
    );
    jPanelVentaLayout.setVerticalGroup(
      jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelVentaLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanelVentaLayout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanelVentaLayout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanelVentaLayout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(18, 18, 18)
        .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(jTextFieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonBuscarProducto))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5)
          .addComponent(jLabel6)
          .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel7)
            .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
          .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
    jPanelPrincipal.setLayout(jPanelPrincipalLayout);
    jPanelPrincipalLayout.setHorizontalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanelVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanelPrincipalLayout.setVerticalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanelVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 15, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButtonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarProductoActionPerformed
    if (dialogBuscadorProductos == null || !dialogBuscadorProductos.isDisplayable()) {
      dialogBuscadorProductos = new DialogBuscadorProductos(null, true, this);
    }
    dialogBuscadorProductos.setLocationRelativeTo(null);
    dialogBuscadorProductos.setVisible(true);
  }//GEN-LAST:event_jButtonBuscarProductoActionPerformed

  private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    cleanForm();
  }//GEN-LAST:event_jButtonCancelarActionPerformed

  private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
    if (esFormAgregarValido()) {
      agregarDetalleBoleta();
    }
  }//GEN-LAST:event_jButtonAgregarActionPerformed

  private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
    if (esFormValido()) {
      recalcularMonto();
      BoletaCabecera boleta = new BoletaCabecera();
      boleta.setCliente(jTextFieldCliente.getText());
      boleta.setDireccion(jTextFieldDireccion.getText());
      boleta.setBoletaDetalleList(boletaDetalles);
      presentador.guardar(boleta);
    }
  }//GEN-LAST:event_jButtonGuardarActionPerformed

  private VentaPresentador presentador;
  private Producto productoSelected;
  private List<BoletaDetalle> boletaDetalles;
  private DialogBuscadorProductos dialogBuscadorProductos;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonAgregar;
  private javax.swing.JButton jButtonBuscarProducto;
  private javax.swing.JButton jButtonCancelar;
  private javax.swing.JButton jButtonGuardar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanelPrincipal;
  private javax.swing.JPanel jPanelVenta;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTableDetalles;
  private javax.swing.JTextField jTextFieldCantidad;
  private javax.swing.JTextField jTextFieldCliente;
  private javax.swing.JTextField jTextFieldDireccion;
  private javax.swing.JTextField jTextFieldMonto;
  private javax.swing.JTextField jTextFieldPrecio;
  private javax.swing.JTextField jTextFieldProducto;
  private javax.swing.JTextField jTextFieldUnidad;
  // End of variables declaration//GEN-END:variables

  @Override
  public void productoSelected(Producto producto) {
    if (producto != null) {
      dialogBuscadorProductos.dispose();
      productoSelected = producto;
      jTextFieldProducto.setText(productoSelected.getNombre());
      jTextFieldUnidad.setText(productoSelected.getUnidad().getNombre());
      jTextFieldPrecio.setText(String.format("%.2f", productoSelected.getPrecio().doubleValue()).replaceAll(",", "."));
    }
  }

  @Override
  public void showError(String msg) {
     UIHelper.showError(this, msg);
  }

  @Override
  public void onActionSuccess(String msg) {
    UIHelper.showInfo(this, msg);
    cleanForm();
  }

  @Override
  public void onActionFailed(String cause) {
     UIHelper.showError(this, cause);
  }

  private void cleanForm() {
    UIHelper.cleanTextField(jTextFieldCliente, jTextFieldDireccion, jTextFieldMonto, 
      jTextFieldProducto, jTextFieldUnidad, jTextFieldPrecio, jTextFieldCantidad);
    UIHelper.removeRowsOfTable((DefaultTableModel) jTableDetalles.getModel());
    productoSelected = null;
    boletaDetalles.clear();
  }
  
  private Boolean estaProductoEnDetalle(Producto producto) {
    for (BoletaDetalle boletaDetalle : boletaDetalles) {
      if (boletaDetalle.getProducto().getId().equals(producto.getId())) {
        return true;
      }
    }
    
    return false;
  }
  
  private Boolean esFormValido() {
    
    if (boletaDetalles.isEmpty()) {
      showError("Debe seleccionar al menos un producto.");
      return false;
    }
    
    return true;
  }
  
  private Boolean esFormAgregarValido() {
    if (productoSelected == null) {
      showError("Debe seleccionar el producto.");
      return false;
    }
    
    if (!Validator.esDoubleEnRango(jTextFieldCantidad, 0.01, Double.MAX_VALUE)) {
      showError("Debe ingresar una cantidad válida.");
      return false;
    }
    
    if (estaProductoEnDetalle(productoSelected)) {
      showError("Ya agregó este producto.");
      return false;
    }
    
    return true;
  }

  private void agregarDetalleBoleta() {
    DefaultTableModel model = (DefaultTableModel) jTableDetalles.getModel();
    
    BoletaDetalle detalle = new BoletaDetalle();
    detalle.setProducto(productoSelected);
    detalle.setPrecio(productoSelected.getPrecio());
    detalle.setCantidad(BigDecimal.valueOf(Double.valueOf(jTextFieldCantidad.getText())));
    
    boletaDetalles.add(detalle);
    
    Object row[] = new Object[7];
    
    row[0] = boletaDetalles.size();
    row[1] = detalle.getProducto().getNombre();
    row[2] = detalle.getProducto().getUnidad().getNombre();
    row[3] = detalle.getPrecio().doubleValue();
    row[4] = detalle.getCantidad().doubleValue();
    row[5] = "Eliminar";
    
    model.addRow(row);
    jTableDetalles.setModel(model);
    productoSelected = null;
    
    recalcularMonto();
    UIHelper.cleanTextField(jTextFieldProducto, jTextFieldUnidad, jTextFieldPrecio, jTextFieldCantidad);
  }
  
  private void readCantidades() {
    DefaultTableModel model = (DefaultTableModel) jTableDetalles.getModel();
    
    Integer rows = model.getRowCount();
    
    for (int i = 0; i < rows; i++) {
      BigDecimal stock = BigDecimal.valueOf((Double)model.getValueAt(i, 4));
      boletaDetalles.get(i).setCantidad(stock);
    }
    
  }

  private void recalcularMonto() {
    BigDecimal monto = BigDecimal.ZERO;
    readCantidades();
    for (BoletaDetalle detalle : boletaDetalles) {
      monto = monto.add(detalle.getPrecio().multiply(detalle.getCantidad()));
    }
    jTextFieldMonto.setText(String.format("%.2f", monto.doubleValue()).replaceAll(",", "."));
  }
  
  class TableButtonRenderer extends JButton implements TableCellRenderer {
    public TableButtonRenderer()
    {
      setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      setForeground(Color.black);
      setBackground(UIManager.getColor("Button.background"));
      setText((value == null) ? "" : value.toString());
      return this;
    }
  }
  
  class TableButtonEditor extends DefaultCellEditor
  {
    private JButton button;
    private String label;
    private boolean clicked;
    private int row, col;
    private JTable table;

    public TableButtonEditor(JCheckBox checkBox)
    {
      super(checkBox);
      button = new JButton();
      button.setOpaque(true);
      button.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          fireEditingStopped();
        }
      });
    }
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
      this.table = table;
      this.row = row;
      this.col = column;

      button.setForeground(Color.black);
      button.setBackground(UIManager.getColor("Button.background"));
      label = (value == null) ? "" : value.toString();
      button.setText(label);
      clicked = true;
      return button;
    }
    public Object getCellEditorValue()
    {
      if (clicked)
      {
        boletaDetalles.remove(row);
        ((DefaultTableModel)table.getModel()).removeRow(row);
      }
      clicked = false;
      return new String(label);
    }

    public boolean stopCellEditing()
    {
      clicked = false;
      return super.stopCellEditing();
    }

    protected void fireEditingStopped()
    {
      try {
        super.fireEditingStopped();
      } catch(IndexOutOfBoundsException e) {}
    }
  }

  
}
