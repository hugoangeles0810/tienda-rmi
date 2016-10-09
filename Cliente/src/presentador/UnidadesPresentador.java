package presentador;

import remoto.entidad.Unidad;
import remoto.entidad.Usuario;

public interface UnidadesPresentador {
  
  public void buscar(Unidad unidad);
  public void guardar(Unidad unidad);
  public void eliminar(Unidad unidad);
  
}
