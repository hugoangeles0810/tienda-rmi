package vista;

import java.util.List;
import remoto.entidad.Usuario;

public interface UsuariosVista {
  
  public void onUsuarioSelected(Usuario usuario);
  public void mostrarUsuarios(List<Usuario> usuarios);
  public void showError(String msg);
  public void onActionSuccess(String msg);
  public void onActionFailed(String cause);
  
}
