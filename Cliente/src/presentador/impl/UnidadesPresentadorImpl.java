package presentador.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import presentador.UnidadesPresentador;
import remoto.entidad.Unidad;
import remoto.servicio.UnidadServicio;
import remoto.util.RespuestaServidor;
import rmi.ClienteRMI;
import vista.UnidadesVista;

public class UnidadesPresentadorImpl implements UnidadesPresentador{

  private UnidadesVista vista;
  
  public UnidadesPresentadorImpl(UnidadesVista vista) {
    this.vista = vista;
  }
  
  @Override
  public void buscar(Unidad filtro) {
    List<Unidad> unidades = new ArrayList<>();
    
    UnidadServicio unidadServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(UnidadServicio.class);
    
    try {
      unidades = unidadServicio.buscarUnidades(filtro);
    } catch (RemoteException|NullPointerException e) {}
    
    vista.mostrarUnidades(unidades);
  }

  @Override
  public void guardar(Unidad unidad) {
    UnidadServicio unidadServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(UnidadServicio.class);
    
    try {
      RespuestaServidor respuestaServidor;
      if (unidad.getId() == null) {
        respuestaServidor = unidadServicio.guardarUnidad(unidad);
      } else {
        respuestaServidor = unidadServicio.actualizarUnidad(unidad);
      }
      
      if (respuestaServidor.esExito()) {
        vista.onActionSuccess(respuestaServidor.getMsg());
      } else {
        vista.onActionFailed(respuestaServidor.getMsg());
      }
    } catch (RemoteException|NullPointerException ex) {
      vista.showError("Error al conectar con el servidor");
    }
  }

  @Override
  public void eliminar(Unidad unidad) {
    UnidadServicio unidadServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(UnidadServicio.class); 
    
    try {
      RespuestaServidor respuestaServidor = unidadServicio.eliminarUnidad(unidad);
      if (respuestaServidor.esExito()) {
        vista.onActionSuccess(respuestaServidor.getMsg());
      } else {
        vista.onActionFailed(respuestaServidor.getMsg());
      }
    } catch (RemoteException ex) {
      vista.showError("Error al conectar con el servidor");
    }
  }
  
}
