package repositorio.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import remoto.entidad.Producto;
import remoto.entidad.Unidad;
import repositorio.ProductoRepositorio;

public class ProductoRepositorioImpl implements ProductoRepositorio{
  
  private Connection connection;

  public ProductoRepositorioImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void guardar(Producto producto) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("insert into productos (nombre, stock, unidad_id) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);

      statement.setString(1, producto.getNombre());
      statement.setBigDecimal(2, producto.getStock());
      statement.setInt(3, producto.getUnidad().getId());

      statement.executeUpdate();

      // Obtener ID generado
      ResultSet rs = statement.getGeneratedKeys();
      if (rs.next()) {
        Integer newId = rs.getInt(1);
        producto.setId(newId);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void actualizar(Producto producto) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("update productos set nombre=?, stock=?, unidad_id=? where id=?");

      statement.setString(1, producto.getNombre());
      statement.setBigDecimal(2, producto.getStock());
      statement.setInt(3, producto.getUnidad().getId());
      statement.setInt(4, producto.getId());

      statement.executeUpdate();

    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void eliminar(Producto producto) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("delete from productos where id=?");

      statement.setInt(1, producto.getId());
      statement.executeUpdate();
      producto.setId(null);
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Producto> listar() {
    List<Producto> productos = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select p.id, p.nombre, p.stock, und.id, und.nombre, und.abreviatura from productos p inner join unidades und on p.unidad_id = und.id");

      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        Producto producto = parseProducto(rs);
        productos.add(producto);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return productos;
  }

  @Override
  public List<Producto> filtrar(Producto producto) {
    List<Producto> productos = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select p.id, p.nombre, p.stock, und.id, und.nombre, und.abreviatura from productos p inner join unidades und on p.unidad_id = und.id where p.nombre like ?");
      
      String nombre = "";
      
      if (producto.getNombre()!= null) {
        nombre = producto.getNombre();
      }
      
      statement.setString(1, "%"+nombre+"%");
      
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        productos.add(parseProducto(rs));
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
    
    return productos;
  }
  
  private Producto parseProducto(ResultSet rs) {
    Producto producto = null;
    try {
      producto = new Producto();
      producto.setId(rs.getInt(1));
      producto.setNombre(rs.getString(2));
      producto.setStock(rs.getBigDecimal(3));
      
      Unidad unidad = new Unidad();
      unidad.setId(rs.getInt(4));
      unidad.setNombre(rs.getString(5));
      unidad.setAbreviatura(rs.getString(5));
      
      producto.setUnidad(unidad);
    } catch (SQLException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    
    return producto;
  }

  @Override
  public Producto buscarPorNombre(String nombre) {
    Producto producto = null;

    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select p.id, p.nombre, p.stock, und.id, und.nombre, und.abreviatura from productos p inner join unidades und on p.unidad_id = und.id where p.nombre=?");

      statement.setString(1, nombre);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        producto = parseProducto(rs);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }

    return producto;
  }

  @Override
  public Producto obtener(Integer id) {
    Producto producto = null;

    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select p.id, p.nombre, p.stock, und.id, und.nombre, und.abreviatura from productos p inner join unidades und on p.unidad_id = und.id where p.id=?");

      statement.setInt(1, id);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        producto = parseProducto(rs);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }

    return producto;
  }
}
