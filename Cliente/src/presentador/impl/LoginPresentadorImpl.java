package presentador.impl;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentador.LoginPresentador;
import remoto.entidad.Usuario;
import remoto.servicio.UsuarioServicio;
import rmi.ClienteRMI;
import util.Parametros;
import vista.LoginVista;

public class LoginPresentadorImpl implements LoginPresentador{
  
  private UsuarioServicio usuarioServicio;
  private LoginVista loginVista;
  private Thread actionThread;

  public LoginPresentadorImpl(LoginVista loginVista) {
    this.loginVista = loginVista;
  }

  @Override
  public void iniciarSesion(final Usuario usuario) {
    
    actionThread = new Thread() {
      @Override
      public void run() {
        loginVista.enableInputs(false);
        loginVista.showProgress();
        
        usuarioServicio = ClienteRMI
                          .getInstance()
                          .obtenerServicio(UsuarioServicio.class);

        try {
          if (usuarioServicio.esUsuarioValido(usuario)) {
            loginVista.hideProgress();
            loginVista.onLoginSuccess(usuario);
          } else {
            loginVista.hideProgress();
            loginVista.onLoginFailed();
          }
          loginVista.enableInputs(true);
        } catch (RemoteException|NullPointerException ex) {
          loginVista.hideProgress();
          loginVista.onLoginError();
          loginVista.enableInputs(true);
          System.out.println("error: " + ex.getMessage());
        }
        
      }
      
    };
    
    actionThread.start();
    
  }
  
}
