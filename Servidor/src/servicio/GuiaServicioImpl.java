package servicio;

import db.ConnectionFactory;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import remoto.entidad.GuiaCabecera;
import remoto.entidad.GuiaDetalle;
import remoto.entidad.Producto;
import remoto.servicio.GuiaServicio;
import remoto.util.RespuestaServidor;
import repositorio.GuiaCabeceraRepositorio;
import repositorio.GuiaDetalleRepositorio;
import repositorio.ProductoRepositorio;

public class GuiaServicioImpl extends UnicastRemoteObject implements GuiaServicio{
  
  private GuiaCabeceraRepositorio cabeceraRepositorio;
  private GuiaDetalleRepositorio detalleRepositorio;
  private ProductoRepositorio productoRepositorio;

  public GuiaServicioImpl(GuiaCabeceraRepositorio cabeceraRepositorio, 
                          GuiaDetalleRepositorio detalleRepositorio, 
                          ProductoRepositorio productoRepositorio) 
              throws RemoteException {
    super();
    this.cabeceraRepositorio = cabeceraRepositorio;
    this.detalleRepositorio = detalleRepositorio;
    this.productoRepositorio = productoRepositorio;
  }

  @Override
  public RespuestaServidor guiaEntrada(GuiaCabecera guia) throws RemoteException {
    try {
      // Inicia transaction
      ConnectionFactory.getConnection().setAutoCommit(false);
      
      cabeceraRepositorio.guardar(guia);
    
      for (GuiaDetalle detalle : guia.getGuiaDetalleList()) {

        detalle.setGuiaCabecera(guia);
        detalleRepositorio.guardar(detalle);

        Producto producto = productoRepositorio.obtener(detalle.getProducto().getId());
        producto.setStock(producto.getStock().add(detalle.getCantidad()));
        productoRepositorio.actualizar(producto);
      }
      
      // Commit transaction
      ConnectionFactory.getConnection().commit();
      return RespuestaServidor.getExito("Guia de entrada registrada.");
    } catch (Exception e) {
      // Rollback transaction
      System.out.println("Error: " + e.getMessage());
      try {
        ConnectionFactory.getConnection().rollback();
      } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
      }
      return RespuestaServidor.getError("Error al ingresar guia trasacción anulada.");
    }
  }
  
}
