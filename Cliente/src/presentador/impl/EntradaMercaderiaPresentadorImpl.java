package presentador.impl;

import java.rmi.RemoteException;
import presentador.EntradaMercaderiaPresentador;
import remoto.entidad.GuiaCabecera;
import remoto.servicio.GuiaServicio;
import remoto.util.RespuestaServidor;
import rmi.ClienteRMI;
import vista.EntradaMercaderiaVista;

public class EntradaMercaderiaPresentadorImpl 
              implements EntradaMercaderiaPresentador {
  
  private EntradaMercaderiaVista vista;
  
  public EntradaMercaderiaPresentadorImpl(EntradaMercaderiaVista vista) {
    this.vista = vista;
  }

  @Override
  public void guardar(GuiaCabecera guia) {
    GuiaServicio guiaServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(GuiaServicio.class);
    
     try {
       RespuestaServidor respuesta = guiaServicio.guiaEntrada(guia);
       
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
