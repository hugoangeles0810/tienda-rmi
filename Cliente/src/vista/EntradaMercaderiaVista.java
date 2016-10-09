package vista;

public interface EntradaMercaderiaVista {
  
  public void showError(String msg);
  public void onActionSuccess(String msg);
  public void onActionFailed(String cause);
  
}
