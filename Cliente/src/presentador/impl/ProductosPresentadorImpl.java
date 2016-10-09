package presentador.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import presentador.ProductosPresentador;
import remoto.entidad.Producto;
import remoto.servicio.ProductoServicio;
import remoto.util.RespuestaServidor;
import rmi.ClienteRMI;
import vista.ProductosVista;

public class ProductosPresentadorImpl implements ProductosPresentador{

  private ProductosVista vista;
  
  public ProductosPresentadorImpl(ProductosVista vista) {
    this.vista = vista;
  }
  
  @Override
  public void buscar(Producto filtro) {
    List<Producto> productos = new ArrayList<>();
    
    ProductoServicio productoServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(ProductoServicio.class);
    
    try {
      productos = productoServicio.buscar(filtro);
    } catch (RemoteException|NullPointerException e) {}
    
    vista.mostrarProductos(productos);
  }

  @Override
  public void guardar(Producto producto) {
    ProductoServicio productoServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(ProductoServicio.class);
    
    try {
      RespuestaServidor respuestaServidor;
      if (producto.getId() == null) {
        respuestaServidor = productoServicio.guardar(producto);
      } else {
        respuestaServidor = productoServicio.actualizar(producto);
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
  public void eliminar(Producto producto) {
    ProductoServicio productoServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(ProductoServicio.class); 
    
    try {
      RespuestaServidor respuestaServidor = productoServicio.eliminar(producto);
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
