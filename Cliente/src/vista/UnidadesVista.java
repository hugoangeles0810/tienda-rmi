package vista;

import java.util.List;
import remoto.entidad.Unidad;

public interface UnidadesVista {
  
  public void onUnidadSelected(Unidad unidad);
  public void mostrarUnidades(List<Unidad> unidades);
  public void showError(String msg);
  public void onActionSuccess(String msg);
  public void onActionFailed(String cause);
  
}
