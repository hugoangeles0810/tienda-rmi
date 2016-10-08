package ui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;
import presentador.PrincipalPresentador;
import presentador.impl.PrincipalPresentadorImpl;
import remoto.entidad.Usuario;
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

    jMenuItemMantUsuario.setText("Usuario");
    jMenuMantenimiento.add(jMenuItemMantUsuario);

    jMenuBar.add(jMenuMantenimiento);

    setJMenuBar(jMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 281, Short.MAX_VALUE)
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
    principalPresentador.onMenuCerrarSesion();
  }//GEN-LAST:event_jMenuItemCerrarSesionActionPerformed

 
private PrincipalPresentador principalPresentador;
private DialogLogin dialogLogin;
  // Variables declaration - do not modify//GEN-BEGIN:variables
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
    JOptionPane.showMessageDialog(this, "Ocultando login");
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
    JOptionPane.showMessageDialog(this, "Usuario " + usuario.getUsername() + " logueado exitosamente!");
  }
}
