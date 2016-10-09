package remoto.servicio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import remoto.entidad.GuiaCabecera;
import remoto.util.RespuestaServidor;

public interface GuiaServicio extends Remote {
  
  public RespuestaServidor guiaEntrada(GuiaCabecera guia) throws RemoteException;
  
}
