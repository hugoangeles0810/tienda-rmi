package presentador;

import remoto.entidad.Producto;

public interface ProductosPresentador {
  
  public void buscar(Producto producto);
  public void guardar(Producto producto);
  public void eliminar(Producto producto);
  
}
