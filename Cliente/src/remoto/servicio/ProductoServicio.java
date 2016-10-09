package remoto.servicio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import remoto.entidad.Producto;
import remoto.util.RespuestaServidor;

public interface ProductoServicio extends Remote {
  
  public Producto obtener(Integer id) throws RemoteException;
  public List<Producto> buscar(Producto producto) throws RemoteException;
  public RespuestaServidor guardar(Producto producto) throws RemoteException;
  public RespuestaServidor actualizar(Producto producto) throws RemoteException;
  public RespuestaServidor eliminar(Producto producto) throws RemoteException;
  
}
