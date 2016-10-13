package remoto.servicio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import remoto.entidad.BoletaCabecera;
import remoto.util.RespuestaServidor;

public interface BoletaServicio extends Remote {
  
  public RespuestaServidor guardarBoleta(BoletaCabecera boleta) throws RemoteException;
  
}
