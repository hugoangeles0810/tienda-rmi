package ui;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import presentador.UsuariosPresentador;
import presentador.impl.UsuariosPresentadorImpl;
import remoto.entidad.Usuario;
import util.UIHelper;
import util.Validator;
import vista.UsuariosVista;

public class InternalFrameUsuarios extends javax.swing.JInternalFrame 
              implements UsuariosVista{

  public InternalFrameUsuarios() {
    initComponents();
    
    jTextFieldId.setVisible(false);
    jTableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(20);
    
    usuariosPresentador = new UsuariosPresentadorImpl(this);
    usuariosPresentador.buscarUsuarios(readBuscarForm());
    
    cancelar();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelPrincipal = new javax.swing.JPanel();
    jPanelListadoUsuarios = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTableUsuarios = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jTextFieldBUsername = new javax.swing.JTextField();
    jButtonBuscar = new javax.swing.JButton();
    jPanelFormUsuarios = new javax.swing.JPanel();
    jLabelUsername = new javax.swing.JLabel();
    jTextFieldUsername = new javax.swing.JTextField();
    jLabelPassword = new javax.swing.JLabel();
    jPasswordFieldPassword = new javax.swing.JPasswordField();
    jLabelPassword1 = new javax.swing.JLabel();
    jPasswordFieldConfirm = new javax.swing.JPasswordField();
    jButtonNuevo = new javax.swing.JButton();
    jButtonGuardar = new javax.swing.JButton();
    jButtonModificar = new javax.swing.JButton();
    jButtonEliminar = new javax.swing.JButton();
    jButtonCancelar = new javax.swing.JButton();
    jTextFieldId = new javax.swing.JTextField();

    setClosable(true);
    setIconifiable(true);
    setTitle("Mantenimiento - Usuarios");

    jPanelListadoUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado"));

    jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "#", "Username"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jTableUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
    jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTableUsuariosMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jTableUsuarios);

    jLabel1.setText("Username");

    jTextFieldBUsername.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextFieldBUsernameKeyPressed(evt);
      }
    });

    jButtonBuscar.setText("Buscar");
    jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonBuscarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanelListadoUsuariosLayout = new javax.swing.GroupLayout(jPanelListadoUsuarios);
    jPanelListadoUsuarios.setLayout(jPanelListadoUsuariosLayout);
    jPanelListadoUsuariosLayout.setHorizontalGroup(
      jPanelListadoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelListadoUsuariosLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelListadoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelListadoUsuariosLayout.createSequentialGroup()
            .addComponent(jTextFieldBUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(125, 125, 125)
            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel1))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListadoUsuariosLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    jPanelListadoUsuariosLayout.setVerticalGroup(
      jPanelListadoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListadoUsuariosLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanelListadoUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldBUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonBuscar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jPanelFormUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

    jLabelUsername.setText("Username");

    jLabelPassword.setText("Contraseña");

    jLabelPassword1.setText("Confirmar");

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

    javax.swing.GroupLayout jPanelFormUsuariosLayout = new javax.swing.GroupLayout(jPanelFormUsuarios);
    jPanelFormUsuarios.setLayout(jPanelFormUsuariosLayout);
    jPanelFormUsuariosLayout.setHorizontalGroup(
      jPanelFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelFormUsuariosLayout.createSequentialGroup()
        .addContainerGap(27, Short.MAX_VALUE)
        .addGroup(jPanelFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormUsuariosLayout.createSequentialGroup()
            .addGroup(jPanelFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanelFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabelUsername)
                .addComponent(jTextFieldUsername)
                .addComponent(jLabelPassword)
                .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jLabelPassword1)
              .addComponent(jPasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(89, 89, 89))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormUsuariosLayout.createSequentialGroup()
            .addComponent(jButtonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormUsuariosLayout.createSequentialGroup()
            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(146, 146, 146))))
    );
    jPanelFormUsuariosLayout.setVerticalGroup(
      jPanelFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelFormUsuariosLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addComponent(jLabelUsername)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabelPassword)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabelPassword1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPasswordFieldConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanelFormUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButtonNuevo)
          .addComponent(jButtonGuardar)
          .addComponent(jButtonModificar)
          .addComponent(jButtonEliminar))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButtonCancelar)
        .addContainerGap())
    );

    javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
    jPanelPrincipal.setLayout(jPanelPrincipalLayout);
    jPanelPrincipalLayout.setHorizontalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanelListadoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanelFormUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanelPrincipalLayout.setVerticalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jPanelFormUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanelListadoUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

  private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
    usuariosPresentador.buscarUsuarios(readBuscarForm());
  }//GEN-LAST:event_jButtonBuscarActionPerformed

  private void jTextFieldBUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBUsernameKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     usuariosPresentador.buscarUsuarios(readBuscarForm());
   }
  }//GEN-LAST:event_jTextFieldBUsernameKeyPressed

  private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMouseClicked
    int row = jTableUsuarios.rowAtPoint(evt.getPoint());
    if (row >= 0) {
      usuariosPresentador.buscarPorId(usuarios.get(row).getId());
    }
  }//GEN-LAST:event_jTableUsuariosMouseClicked

  private void seleccionar(Usuario usuario) {
    enableForm(false);
    usuarioForm = usuario;
    fillForm(usuarioForm);
    UIHelper.seleccionar(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }

  private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    cancelar();
  }//GEN-LAST:event_jButtonCancelarActionPerformed

  private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
    nuevo();
  }//GEN-LAST:event_jButtonNuevoActionPerformed

  private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
    modificar();
  }//GEN-LAST:event_jButtonModificarActionPerformed

  private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
    if (esFormValido()) {
      usuarioForm = readForm();
      usuariosPresentador.guardarUsuario(usuarioForm);
    }
  }//GEN-LAST:event_jButtonGuardarActionPerformed

  private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
    if (UIHelper.confirmDetele(this)) {
      usuarioForm = readForm();
      usuariosPresentador.eliminarUsuario(usuarioForm);
    }
  }//GEN-LAST:event_jButtonEliminarActionPerformed

  private void modificar() {
    enableForm(true);
    jTextFieldUsername.requestFocus();
    UIHelper.modificar(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }

  private void nuevo() {
    enableForm(true);
    usuarioForm = new Usuario();
    fillForm(usuarioForm);
    jTextFieldUsername.requestFocus();
    UIHelper.nuevo(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }

  private void cancelar() {
    enableForm(false);
    usuarioForm = new Usuario();
    fillForm(usuarioForm);
    UIHelper.cancelar(jButtonNuevo, jButtonGuardar, jButtonModificar, jButtonEliminar, jButtonCancelar);
  }


  private UsuariosPresentador usuariosPresentador;
  private Usuario usuarioForm;
  private List<Usuario> usuarios;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonBuscar;
  private javax.swing.JButton jButtonCancelar;
  private javax.swing.JButton jButtonEliminar;
  private javax.swing.JButton jButtonGuardar;
  private javax.swing.JButton jButtonModificar;
  private javax.swing.JButton jButtonNuevo;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabelPassword;
  private javax.swing.JLabel jLabelPassword1;
  private javax.swing.JLabel jLabelUsername;
  private javax.swing.JPanel jPanelFormUsuarios;
  private javax.swing.JPanel jPanelListadoUsuarios;
  private javax.swing.JPanel jPanelPrincipal;
  private javax.swing.JPasswordField jPasswordFieldConfirm;
  private javax.swing.JPasswordField jPasswordFieldPassword;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTableUsuarios;
  private javax.swing.JTextField jTextFieldBUsername;
  private javax.swing.JTextField jTextFieldId;
  private javax.swing.JTextField jTextFieldUsername;
  // End of variables declaration//GEN-END:variables

  @Override
  public void mostrarUsuarios(List<Usuario> usuarios) {
    DefaultTableModel model = (DefaultTableModel) jTableUsuarios.getModel();
    
    UIHelper.removeRowsOfTable(model);
    
    Integer index = 0;
    for (Usuario usuario : usuarios) {
      Object datos[] = new Object[2];
      datos[0] = ++index;
      datos[1] = usuario.getUsername();
      
      model.addRow(datos);
    }
    
    this.usuarios = usuarios;
    jTableUsuarios.setModel(model);
  }

  private Usuario readBuscarForm() {
    Usuario usuario = new Usuario();
    usuario.setUsername(jTextFieldBUsername.getText());
    return usuario;
  }

  private void fillForm(Usuario user) {
    if (user.getId() != null) {
      jTextFieldId.setText(String.valueOf(user.getId()));
    } else {
      jTextFieldId.setText("");
    }
    jTextFieldUsername.setText(user.getUsername());
    jPasswordFieldPassword.setText(user.getPassword());
    jPasswordFieldConfirm.setText(user.getPassword());
  }
  
  private Usuario readForm() {
    Usuario user = new Usuario();
    
    if (jTextFieldId.getText().equals("")) {
      user.setId(null);
    } else {
      user.setId(Integer.parseInt(jTextFieldId.getText()));
    }
    
    user.setUsername(jTextFieldUsername.getText());
    user.setPassword(new String(jPasswordFieldPassword.getPassword()));
    
    return user;
  }
  
  private void enableForm(Boolean val) {
    jTextFieldUsername.setEnabled(val);
    jPasswordFieldPassword.setEnabled(val);
    jPasswordFieldConfirm.setEnabled(val);
  }

  @Override
  public void showError(String msg) {
    UIHelper.showError(this, msg);
  }

  @Override
  public void onActionSuccess(String msg) {
    usuariosPresentador.buscarUsuarios(readBuscarForm());
    cancelar();
    UIHelper.showInfo(this, msg);
  }

  @Override
  public void onActionFailed(String cause) {
    UIHelper.showError(this, cause);
  }

  private boolean esFormValido() {
    if (Validator.isEmpty(jTextFieldUsername)) {
      showError("Debe ingresar el username.");
      return false;
    }
    
    if (Validator.isEmpty(jPasswordFieldPassword)) {
      showError("Debe ingresar la contraseña.");
      return false;
    }
    
    if (Validator.isEmpty(jPasswordFieldConfirm)) {
      showError("Debe confirmar la contraseña.");
      return false;
    }
    
    if (!Validator.areEquals(jPasswordFieldPassword, jPasswordFieldConfirm)) {
      showError("Las contraseñas no coinciden.");
      return false;
    }
    
    return true;
  }

  @Override
  public void onUsuarioSelected(Usuario usuario) {
    seleccionar(usuario);
  }
}
