/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author hugo
 */
public interface PrincipalVista {
  public void mostrarMensaje(String mensaje);
  public void mostrarError(String error);

  public void enableButtons(Boolean start, Boolean stop, Boolean restart);

  public void showProgress();
  public void hideProgress();
}