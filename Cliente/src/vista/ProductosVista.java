package vista;

import java.util.List;
import remoto.entidad.Producto;

public interface ProductosVista {
  
  public void onProductoSelected(Producto producto);
  public void mostrarProductos(List<Producto> productos);
  public void showError(String msg);
  public void onActionSuccess(String msg);
  public void onActionFailed(String cause);
  
}
