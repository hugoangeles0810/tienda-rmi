package repositorio.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import remoto.entidad.Unidad;
import repositorio.UnidadRepositorio;
import util.BusinessException;
import util.Constantes;

public class UnidadRepositorioImpl implements UnidadRepositorio{
  
  private Connection connection;

  public UnidadRepositorioImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void guardar(Unidad unidad) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("insert into unidades (nombre, abreviatura) values (?,?)", Statement.RETURN_GENERATED_KEYS);

      statement.setString(1, unidad.getNombre());
      statement.setString(2, unidad.getAbreviatura());

      statement.executeUpdate();

      // Obtener ID generado
      ResultSet rs = statement.getGeneratedKeys();
      if (rs.next()) {
        Integer newId = rs.getInt(1);
        unidad.setId(newId);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void actualizar(Unidad unidad) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("update unidades set nombre=?, abreviatura=? where id=?");

      statement.setString(1, unidad.getNombre());
      statement.setString(2, unidad.getAbreviatura());
      statement.setInt(3, unidad.getId());

      statement.executeUpdate();

    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void eliminar(Unidad unidad) throws BusinessException{
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("delete from unidades where id=?");

      statement.setInt(1, unidad.getId());
      statement.executeUpdate();
      unidad.setId(null);
      
    } catch(SQLException e) {
      if (e.getErrorCode() == Constantes.FOREIGN_KEY_VIOLATION) {
        throw new BusinessException("Esta unidad tiene una o más entidades relacionadas asegurese de eliminarlas primero.");
      }
      e.printStackTrace();
      throw new BusinessException("Error al eliminar la unidad.");
    }
  }

  @Override
  public List<Unidad> listar() {
    List<Unidad> unidades = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from unidades");

      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        Unidad unidad = parseUnidad(rs);
        unidades.add(unidad);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return unidades;
  }

  @Override
  public List<Unidad> filtrar(Unidad unidad) {
    List<Unidad> unidades = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from unidades where nombre like ? and abreviatura like ?");
      
      String nombre = "";
      String abreviatura = "";
      
      if (unidad.getNombre()!= null) {
        nombre = unidad.getNombre();
      }
      
      if (unidad.getAbreviatura()!= null) {
        abreviatura = unidad.getAbreviatura();
      }
      
      statement.setString(1, "%"+nombre+"%");
      statement.setString(2, "%"+abreviatura+"%");
      
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        unidades.add(parseUnidad(rs));
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
    
    return unidades;
  }
  
  private Unidad parseUnidad(ResultSet rs) {
    Unidad unidad = null;
    try {
      unidad = new Unidad();
      unidad.setId(rs.getInt(1));
      unidad.setNombre(rs.getString(2));
      unidad.setAbreviatura(rs.getString(3));
    } catch (SQLException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    
    return unidad;
  }

  @Override
  public Unidad buscarPorAbreviatura(String abreviatura) {
    Unidad unidad = null;

    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from unidades where abreviatura=?");

      statement.setString(1, abreviatura);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        unidad = parseUnidad(rs);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }

    return unidad;
  }

  @Override
  public Unidad buscarPorNombre(String nombre) {
    Unidad unidad = null;

    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from unidades where nombre=?");

      statement.setString(1, nombre);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        unidad = parseUnidad(rs);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }

    return unidad;
  }

  @Override
  public Unidad obtener(Integer id) {
    Unidad unidad = null;

    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from unidades where id=?");

      statement.setInt(1, id);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        unidad = parseUnidad(rs);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }

    return unidad;
  }
  
}
