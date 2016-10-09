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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import presentador.EntradaMercaderiaPresentador;
import presentador.impl.EntradaMercaderiaPresentadorImpl;
import remoto.entidad.GuiaCabecera;
import remoto.entidad.GuiaDetalle;
import remoto.entidad.Producto;
import util.UIHelper;
import util.Validator;
import vista.EntradaMercaderiaVista;

public class InternalFrameEntradaMercaderia extends javax.swing.JInternalFrame
              implements EntradaMercaderiaVista, DialogBuscadorProductos.OnProductoSelected {

  public InternalFrameEntradaMercaderia() {
    initComponents();
    
    guiaDetalles = new ArrayList<>();
    jTableDetalles.getColumn("Acción").setCellRenderer(new TableButtonRenderer());
    jTableDetalles.getColumn("Acción").setCellEditor(new TableButtonEditor(new JCheckBox()));
    
    presentador = new EntradaMercaderiaPresentadorImpl(this);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelPrincipal = new javax.swing.JPanel();
    jPanelGuiaEntrada = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextFieldNroGuia = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jTextFieldProducto = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jTextFieldUnidad = new javax.swing.JTextField();
    jButtonBuscarProducto = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    jTextFieldCantidad = new javax.swing.JTextField();
    jButtonAgregar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTableDetalles = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();

    setClosable(true);
    setIconifiable(true);
    setTitle("Procesos - Entrada de mercaderia");

    jPanelGuiaEntrada.setBorder(javax.swing.BorderFactory.createTitledBorder("Guia entrada"));

    jLabel1.setText("Nro de guia");

    jLabel2.setText("Producto");

    jTextFieldProducto.setEditable(false);
    jTextFieldProducto.setEnabled(false);

    jLabel3.setText("Unidad");

    jTextFieldUnidad.setEditable(false);
    jTextFieldUnidad.setEnabled(false);

    jButtonBuscarProducto.setText("Buscar");
    jButtonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonBuscarProductoActionPerformed(evt);
      }
    });

    jLabel4.setText("Cantidad");

    jButtonAgregar.setText("Agregar");
    jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonAgregarActionPerformed(evt);
      }
    });

    jTableDetalles.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "#", "Nombre", "Unidad", "Cantidad", "Acción"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, true, true
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(jTableDetalles);

    jButton1.setText("Guardar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanelGuiaEntradaLayout = new javax.swing.GroupLayout(jPanelGuiaEntrada);
    jPanelGuiaEntrada.setLayout(jPanelGuiaEntradaLayout);
    jPanelGuiaEntradaLayout.setHorizontalGroup(
      jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelGuiaEntradaLayout.createSequentialGroup()
        .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelGuiaEntradaLayout.createSequentialGroup()
            .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel4)
              .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGuiaEntradaLayout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addComponent(jLabel1))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGuiaEntradaLayout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)))))
            .addGap(18, 18, 18)
            .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanelGuiaEntradaLayout.createSequentialGroup()
                .addComponent(jTextFieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarProducto))
              .addComponent(jTextFieldNroGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jButtonAgregar)
                .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                  .addComponent(jTextFieldUnidad, javax.swing.GroupLayout.Alignment.LEADING))))
            .addGap(0, 98, Short.MAX_VALUE))
          .addGroup(jPanelGuiaEntradaLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGuiaEntradaLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jButton1)))
        .addContainerGap())
    );
    jPanelGuiaEntradaLayout.setVerticalGroup(
      jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelGuiaEntradaLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jTextFieldNroGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2)
          .addComponent(jButtonBuscarProducto))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanelGuiaEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jButtonAgregar)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
    jPanelPrincipal.setLayout(jPanelPrincipalLayout);
    jPanelPrincipalLayout.setHorizontalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanelGuiaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanelPrincipalLayout.setVerticalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanelGuiaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

  private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
    if (esFormAgregarValido()) {
      agregarDetalleGuia();
    }
  }//GEN-LAST:event_jButtonAgregarActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (esFormValido()) {
      readStocks();
      GuiaCabecera guiaCabecera = new GuiaCabecera();
      guiaCabecera.setNumero(jTextFieldNroGuia.getText());
      guiaCabecera.setGuiaDetalleList(guiaDetalles);
      
      presentador.guardar(guiaCabecera);
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  private EntradaMercaderiaPresentador presentador;
  private DialogBuscadorProductos dialogBuscadorProductos;
  private Producto productoSelected;
  private final List<GuiaDetalle> guiaDetalles;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButtonAgregar;
  private javax.swing.JButton jButtonBuscarProducto;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanelGuiaEntrada;
  private javax.swing.JPanel jPanelPrincipal;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTableDetalles;
  private javax.swing.JTextField jTextFieldCantidad;
  private javax.swing.JTextField jTextFieldNroGuia;
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
    }
  }
  
  private Boolean esFormValido() {
    if (Validator.isEmpty(jTextFieldNroGuia)) {
      showError("Debe ingresar el número de guia.");
      return false;
    }
    
    if (guiaDetalles.isEmpty()) {
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
    
    if (!Validator.esDoubleEnRango(jTextFieldCantidad, 0d, Double.MAX_VALUE)) {
      showError("Debe ingresar una cantidad válida.");
      return false;
    }
    
    if (estaProductoEnDetalle(productoSelected)) {
      showError("Ya agregó este producto.");
      return false;
    }
    
    return true;
  }
  
  private Boolean estaProductoEnDetalle(Producto producto) {
    for (GuiaDetalle guiaDetalle : guiaDetalles) {
      if (guiaDetalle.getProducto().getId().equals(producto.getId())) {
        return true;
      }
    }
    
    return false;
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
    UIHelper.cleanTextField(jTextFieldNroGuia, jTextFieldProducto, jTextFieldUnidad, jTextFieldCantidad);
    UIHelper.removeRowsOfTable((DefaultTableModel) jTableDetalles.getModel());
    productoSelected = null;
    guiaDetalles.clear();
  }

  private void agregarDetalleGuia() {
    DefaultTableModel model = (DefaultTableModel) jTableDetalles.getModel();
    
    GuiaDetalle detalle = new GuiaDetalle();
    detalle.setProducto(productoSelected);
    detalle.setCantidad(BigDecimal.valueOf(Double.valueOf(jTextFieldCantidad.getText())));
    
    guiaDetalles.add(detalle);
    
    Object row[] = new Object[5];
    
    row[0] = guiaDetalles.size();
    row[1] = detalle.getProducto().getNombre();
    row[2] = detalle.getProducto().getUnidad().getNombre();
    row[3] = detalle.getCantidad().doubleValue();
    row[4] = "Eliminar";
    
    model.addRow(row);
    jTableDetalles.setModel(model);
    
    
    productoSelected = null;
    UIHelper.cleanTextField(jTextFieldProducto, jTextFieldUnidad, jTextFieldCantidad);
  }

  private void readStocks() {
    DefaultTableModel model = (DefaultTableModel) jTableDetalles.getModel();
    
    Integer rows = model.getRowCount();
    
    for (int i = 0; i < rows; i++) {
      BigDecimal stock = BigDecimal.valueOf((Double)model.getValueAt(i, 3));
      guiaDetalles.get(i).setCantidad(stock);
    }
    
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
        guiaDetalles.remove(row);
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
