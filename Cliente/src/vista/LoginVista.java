package vista;

import remoto.entidad.Usuario;

public interface LoginVista {
  public void limpiarInputs();
  public void enableInputs(Boolean value);
  public void showProgress();
  public void hideProgress();
  public void onLoginSuccess(Usuario usuario);
  public void onLoginFailed();
  public void onLoginError();
}
