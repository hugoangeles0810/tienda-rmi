package repositorio;

import java.util.List;
import remoto.entidad.Producto;

public interface ProductoRepositorio {
  
  public void guardar(Producto producto);
  public void actualizar(Producto producto);
  public void eliminar(Producto producto);
  public Producto buscarPorNombre(String nombre);
  public List<Producto> listar();
  public List<Producto> filtrar(Producto producto);
  
}
