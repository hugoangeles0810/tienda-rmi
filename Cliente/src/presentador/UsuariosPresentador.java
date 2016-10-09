package presentador;

import remoto.entidad.Usuario;

public interface UsuariosPresentador {
  
  public void buscarPorId(Integer id);
  public void buscarUsuarios(Usuario filtro);
  public void guardarUsuario(Usuario usuario);
  public void eliminarUsuario(Usuario usuario);
  
}
