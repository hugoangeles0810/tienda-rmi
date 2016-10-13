package repositorio.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import remoto.entidad.BoletaDetalle;
import remoto.entidad.Producto;
import remoto.entidad.Unidad;
import repositorio.BoletaDetalleRepositorio;

public class BoletaDetalleRepositorioImpl implements BoletaDetalleRepositorio{

  private Connection connection;

  public BoletaDetalleRepositorioImpl(Connection connection) {
    this.connection = connection;
  }
  
  @Override
  public void guardar(BoletaDetalle detalle) {
    try {
      String query = "insert into boleta_detalles (producto_id, cantidad, precio, cabecera_id) values (?,?,?,?)";
      PreparedStatement statement = this.connection
                  .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      
      statement.setInt(1, detalle.getProducto().getId());
      statement.setBigDecimal(2, detalle.getCantidad());
      statement.setBigDecimal(3, detalle.getPrecio());
      statement.setInt(4, detalle.getBoletaCabecera().getId());
        
      statement.executeUpdate();
      
      // Obtener ID generado
      ResultSet rs = statement.getGeneratedKeys();
      if (rs.next()) {
        Integer newId = rs.getInt(1);
        detalle.setId(newId);
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<BoletaDetalle> obtenerPorCabecera(Integer id) {
    List<BoletaDetalle> detalles = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select "
                  + " bd.id, bd.cantidad, bd.precio, p.id, p.nombre, und.id, und.nombre, und.abreviatura " 
                  + " from boleta_detalles bd " 
                  + " inner join productos p on p.id = bd.producto_id "
                  + " inner join unidad und on und.id = p.unidad_id "
                  + " where bd.cabecera_id=?");
      
      
      statement.setInt(1, id);
      
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        BoletaDetalle detalle = new BoletaDetalle();
        detalle.setId(rs.getInt(1));
        detalle.setCantidad(rs.getBigDecimal(2));
        detalle.setPrecio(rs.getBigDecimal(3));
        
        Producto producto = new Producto();
        producto.setId(rs.getInt(4));
        producto.setNombre(rs.getString(5));
        
        Unidad unidad = new Unidad();
        unidad.setId(rs.getInt(6));
        unidad.setNombre(rs.getString(7));
        unidad.setAbreviatura(rs.getString(8));
        
        producto.setUnidad(unidad);
        
        detalle.setProducto(producto);
        
        detalles.add(detalle);
        
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
    
    return detalles;
  }
  
}
