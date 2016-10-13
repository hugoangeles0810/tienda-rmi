package repositorio;

import java.util.List;
import remoto.entidad.Unidad;
import util.BusinessException;

public interface UnidadRepositorio {
  
  public Unidad obtener(Integer id);
  public void guardar(Unidad unidad);
  public void actualizar(Unidad unidad);
  public void eliminar(Unidad unidad) throws BusinessException;
  public Unidad buscarPorAbreviatura(String abreviatura);
  public Unidad buscarPorNombre(String nombre);
  public List<Unidad> listar();
  public List<Unidad> filtrar(Unidad unidad);
  
}
