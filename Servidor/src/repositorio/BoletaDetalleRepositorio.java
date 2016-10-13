package repositorio;

import java.util.List;
import remoto.entidad.BoletaDetalle;

public interface BoletaDetalleRepositorio {
  
  public void guardar(BoletaDetalle detalle);
  public List<BoletaDetalle> obtenerPorCabecera(Integer id);
  
}
