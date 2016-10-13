package repositorio;

import java.util.List;
import remoto.entidad.Producto;
import util.BusinessException;

public interface ProductoRepositorio {
  
  public Producto obtener(Integer id);
  public void guardar(Producto producto);
  public void actualizar(Producto producto);
  public void eliminar(Producto producto) throws BusinessException;
  public Producto buscarPorNombre(String nombre);
  public List<Producto> listar();
  public List<Producto> filtrar(Producto producto);
  
}
