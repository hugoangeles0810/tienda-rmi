package ui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import presentador.PrincipalPresentador;
import presentador.impl.PrincipalPresentadorImpl;
import remoto.entidad.Usuario;
import util.UIHelper;
import vista.PrincipalVista;

public class FramePrincipal extends javax.swing.JFrame 
                implements PrincipalVista, DialogLogin.OnLoginSuccess {
  

  public FramePrincipal() {
    initComponents();
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = env.getDefaultScreenDevice();
    device.setFullScreenWindow(this);
    principalPresentador = new PrincipalPresentadorImpl(this);
    principalPresentador.onStart();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jDesktopPane = new javax.swing.JDesktopPane();
    jMenuBar = new javax.swing.JMenuBar();
    jMenuSistema = new javax.swing.JMenu();
    jMenuItemIniciarSesion = new javax.swing.JMenuItem();
    jMenuItemCerrarSesion = new javax.swing.JMenuItem();
    jMenuItemSalir = new javax.swing.JMenuItem();
    jMenuMantenimiento = new javax.swing.JMenu();
    jMenuItemMantUsuario = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jMenuSistema.setText("Sistema");

    jMenuItemIniciarSesion.setText("Iniciar Sesión");
    jMenuItemIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemIniciarSesionActionPerformed(evt);
      }
    });
    jMenuSistema.add(jMenuItemIniciarSesion);

    jMenuItemCerrarSesion.setText("Cerrar Sesión");
    jMenuItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemCerrarSesionActionPerformed(evt);
      }
    });
    jMenuSistema.add(jMenuItemCerrarSesion);

    jMenuItemSalir.setText("Salir");
    jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemSalirActionPerformed(evt);
      }
    });
    jMenuSistema.add(jMenuItemSalir);

    jMenuBar.add(jMenuSistema);

    jMenuMantenimiento.setText("Mantenimiento");

    jMenuItemMantUsuario.setText("Usuarios");
    jMenuItemMantUsuario.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemMantUsuarioActionPerformed(evt);
      }
    });
    jMenuMantenimiento.add(jMenuItemMantUsuario);

    jMenuBar.add(jMenuMantenimiento);

    setJMenuBar(jMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
    principalPresentador.onMenuSalir();
  }//GEN-LAST:event_jMenuItemSalirActionPerformed

  private void jMenuItemIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIniciarSesionActionPerformed
    principalPresentador.onMenuIniciarSesion();
  }//GEN-LAST:event_jMenuItemIniciarSesionActionPerformed

  private void jMenuItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarSesionActionPerformed
    jDesktopPane.removeAll();
    principalPresentador.onMenuCerrarSesion();
  }//GEN-LAST:event_jMenuItemCerrarSesionActionPerformed

  private void jMenuItemMantUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMantUsuarioActionPerformed
    if (internalFrameUsuarios == null || !internalFrameUsuarios.isDisplayable()) {
      internalFrameUsuarios = new InternalFrameUsuarios();
      jDesktopPane.add(internalFrameUsuarios);
    }
    internalFrameUsuarios.setLocation((getWidth()-internalFrameUsuarios.getWidth())/2, (getHeight()-internalFrameUsuarios.getHeight())/2);
    internalFrameUsuarios.show();
  }//GEN-LAST:event_jMenuItemMantUsuarioActionPerformed

 
private PrincipalPresentador principalPresentador;
private DialogLogin dialogLogin;
private InternalFrameUsuarios internalFrameUsuarios;
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JDesktopPane jDesktopPane;
  private javax.swing.JMenuBar jMenuBar;
  private javax.swing.JMenuItem jMenuItemCerrarSesion;
  private javax.swing.JMenuItem jMenuItemIniciarSesion;
  private javax.swing.JMenuItem jMenuItemMantUsuario;
  private javax.swing.JMenuItem jMenuItemSalir;
  private javax.swing.JMenu jMenuMantenimiento;
  private javax.swing.JMenu jMenuSistema;
  // End of variables declaration//GEN-END:variables

  @Override
  public void mostrarLoginForm() {
    if (dialogLogin == null || !dialogLogin.isDisplayable()) {
      dialogLogin = new DialogLogin(this, true, this);
    }
    dialogLogin.setLocationRelativeTo(null);
    dialogLogin.setVisible(true);
  }

  @Override
  public void ocultarLoginForm() {
    // Do not nothing
  }

  @Override
  public void enableMenuOptions(Boolean value) {
    jMenuMantenimiento.setEnabled(value);
    jMenuItemIniciarSesion.setEnabled(!value);
    jMenuItemCerrarSesion.setEnabled(value);
  }

  @Override
  public void loginSuccess(Usuario usuario) {
    dialogLogin.dispose();
    enableMenuOptions(true);
    UIHelper.showInfo(this, "Usuario " + usuario.getUsername() + " logueado exitosamente!");
  }
}
