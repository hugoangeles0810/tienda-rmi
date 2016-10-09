package servicio;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import remoto.entidad.Producto;
import remoto.servicio.ProductoServicio;
import remoto.util.RespuestaServidor;
import repositorio.ProductoRepositorio;

public class ProductoServicioImpl extends UnicastRemoteObject
                 implements ProductoServicio {

  private ProductoRepositorio productoRepositorio;

  public ProductoServicioImpl(ProductoRepositorio productoRepositorio) throws RemoteException {
    super();
    this.productoRepositorio = productoRepositorio;
  }

  @Override
  public List<Producto> buscar(Producto producto) throws RemoteException {
    return productoRepositorio.filtrar(producto);
  }

  @Override
  public RespuestaServidor guardar(Producto producto) throws RemoteException {
    if (!esDuplicado(producto)) {
      productoRepositorio.guardar(producto);
      return RespuestaServidor.getExito("Producto registrado existosamente.");
    } else {
      return RespuestaServidor.getError("El nombre ingresado ya está registrado.");
    }
  }
  
  private Boolean esDuplicado(Producto producto) {
    Producto productoFlag = productoRepositorio.buscarPorNombre(producto.getNombre());
    
    if (productoFlag != null && !productoFlag.getId().equals(producto.getId())) {
      return true;
    }
    
    return false;
  }

  @Override
  public RespuestaServidor actualizar(Producto producto) throws RemoteException {
    if (!esDuplicado(producto)) {
      productoRepositorio.actualizar(producto);
      return RespuestaServidor.getExito("Producto actualizado existosamente.");
    } else {
      return RespuestaServidor.getError("El nombre ingresado no está disponible.");
    }
  }

  @Override
  public RespuestaServidor eliminar(Producto producto) throws RemoteException {
    try {
      productoRepositorio.eliminar(producto);
      return RespuestaServidor.getExito("Producto eliminado.");
    } catch(Exception e) {
      return RespuestaServidor.getError("Error al eliminar la producto.");
    }
  }
}