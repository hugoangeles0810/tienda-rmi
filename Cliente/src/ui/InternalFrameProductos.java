package ui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import presentador.ProductosPresentador;
import presentador.impl.ProductosPresentadorImpl;
import remoto.entidad.Producto;
import remoto.entidad.Unidad;
import util.UIHelper;
import util.Validator;
import vista.ProductosVista;

public class InternalFrameProductos extends javax.swing.JInternalFrame
                implements ProductosVista, DialogBuscadorUnidades.OnUnidadSelected {

  public InternalFrameProductos() {
    initComponents();
    
    jTextFieldId.setVisible(false);
    jTextFieldUnidadId.setVisible(false);
    
    productosPresentador = new ProductosPresentadorImpl(this);
    productosPresentador.buscar(readBuscarForm());
    
    cancelar();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelPrincipal = new javax.swing.JPanel();
    jPanelListado = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTableListado = new javax.swing.JTable();
    jLabel4 = new javax.swing.JLabel();
    jTextFieldBNombre = new javax.swing.JTextField();
    jButtonBuscar = new javax.swing.JButton();
    jPanelFormulario = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextFieldNombre = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jTextFieldUnidad = new javax.swing.JTextField();
    jButtonBuscarUnidad = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    jTextFieldStock = new javax.swing.JTextField();
    jButtonNuevo = new javax.swing.JButton();
    jButtonGuardar = new javax.swing.JButton();
    jButtonModificar = new javax.swing.JButton();
    jButtonEliminar = new javax.swing.JButton();
    jButtonCancelar = new javax.swing.JButton();
    jTextFieldId = new javax.swing.JTextField();
    jTextFieldUnidadId = new javax.swing.JTextField();

    setClosable(true);
    setIconifiable(true);
    setTitle("Matenimiento  - Productos");

    jPanelListado.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));

    jTableListado.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "#", "Nombre", "Unidad", "Stock"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false
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

    jLabel4.setText("Nombre");

    jTextFieldBNombre.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextFieldBNombreKeyPressed(evt);
      }
    });

    jButtonBuscar.setText("Buscar");
    jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonBuscarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanelListadoLayout = new javax.swing.GroupLayout(jPanelListado);
    jPanelListado.setLayout(jPanelListadoLayout);
    jPanelListadoLayout.setHorizontalGroup(
      jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelListadoLayout.createSequentialGroup()
        .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelListadoLayout.createSequentialGroup()
            .addComponent(jTextFieldBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonBuscar))
          .addGroup(jPanelListadoLayout.createSequentialGroup()
            .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel4))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanelListadoLayout.setVerticalGroup(
      jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListadoLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonBuscar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addContainerGap())
    );

    jPanelFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

    jLabel1.setText("Nombre");

    jLabel2.setText("Unidad");

    jTextFieldUnidad.setEditable(false);
    jTextFieldUnidad.setEnabled(false);

    jButtonBuscarUnidad.setText("Buscar");
    jButtonBuscarUnidad.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonBuscarUnidadActionPerformed(evt);
      }
    });

    jLabel3.setText("Stock");

    jButtonNuevo.setText("Nuevo");
    jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonNuevoActionPerformed(evt);
      }
    });

    jButtonGuardar.setText("Guardar");
    jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonGuardarActionPerformed(evt);
      }
    });

    jButtonModificar.setText("Modificar");
    jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonModificarActionPerformed(evt);
      }
    });

    jButtonEliminar.setText("Eliminar");
    jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonEliminarActionPerformed(evt);
      }
    });

    jButtonCancelar.setText("Cancelar");
    jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonCancelarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(jPanelFormulario);
    jPanelFormulario.setLayout(jPanelFormularioLayout);
    jPanelFormularioLayout.setHorizontalGroup(
      jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelFormularioLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jTextFieldNombre)
          .addGroup(jPanelFormularioLayout.createSequentialGroup()
            .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel2)
                  .addComponent(jTextFieldUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscarUnidad))
              .addComponent(jLabel3)
              .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addComponent(jButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(134, 134, 134))))
              .addGroup(jPanelFormularioLayout.createSequentialGroup()
                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUnidadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 16, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanelFormularioLayout.setVerticalGroup(
      jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelFormularioLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonBuscarUnidad))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(7, 7, 7)
        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextFieldUnidadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jButtonNuevo)
          .addGroup(jPanelFormularioLayout.createSequentialGroup()
            .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jButtonGuardar)
              .addComponent(jButtonModificar)
              .addComponent(jButtonEliminar))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButtonCancelar)))
        .addContainerGap(114, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
    jPanelPrincipal.setLayout(jPanelPrincipalLayout);
    jPanelPrincipalLayout.setHorizontalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanelListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jPanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanelPrincipalLayout.setVerticalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jPanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanelListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
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

  private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
    nuevo();
  }//GEN-LAST:event_jButtonNuevoActionPerformed

  private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
    if (esFormValido()) {
      productoForm = readForm();
      productosPresentador.guardar(productoForm);
    }
  }//GEN-LAST:event_jButtonGuardarActionPerformed

  private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
    modificar();
  }//GEN-LAST:event_jButtonModificarActionPerformed

  private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
    if (UIHelper.confirmDetele(this)) {
      productoForm = readForm();
      productosPresentador.eliminar(productoForm);
    }
  }//GEN-LAST:event_jButtonEliminarActionPerformed

  private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    cancelar();
  }//GEN-LAST:event_jButtonCancelarActionPerformed

  private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
    productosPresentador.buscar(readBuscarForm());
  }//GEN-LAST:event_jButtonBuscarActionPerformed

  private void jTextFieldBNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBNombreKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     productosPresentador.buscar(readBuscarForm());
    }
  }//GEN-LAST:event_jTextFieldBNombreKeyPressed

  private void jTableListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoMouseClicked
    int row = jTableListado.rowAtPoint(evt.getPoint());
    if (row >= 0) {
      productosPresentador.buscarPorId(productos.get(row).getId());
    }
  }//GEN-LAST:event_jTableListadoMouseClicked

  private void jButtonBuscarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarUnidadActionPerformed
    if (dialogBuscarUnidades == null || !dialogBuscarUnidades.isDisplayable()) {
      dialogBuscarUnidades = new DialogBuscadorUnidades(null, true, this);
    }
    dialogBuscarUnidades.setLocationRelativeTo(null);
    dialogBuscarUnidades.setVisible(true);
  }//GEN-LAST:event_jButtonBuscarUnidadActionPerformed

private ProductosPresentador productosPresentador;
private List<Producto> productos;
private Producto productoForm;
private DialogBuscadorUnidades dialogBuscarUnidades;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonBuscar;
  private javax.swing.JButton jButtonBuscarUnidad;
  private javax.swing.JButton jButtonCancelar;
  private javax.swing.JButton jButtonEliminar;
  private javax.swing.JButton jButtonGuardar;
  private javax.swing.JButton jButtonModificar;
  private javax.swing.JButton jButtonNuevo;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanelFormulario;
  private javax.swing.JPanel jPanelListado;
  private javax.swing.JPanel jPanelPrincipal;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTableListado;
  private javax.swing.JTextField jTextFieldBNombre;
  private javax.swing.JTextField jTextFieldId;
  private javax.swing.JTextField jTextFieldNombre;
  private javax.swing.JTextField jTextFieldStock;
  private javax.swing.JTextField jTextFieldUnidad;
  private javax.swing.JTextField jTextFieldUnidadId;
  // End of variables declaration//GEN-END:variables

  private Producto readBuscarForm() {
    Producto producto = new Producto();
    producto.setNombre(jTextFieldBNombre.getText());
    return producto;
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
    productosPresentador.buscar(readBuscarForm());
    cancelar();
    UIHelper.showInfo(this, msg);
  }

  @Override
  public void onActionFailed(String cause) {
    UIHelper.showError(this, cause);
  }
  
  private void modificar() {
    enableForm(true);
    jTextFieldNombre.requestFocus();
    UIHelper.modificar(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }

  private void nuevo() {
    enableForm(true);
    productoForm = new Producto();
    fillForm(productoForm);
    jTextFieldNombre.requestFocus();
    UIHelper.nuevo(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }

  private void cancelar() {
    enableForm(false);
    productoForm = new Producto();
    fillForm(productoForm);
    UIHelper.cancelar(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }
  
  private void seleccionar(Producto producto) {
    enableForm(false);
    productoForm = producto;
    fillForm(productoForm);
    UIHelper.seleccionar(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }
  
  private void enableForm(Boolean val) {
    jTextFieldNombre.setEnabled(val);
    jTextFieldStock.setEnabled(val);
    jButtonBuscarUnidad.setEnabled(val);
  }
  
  private void fillForm(Producto producto) {
    if (producto.getId() != null) {
      jTextFieldId.setText(String.valueOf(producto.getId()));
    } else {
      jTextFieldId.setText("");
    }
    
    if (producto.getUnidad() != null) {
      jTextFieldUnidad.setText(producto.getUnidad().getNombre());
      jTextFieldUnidadId.setText(String.valueOf(producto.getUnidad().getId()));
    } else {
      jTextFieldUnidad.setText("");
      jTextFieldUnidadId.setText("");
    }
    
    jTextFieldNombre.setText(producto.getNombre());
    
    if (producto.getStock() != null) {
      jTextFieldStock.setText(String.format("%.2f", producto.getStock().doubleValue()).replaceAll(",", "."));
    } else {
      jTextFieldStock.setText("");
    }
  }
  
  private Producto readForm() {
    Producto producto = new Producto();
    
    if (jTextFieldId.getText().equals("")) {
      producto.setId(null);
    } else {
      producto.setId(Integer.parseInt(jTextFieldId.getText()));
    }
    
    if (!jTextFieldUnidadId.getText().equals("")) {
      Unidad unidad = new Unidad();
      unidad.setId(Integer.parseInt(jTextFieldUnidadId.getText()));
      unidad.setNombre(jTextFieldUnidad.getText());
      
      producto.setUnidad(unidad);
    }
    
    producto.setNombre(jTextFieldNombre.getText());
    producto.setStock(BigDecimal.valueOf(Double.valueOf(jTextFieldStock.getText())));
    
    return producto;
  }
  
  private boolean esFormValido() {
    if (Validator.isEmpty(jTextFieldNombre)) {
      showError("Debe ingresar el nombre.");
      return false;
    }
    
    if (Validator.isEmpty(jTextFieldUnidadId)) {
      showError("Debe seleccionar la unidad.");
      return false;
    }
   
    if (!Validator.esDoubleEnRango(jTextFieldStock, 0d, Double.MAX_VALUE)) {
      showError("Debe ingresar un stock válido.");
      return false;
    }
    
    return true;
  }

  @Override
  public void unidadSelected(Unidad unidad) {
    dialogBuscarUnidades.dispose();
    jTextFieldUnidadId.setText(String.valueOf(unidad.getId()));
    jTextFieldUnidad.setText(unidad.getNombre());
  }

  @Override
  public void onProductoSelected(Producto producto) {
    seleccionar(producto);
  }
  
}
