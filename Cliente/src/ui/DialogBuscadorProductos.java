package ui;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import presentador.ProductosPresentador;
import presentador.impl.ProductosPresentadorImpl;
import remoto.entidad.Producto;
import util.UIHelper;
import vista.ProductosVista;

public class DialogBuscadorProductos extends javax.swing.JDialog
              implements ProductosVista {
  
  public interface OnProductoSelected {
    public void productoSelected(Producto producto);
  }

  public DialogBuscadorProductos(java.awt.Frame parent, boolean modal, OnProductoSelected onProductoSelected) {
    super(parent, modal);
    initComponents();
    this.onProductoSelected = onProductoSelected;
    
    productosPresentador = new ProductosPresentadorImpl(this);
    productosPresentador.buscar(readBuscarForm());
    
    getRootPane().setDefaultButton(jButtonBuscar);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelPrincipal = new javax.swing.JPanel();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextFieldBNombre = new javax.swing.JTextField();
    jButtonBuscar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTableListado = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Buscador de productos");

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscador"));

    jLabel1.setText("Nombre");

    jButtonBuscar.setText("Buscar");
    jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonBuscarActionPerformed(evt);
      }
    });

    jTableListado.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "#", "Nombre", "Unidad"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jTableListado.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTableListadoMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jTableListado);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jTextFieldBNombre)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonBuscar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
    jPanelPrincipal.setLayout(jPanelPrincipalLayout);
    jPanelPrincipalLayout.setHorizontalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanelPrincipalLayout.setVerticalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
      .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jTableListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoMouseClicked
    int row = jTableListado.rowAtPoint(evt.getPoint());
    if (row >= 0) {
      productosPresentador.buscarPorId(productos.get(row).getId());
    }
  }//GEN-LAST:event_jTableListadoMouseClicked

  private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
    productosPresentador.buscar(readBuscarForm());
  }//GEN-LAST:event_jButtonBuscarActionPerformed


  private ProductosPresentador productosPresentador;
  private DialogBuscadorProductos.OnProductoSelected onProductoSelected;
  private List<Producto> productos;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonBuscar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanelPrincipal;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTableListado;
  private javax.swing.JTextField jTextFieldBNombre;
  // End of variables declaration//GEN-END:variables
  
  @Override
  public void onProductoSelected(Producto producto) {
    if (onProductoSelected != null) {
      onProductoSelected.productoSelected(producto);
    }
  }

  @Override
  public void mostrarProductos(List<Producto> productos) {
    DefaultTableModel model = (DefaultTableModel) jTableListado.getModel();
    
    UIHelper.removeRowsOfTable(model);
    
    Integer index = 0;
    for (Producto producto : productos) {
      Object datos[] = new Object[4];
      datos[0] = ++index;
      datos[1] = producto.getNombre();
      datos[2] = producto.getUnidad().getNombre();
      datos[3] = producto.getStock().doubleValue();
      
      model.addRow(datos);
    }
    
    this.productos = productos;
    jTableListado.setModel(model);
  }

  @Override
  public void showError(String msg) {
    UIHelper.showError(this, msg);
  }

  @Override
  public void onActionSuccess(String msg) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void onActionFailed(String cause) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  private Producto readBuscarForm() {
    Producto producto = new Producto();
    producto.setNombre(jTextFieldBNombre.getText());
    return producto;
  }
}
