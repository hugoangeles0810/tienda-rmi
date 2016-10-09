package ui;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import presentador.UnidadesPresentador;
import presentador.impl.UnidadesPresentadorImpl;
import remoto.entidad.Unidad;
import util.UIHelper;
import util.Validator;
import vista.UnidadesVista;

public class InternalFrameUnidades extends javax.swing.JInternalFrame 
              implements UnidadesVista {

  public InternalFrameUnidades() {
    initComponents();
    
    jTextFieldId.setVisible(false);
    
    unidadesPresentador = new UnidadesPresentadorImpl(this);
    unidadesPresentador.buscar(readBuscarForm());
    
    cancelar();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel2 = new javax.swing.JLabel();
    jPanelPrincipal = new javax.swing.JPanel();
    jPanelListado = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTableListado = new javax.swing.JTable();
    jLabel3 = new javax.swing.JLabel();
    jTextFieldBNombre = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jTextFieldBAbreviatura = new javax.swing.JTextField();
    jButtonBuscar = new javax.swing.JButton();
    jPanelFormulario = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jTextFieldNombre = new javax.swing.JTextField();
    jTextFieldAbreviatura = new javax.swing.JTextField();
    jButtonNuevo = new javax.swing.JButton();
    jButtonGuardar = new javax.swing.JButton();
    jButtonModificar = new javax.swing.JButton();
    jButtonEliminar = new javax.swing.JButton();
    jButtonCancelar = new javax.swing.JButton();
    jTextFieldId = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();

    jLabel2.setText("Abreviatura");

    setClosable(true);
    setIconifiable(true);
    setTitle("Mantenimiento - Unidades");

    jPanelListado.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));

    jTableListado.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "#", "Nombre", "Abreviatura"
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

    jLabel3.setText("Nombre");

    jTextFieldBNombre.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextFieldBNombreKeyPressed(evt);
      }
    });

    jLabel4.setText("Abreviatura");

    jTextFieldBAbreviatura.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextFieldBAbreviaturaKeyPressed(evt);
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
        .addContainerGap()
        .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addGroup(jPanelListadoLayout.createSequentialGroup()
            .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanelListadoLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 99, Short.MAX_VALUE))
              .addComponent(jTextFieldBNombre))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel4)
              .addComponent(jTextFieldBAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListadoLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jButtonBuscar)))
        .addContainerGap())
    );
    jPanelListadoLayout.setVerticalGroup(
      jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListadoLayout.createSequentialGroup()
        .addGroup(jPanelListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanelListadoLayout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanelListadoLayout.createSequentialGroup()
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldBAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButtonBuscar)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addContainerGap())
    );

    jPanelFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

    jLabel1.setText("Nombre");

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

    jTextFieldId.setEditable(false);

    jLabel5.setText("Abreviatura");

    javax.swing.GroupLayout jPanelFormularioLayout = new javax.swing.GroupLayout(jPanelFormulario);
    jPanelFormulario.setLayout(jPanelFormularioLayout);
    jPanelFormularioLayout.setHorizontalGroup(
      jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelFormularioLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelFormularioLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
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
                    .addGap(134, 134, 134)))
                .addGap(56, 56, 56))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormularioLayout.createSequentialGroup()
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jTextFieldAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel5))
                .addContainerGap())))
          .addGroup(jPanelFormularioLayout.createSequentialGroup()
            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))))
    );
    jPanelFormularioLayout.setVerticalGroup(
      jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelFormularioLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanelFormularioLayout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanelFormularioLayout.createSequentialGroup()
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldAbreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(13, 13, 13)
        .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jButtonNuevo)
          .addGroup(jPanelFormularioLayout.createSequentialGroup()
            .addGroup(jPanelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jButtonGuardar)
              .addComponent(jButtonModificar)
              .addComponent(jButtonEliminar))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButtonCancelar)))
        .addContainerGap(164, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
    jPanelPrincipal.setLayout(jPanelPrincipalLayout);
    jPanelPrincipalLayout.setHorizontalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanelListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    jPanelPrincipalLayout.setVerticalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanelListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
      unidadForm = readForm();
      unidadesPresentador.guardar(unidadForm);
    }
  }//GEN-LAST:event_jButtonGuardarActionPerformed

  private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
    modificar();
  }//GEN-LAST:event_jButtonModificarActionPerformed

  private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
    if (UIHelper.confirmDetele(this)) {
      unidadForm = readForm();
      unidadesPresentador.eliminar(unidadForm);
    }
  }//GEN-LAST:event_jButtonEliminarActionPerformed

  private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    cancelar();
  }//GEN-LAST:event_jButtonCancelarActionPerformed

  private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
    unidadesPresentador.buscar(readBuscarForm());
  }//GEN-LAST:event_jButtonBuscarActionPerformed

  private void jTextFieldBNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBNombreKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     unidadesPresentador.buscar(readBuscarForm());
    }
  }//GEN-LAST:event_jTextFieldBNombreKeyPressed

  private void jTextFieldBAbreviaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBAbreviaturaKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     unidadesPresentador.buscar(readBuscarForm());
    }
  }//GEN-LAST:event_jTextFieldBAbreviaturaKeyPressed

  private void jTableListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoMouseClicked
    int row = jTableListado.rowAtPoint(evt.getPoint());
    if (row >= 0) {
      unidadesPresentador.buscarPorId(unidades.get(row).getId());
    }
  }//GEN-LAST:event_jTableListadoMouseClicked


  private UnidadesPresentador unidadesPresentador;
  private Unidad unidadForm;
  private List<Unidad> unidades;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonBuscar;
  private javax.swing.JButton jButtonCancelar;
  private javax.swing.JButton jButtonEliminar;
  private javax.swing.JButton jButtonGuardar;
  private javax.swing.JButton jButtonModificar;
  private javax.swing.JButton jButtonNuevo;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanelFormulario;
  private javax.swing.JPanel jPanelListado;
  private javax.swing.JPanel jPanelPrincipal;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTableListado;
  private javax.swing.JTextField jTextFieldAbreviatura;
  private javax.swing.JTextField jTextFieldBAbreviatura;
  private javax.swing.JTextField jTextFieldBNombre;
  private javax.swing.JTextField jTextFieldId;
  private javax.swing.JTextField jTextFieldNombre;
  // End of variables declaration//GEN-END:variables

   private Unidad readBuscarForm() {
    Unidad unidad = new Unidad();
    unidad.setNombre(jTextFieldBNombre.getText());
    unidad.setAbreviatura(jTextFieldBAbreviatura.getText());
    return unidad;
  }
  
  @Override
  public void mostrarUnidades(List<Unidad> unidades) {
    DefaultTableModel model = (DefaultTableModel) jTableListado.getModel();
    
    UIHelper.removeRowsOfTable(model);
    
    Integer index = 0;
    for (Unidad unidad : unidades) {
      Object datos[] = new Object[3];
      datos[0] = ++index;
      datos[1] = unidad.getNombre();
      datos[2] = unidad.getAbreviatura();
      
      model.addRow(datos);
    }
    
    this.unidades = unidades;
    jTableListado.setModel(model);
  }

  @Override
  public void showError(String msg) {
    UIHelper.showError(this, msg);
  }

  @Override
  public void onActionSuccess(String msg) {
    unidadesPresentador.buscar(readBuscarForm());
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
    unidadForm = new Unidad();
    fillForm(unidadForm);
    jTextFieldNombre.requestFocus();
    UIHelper.nuevo(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }

  private void cancelar() {
    enableForm(false);
    unidadForm = new Unidad();
    fillForm(unidadForm);
    UIHelper.cancelar(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }
  
  private void seleccionar(Unidad unidad) {
    enableForm(false);
    unidadForm = unidad;
    fillForm(unidadForm);
    UIHelper.seleccionar(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }
  
  private void enableForm(Boolean val) {
    jTextFieldNombre.setEnabled(val);
    jTextFieldAbreviatura.setEnabled(val);
  }
  
  private void fillForm(Unidad unidad) {
    if (unidad.getId() != null) {
      jTextFieldId.setText(String.valueOf(unidad.getId()));
    } else {
      jTextFieldId.setText("");
    }
    jTextFieldNombre.setText(unidad.getNombre());
    jTextFieldAbreviatura.setText(unidad.getAbreviatura());
  }
  
  private Unidad readForm() {
    Unidad unidad = new Unidad();
    
    if (jTextFieldId.getText().equals("")) {
      unidad.setId(null);
    } else {
      unidad.setId(Integer.parseInt(jTextFieldId.getText()));
    }
    
    unidad.setNombre(jTextFieldNombre.getText());
    unidad.setAbreviatura(jTextFieldAbreviatura.getText());
    
    return unidad;
  }
  
  private boolean esFormValido() {
    if (Validator.isEmpty(jTextFieldNombre)) {
      showError("Debe ingresar el nombre.");
      return false;
    }
   
    if (Validator.isEmpty(jTextFieldAbreviatura)) {
      showError("Debe ingresar la abreviatura.");
      return false;
    }
    
    return true;
  }

  @Override
  public void onUnidadSelected(Unidad unidad) {
    seleccionar(unidad);
  }
}
