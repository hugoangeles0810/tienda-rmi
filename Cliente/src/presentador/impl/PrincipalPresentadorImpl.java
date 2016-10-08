package presentador.impl;

import presentador.PrincipalPresentador;
import vista.PrincipalVista;

public class PrincipalPresentadorImpl implements PrincipalPresentador {
  
  private PrincipalVista vista;

  public PrincipalPresentadorImpl(PrincipalVista vista) {
    this.vista = vista;
  }

  @Override
  public void onMenuIniciarSesion() {
    vista.mostrarLoginForm();
  }

  @Override
  public void onMenuCerrarSesion() {
    vista.enableMenuOptions(false);
    vista.mostrarLoginForm();
  }

  @Override
  public void onMenuSalir() {
    System.exit(0);
  }

  @Override
  public void onStart() {
    vista.enableMenuOptions(Boolean.FALSE);
  }
  
}
