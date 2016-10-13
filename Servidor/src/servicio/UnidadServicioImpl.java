package servicio;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import remoto.entidad.Unidad;
import remoto.servicio.UnidadServicio;
import remoto.util.RespuestaServidor;
import repositorio.UnidadRepositorio;
import util.BusinessException;

public class UnidadServicioImpl extends UnicastRemoteObject
                 implements UnidadServicio {

  private UnidadRepositorio unidadRepositorio;

  public UnidadServicioImpl(UnidadRepositorio unidadRepositorio) throws RemoteException {
    super();
    this.unidadRepositorio = unidadRepositorio;
  }

  @Override
  public List<Unidad> buscarUnidades(Unidad unidad) throws RemoteException {
    return unidadRepositorio.filtrar(unidad);
  }

  @Override
  public RespuestaServidor guardarUnidad(Unidad unidad) throws RemoteException {
    if (!esDuplicado(unidad)) {
      unidadRepositorio.guardar(unidad);
      return RespuestaServidor.getExito("Unidad registrada existosamente.");
    } else {
      return RespuestaServidor.getError("El nombre y/o abreviatura ingresado ya está registrado.");
    }
  }
  
  private Boolean esDuplicado(Unidad unidad) {
    Unidad unidadFlag = unidadRepositorio.buscarPorAbreviatura(unidad.getAbreviatura());
    
    if (unidadFlag != null && !unidadFlag.getId().equals(unidad.getId())) {
      return true;
    }
    
    unidadFlag = unidadRepositorio.buscarPorNombre(unidad.getNombre());
    
    if (unidadFlag != null && !unidadFlag.getId().equals(unidad.getId())) {
      return true;
    }
    
    return false;
  }

  @Override
  public RespuestaServidor actualizarUnidad(Unidad unidad) throws RemoteException {
    if (!esDuplicado(unidad)) {
      unidadRepositorio.actualizar(unidad);
      return RespuestaServidor.getExito("Unidad actualizada existosamente.");
    } else {
      return RespuestaServidor.getError("El nombre y/o abreviatura ingresado no está disponible.");
    }
  }

  @Override
  public RespuestaServidor eliminarUnidad(Unidad unidad) throws RemoteException {
    try {
      unidadRepositorio.eliminar(unidad);
      return RespuestaServidor.getExito("Unidad eliminada.");
    } catch(Exception e) {
      String msg = e instanceof BusinessException ? e.getMessage() : "Error al eliminar la unidad.";
      return RespuestaServidor.getError(msg);
    }
  }

  @Override
  public Unidad obtener(Integer id) throws RemoteException {
    return unidadRepositorio.obtener(id);
  }
}