package presentador.impl;

import java.rmi.RemoteException;
import presentador.VentaPresentador;
import remoto.entidad.BoletaCabecera;
import remoto.servicio.BoletaServicio;
import remoto.util.RespuestaServidor;
import rmi.ClienteRMI;
import vista.VentaVista;

public class VentaPresentadorImpl implements VentaPresentador {
  
  private VentaVista vista;
  
  public VentaPresentadorImpl(VentaVista vista) {
    this.vista = vista;
  }

  @Override
  public void guardar(BoletaCabecera boleta) {
    BoletaServicio boletaServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(BoletaServicio.class);
    
     try {
       RespuestaServidor respuesta = boletaServicio.guardarBoleta(boleta);
       
       if (respuesta.esExito()) {
         vista.onActionSuccess(respuesta.getMsg());
       } else {
         vista.onActionFailed(respuesta.getMsg());
       }
     } catch (RemoteException|NullPointerException ex) {
      vista.showError("Error al conectar con el servidor");
    }
  }
  
}
