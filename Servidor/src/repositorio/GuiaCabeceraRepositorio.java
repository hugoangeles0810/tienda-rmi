package repositorio;

import java.util.List;
import remoto.entidad.GuiaCabecera;

public interface GuiaCabeceraRepositorio {
  
  public void guardar(GuiaCabecera guiaCabecera);
  public List<GuiaCabecera> filtrar(GuiaCabecera guiaCabecera);
  
}
