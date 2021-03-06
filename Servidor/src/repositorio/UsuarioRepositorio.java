package repositorio;

import java.util.List;

import remoto.entidad.Usuario;

public interface UsuarioRepositorio {
  
  public Usuario obtener(Integer id);
  public void guardar(Usuario usuario);
  public void actualizar(Usuario usuario);
  public void eliminar(Usuario usuario);
  public List<Usuario> listar();
  public List<Usuario> filtrar(Usuario usuario);
  public Usuario obtenerPorLogin(String login);

}