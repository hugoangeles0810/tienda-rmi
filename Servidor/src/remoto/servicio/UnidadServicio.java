package remoto.servicio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import remoto.entidad.Unidad;
import remoto.util.RespuestaServidor;

public interface UnidadServicio extends Remote {

  public Unidad obtener(Integer id) throws RemoteException;
  public List<Unidad> buscarUnidades(Unidad unidad) throws RemoteException;
  public RespuestaServidor guardarUnidad(Unidad unidad) throws RemoteException;
  public RespuestaServidor actualizarUnidad(Unidad unidad) throws RemoteException;
  public RespuestaServidor eliminarUnidad(Unidad unidad) throws RemoteException;

}