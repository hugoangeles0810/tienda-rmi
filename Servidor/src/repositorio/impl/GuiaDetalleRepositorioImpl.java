package repositorio.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import remoto.entidad.GuiaDetalle;
import remoto.entidad.Producto;
import remoto.entidad.Unidad;
import repositorio.GuiaDetalleRepositorio;

public class GuiaDetalleRepositorioImpl implements GuiaDetalleRepositorio{

  private Connection connection;

  public GuiaDetalleRepositorioImpl(Connection connection) {
    this.connection = connection;
  }
  
  @Override
  public void guardar(GuiaDetalle detalle) {
    try {
      String query = "insert into guia_detalles (producto_id, cantidad, cabecera_id) values (?,?,?)";
      PreparedStatement statement = this.connection
                  .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      
      statement.setInt(1, detalle.getProducto().getId());
      statement.setBigDecimal(2, detalle.getCantidad());
      statement.setInt(3, detalle.getGuiaCabecera().getId());
        
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
  public List<GuiaDetalle> obtenerPorCabecera(Integer guiaId) {
    List<GuiaDetalle> detalles = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select "
                  + " gd.id, gd.cantidad, p.id, p.nombre, und.id, und.nombre, und.abreviatura " 
                  + " from guia_detalles gd " 
                  + " inner join productos p on p.id = gd.producto_id "
                  + " inner join unidad und on und.id = p.unidad_id "
                  + " where gd.cabecera_id=?");
      
      
      statement.setInt(1, guiaId);
      
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        GuiaDetalle detalle = new GuiaDetalle();
        detalle.setId(rs.getInt(1));
        detalle.setCantidad(rs.getBigDecimal(2));
        
        Producto producto = new Producto();
        producto.setId(rs.getInt(3));
        producto.setNombre(rs.getString(4));
        
        Unidad unidad = new Unidad();
        unidad.setId(rs.getInt(5));
        unidad.setNombre(rs.getString(6));
        unidad.setAbreviatura(rs.getString(7));
        
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
