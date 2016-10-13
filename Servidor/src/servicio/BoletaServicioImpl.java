package servicio;

import db.ConnectionFactory;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import remoto.entidad.BoletaCabecera;
import remoto.entidad.BoletaDetalle;
import remoto.entidad.Producto;
import remoto.servicio.BoletaServicio;
import remoto.util.RespuestaServidor;
import repositorio.BoletaCabeceraRepositorio;
import repositorio.BoletaDetalleRepositorio;
import repositorio.ProductoRepositorio;
import util.BusinessException;

public class BoletaServicioImpl extends UnicastRemoteObject 
              implements BoletaServicio {
  
  private BoletaCabeceraRepositorio cabeceraRepositorio;
  private BoletaDetalleRepositorio detalleRepositorio;
  private ProductoRepositorio productoRepositorio;

  public BoletaServicioImpl(BoletaCabeceraRepositorio cabeceraRepositorio, 
                          BoletaDetalleRepositorio detalleRepositorio, 
                          ProductoRepositorio productoRepositorio) 
              throws RemoteException {
    super();
    this.cabeceraRepositorio = cabeceraRepositorio;
    this.detalleRepositorio = detalleRepositorio;
    this.productoRepositorio = productoRepositorio;
  }

  @Override
  public RespuestaServidor guardarBoleta(BoletaCabecera boleta) throws RemoteException {
    try {
      // Inicia transaction
      ConnectionFactory.getConnection().setAutoCommit(false);
      
      BigDecimal monto = BigDecimal.ZERO;
      
      boleta.setMonto(BigDecimal.ZERO);
      cabeceraRepositorio.guardar(boleta);
    
      for (BoletaDetalle detalle : boleta.getBoletaDetalleList()) {

        detalle.setBoletaCabecera(boleta);
        detalleRepositorio.guardar(detalle);

        Producto producto = productoRepositorio.obtener(detalle.getProducto().getId());
        
        BigDecimal result = producto.getStock().subtract(detalle.getCantidad());
        if (result.doubleValue() < 0) {
          throw new BusinessException("No hay stock suficiente para el producto: " + producto.getNombre());
        }
        
        monto = monto.add(detalle.getPrecio().multiply(detalle.getCantidad()));
        
        producto.setStock(result);
        productoRepositorio.actualizar(producto);
      }
      
      boleta.setMonto(monto);
      cabeceraRepositorio.actualizar(boleta);
      
      // Commit transaction
      ConnectionFactory.getConnection().commit();
      return RespuestaServidor.getExito("Boleta de venta registrada.");
    } catch (Exception e) {
      // Rollback transaction
      System.out.println("Error: " + e.getMessage());
      try {
        ConnectionFactory.getConnection().rollback();
      } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
      }
      
      String msg = e instanceof BusinessException ? e.getMessage() : "Error al ingresar venta, trasacción anulada.";
      
      return RespuestaServidor.getError(msg);
    }
  }
  
}
