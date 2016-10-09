package repositorio.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import remoto.entidad.GuiaCabecera;
import repositorio.GuiaCabeceraRepositorio;

public class GuiaCabeceraRepositorioImpl implements GuiaCabeceraRepositorio{

  private Connection connection;

  public GuiaCabeceraRepositorioImpl(Connection connection) {
    this.connection = connection;
  }
  
  @Override
  public void guardar(GuiaCabecera guiaCabecera) {
    try {
      String query = "insert into guia_cabeceras (numero, fecha) values (?,?)";
      PreparedStatement statement = this.connection
                  .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      
      statement.setString(1, guiaCabecera.getNumero());
      statement.setDate(2, new java.sql.Date(new Date().getTime()));
      
      statement.executeUpdate();
      
      // Obtener ID generado
      ResultSet rs = statement.getGeneratedKeys();
      if (rs.next()) {
        Integer newId = rs.getInt(1);
        guiaCabecera.setId(newId);
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<GuiaCabecera> filtrar(GuiaCabecera guiaCabecera) {
    List<GuiaCabecera> guias = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from guia_cabeceras where numero like ?");
      
      String numero = "";
      
      if (guiaCabecera.getNumero() != null) {
        numero = guiaCabecera.getNumero();
      }
      
      statement.setString(1, "%"+numero+"%");
      
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        guias.add(parseProducto(rs));
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
    
    return guias;
  }
  
  private GuiaCabecera parseProducto(ResultSet rs) {
    GuiaCabecera guia = null;
    try {
      guia = new GuiaCabecera();
      guia.setId(rs.getInt(1));
      guia.setNumero(rs.getString(2));
      guia.setFecha(rs.getDate(3));
    } catch (SQLException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    
    return guia;
  }
  
}
