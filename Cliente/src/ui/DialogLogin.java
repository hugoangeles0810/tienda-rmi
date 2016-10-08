package ui;

import presentador.LoginPresentador;
import presentador.impl.LoginPresentadorImpl;
import remoto.entidad.Usuario;
import util.Parametros;
import util.UIHelper;
import util.Validator;
import vista.LoginVista;

public class DialogLogin extends javax.swing.JDialog 
              implements LoginVista {
  
  private OnLoginSuccess onLoginSuccess;
  
  public interface OnLoginSuccess {
    public void loginSuccess(Usuario usuario);
  }
  
  public DialogLogin(java.awt.Frame parent, boolean modal, DialogLogin.OnLoginSuccess onLoginSuccess) {
    super(parent, modal);
    initComponents();
    jTextFieldHost.setText(Parametros.HOST);
    jTextFieldPuerto.setText(String.valueOf(Parametros.PORT));
    loginPresentador = new LoginPresentadorImpl(this);
    this.onLoginSuccess = onLoginSuccess;
    getRootPane().setDefaultButton(jButtonIngresar);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelPrincipal = new javax.swing.JPanel();
    jLabelIniciarSesion = new javax.swing.JLabel();
    jPanelControles = new javax.swing.JPanel();
    jLabelUsername = new javax.swing.JLabel();
    jTextFieldUsername = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jPasswordFieldPassword = new javax.swing.JPasswordField();
    jLabel2 = new javax.swing.JLabel();
    jTextFieldHost = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jTextFieldPuerto = new javax.swing.JTextField();
    jButtonCancelar = new javax.swing.JButton();
    jButtonIngresar = new javax.swing.JButton();
    jProgressBar = new javax.swing.JProgressBar();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Iniciar sesión");
    setResizable(false);

    jLabelIniciarSesion.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
    jLabelIniciarSesion.setText("Iniciar sesión");

    jPanelControles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabelUsername.setText("Nombre de usuario:");

    jLabel1.setText("Contraseña");

    jLabel2.setText("Host");

    jLabel3.setText("Puerto");

    javax.swing.GroupLayout jPanelControlesLayout = new javax.swing.GroupLayout(jPanelControles);
    jPanelControles.setLayout(jPanelControlesLayout);
    jPanelControlesLayout.setHorizontalGroup(
      jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelControlesLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelControlesLayout.createSequentialGroup()
            .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel3)
              .addComponent(jTextFieldPuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
            .addGap(130, 130, 130))
          .addGroup(jPanelControlesLayout.createSequentialGroup()
            .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(jTextFieldHost, javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jLabelUsername)
                  .addComponent(jTextFieldUsername)
                  .addComponent(jLabel1)
                  .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                .addComponent(jLabel2)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    jPanelControlesLayout.setVerticalGroup(
      jPanelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlesLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabelUsername)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(22, Short.MAX_VALUE))
    );

    jButtonCancelar.setText("Cancelar");
    jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonCancelarActionPerformed(evt);
      }
    });

    jButtonIngresar.setText("Ingresar");
    jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonIngresarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
    jPanelPrincipal.setLayout(jPanelPrincipalLayout);
    jPanelPrincipalLayout.setHorizontalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jLabelIniciarSesion)
        .addGap(115, 115, 115))
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelPrincipalLayout.createSequentialGroup()
            .addGap(34, 34, 34)
            .addComponent(jPanelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanelPrincipalLayout.createSequentialGroup()
            .addGap(81, 81, 81)
            .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addContainerGap(34, Short.MAX_VALUE))
    );
    jPanelPrincipalLayout.setVerticalGroup(
      jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelPrincipalLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabelIniciarSesion)
        .addGap(18, 18, 18)
        .addComponent(jPanelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
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

  private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
    if (esFormularioValido()) {
      Parametros.HOST = jTextFieldHost.getText();
      Parametros.PORT = Integer.parseInt(jTextFieldPuerto.getText());
      Usuario usuario = new Usuario();
      usuario.setUsername(jTextFieldUsername.getText());
      usuario.setPassword(new String(jPasswordFieldPassword.getPassword()));
      loginPresentador.iniciarSesion(usuario);
    }
    
  }//GEN-LAST:event_jButtonIngresarActionPerformed

  private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
    onLoginSuccess = null;
    dispose();
  }//GEN-LAST:event_jButtonCancelarActionPerformed
  
  private Boolean esFormularioValido() {
    if (jTextFieldHost.getText().trim().equals("")) {
      UIHelper.showError(this, "Debe ingresar el host del servidor.");
      return false;
    }
    
    if (jTextFieldPuerto.getText().equals("")) {
      UIHelper.showError(this, "Debe ingresar el puerto del servidor.");
      return false;
    }
    
    if (!Validator.esEnteroPositivo(jTextFieldPuerto.getText())) {
      UIHelper.showError(this, "El campo puerto debe ser un número.");
      return false;
    }
    
    if (jTextFieldUsername.getText().trim().equals("")) {
      UIHelper.showError(this, "Debe ingresar su nombre de usuario.");
      return false;
    }
    
    if (new String(jPasswordFieldPassword.getPassword()).equals("")) {
      UIHelper.showError(this, "Debe ingresar su contraseña.");
      return false;
    }
    
    
    return true;
  }

  private LoginPresentador loginPresentador;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonCancelar;
  private javax.swing.JButton jButtonIngresar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabelIniciarSesion;
  private javax.swing.JLabel jLabelUsername;
  private javax.swing.JPanel jPanelControles;
  private javax.swing.JPanel jPanelPrincipal;
  private javax.swing.JPasswordField jPasswordFieldPassword;
  private javax.swing.JProgressBar jProgressBar;
  private javax.swing.JTextField jTextFieldHost;
  private javax.swing.JTextField jTextFieldPuerto;
  private javax.swing.JTextField jTextFieldUsername;
  // End of variables declaration//GEN-END:variables

  @Override
  public void limpiarInputs() {
    jTextFieldUsername.setText("");
    jPasswordFieldPassword.setText("");
  }

  @Override
  public void enableInputs(Boolean value) {
    jTextFieldUsername.setEnabled(value);
    jPasswordFieldPassword.setEnabled(value);
    jButtonIngresar.setEnabled(value);
  }

  @Override
  public void showProgress() {
    jProgressBar.setIndeterminate(true);
  }

  @Override
  public void hideProgress() {
    jProgressBar.setIndeterminate(false);
  }

  @Override
  public void onLoginSuccess(Usuario usuario) {
    if (onLoginSuccess != null) {
      onLoginSuccess.loginSuccess(usuario);
    }
  }

  @Override
  public void onLoginFailed() {
    UIHelper.showError(this, "Usuario y/o constraseña incorrectos");
  }

  @Override
  public void onLoginError() {
    UIHelper.showError(this, "Error al conectar con el servidor");
  }
}
