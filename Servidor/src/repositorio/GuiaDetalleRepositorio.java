package repositorio;

import java.util.List;
import remoto.entidad.GuiaDetalle;

public interface GuiaDetalleRepositorio {
  
  public void guardar(GuiaDetalle detalle);
  public List<GuiaDetalle> obtenerPorCabecera(Integer guiaId);
  
}
