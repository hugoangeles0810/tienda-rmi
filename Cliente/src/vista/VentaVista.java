package vista;

public interface VentaVista {
  
  public void showError(String msg);
  public void onActionSuccess(String msg);
  public void onActionFailed(String cause);
  
}
