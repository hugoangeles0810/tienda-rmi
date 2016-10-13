package repositorio.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import remoto.entidad.BoletaCabecera;
import repositorio.BoletaCabeceraRepositorio;

public class BoletaCabeceraRepositorioImpl implements BoletaCabeceraRepositorio{

   private Connection connection;
  
  public BoletaCabeceraRepositorioImpl(Connection connection) {
    this.connection = connection;
  }
  
  @Override
  public void guardar(BoletaCabecera boletaCabecera) {
    try {
      String query = "insert into boleta_cabeceras (cliente, direccion, monto, fecha) values (?,?,?,?)";
      PreparedStatement statement = this.connection
                  .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      
      statement.setString(1, boletaCabecera.getCliente());
      statement.setString(2, boletaCabecera.getDireccion());
      statement.setBigDecimal(3, boletaCabecera.getMonto());
      statement.setDate(4, new java.sql.Date(new Date().getTime()));
      
      statement.executeUpdate();
      
      // Obtener ID generado
      ResultSet rs = statement.getGeneratedKeys();
      if (rs.next()) {
        Integer newId = rs.getInt(1);
        boletaCabecera.setId(newId);
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<BoletaCabecera> filtrar(BoletaCabecera boletaCabecera) {
    List<BoletaCabecera> boletas = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from boleta_cabeceras where cliente like ?");
      
      String cliente = "";
      
      if (boletaCabecera.getCliente()!= null) {
        cliente = boletaCabecera.getCliente();
      }
      
      statement.setString(1, "%"+cliente+"%");
      
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        boletas.add(parseBoleta(rs));
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
    
    return boletas;
  }
  
  private BoletaCabecera parseBoleta(ResultSet rs) {
    BoletaCabecera boleta = null;
    try {
      boleta = new BoletaCabecera();
      boleta.setId(rs.getInt(1));
      boleta.setCliente(rs.getString(2));
      boleta.setDireccion(rs.getString(3));
      boleta.setMonto(rs.getBigDecimal(4));
      boleta.setFecha(rs.getDate(5));
    } catch (SQLException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    
    return boleta;
  }

  @Override
  public void actualizar(BoletaCabecera boletaCabecera) {
    try {
      String query = "update boleta_cabeceras set cliente=?, direccion=?, monto=? where id=?";
      PreparedStatement statement = this.connection
                  .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      
      statement.setString(1, boletaCabecera.getCliente());
      statement.setString(2, boletaCabecera.getDireccion());
      statement.setBigDecimal(3, boletaCabecera.getMonto());
      statement.setInt(4, boletaCabecera.getId());
      
      statement.executeUpdate();
      
      // Obtener ID generado
      ResultSet rs = statement.getGeneratedKeys();
      if (rs.next()) {
        Integer newId = rs.getInt(1);
        boletaCabecera.setId(newId);
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
  
}
