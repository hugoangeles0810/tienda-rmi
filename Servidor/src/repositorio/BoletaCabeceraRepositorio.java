package repositorio;

import java.util.List;
import remoto.entidad.BoletaCabecera;

public interface BoletaCabeceraRepositorio {
  
  public void guardar(BoletaCabecera boletaCabecera);
  public void actualizar(BoletaCabecera boletaCabecera);
  public List<BoletaCabecera> filtrar(BoletaCabecera boletaCabecera);
  
}
