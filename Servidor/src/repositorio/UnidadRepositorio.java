package repositorio;

import java.util.List;
import remoto.entidad.Unidad;

public interface UnidadRepositorio {
  
  public void guardar(Unidad unidad);
  public void actualizar(Unidad unidad);
  public void eliminar(Unidad unidad);
  public Unidad buscarPorAbreviatura(String abreviatura);
  public Unidad buscarPorNombre(String nombre);
  public List<Unidad> listar();
  public List<Unidad> filtrar(Unidad unidad);
  
}
