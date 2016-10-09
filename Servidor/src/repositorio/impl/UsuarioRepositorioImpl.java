package repositorio.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import remoto.entidad.Usuario;
import repositorio.UsuarioRepositorio;

public class UsuarioRepositorioImpl implements UsuarioRepositorio {

  private Connection connection;

  public UsuarioRepositorioImpl(Connection connection) {
    this.connection = connection;
  }

  public void guardar(Usuario usuario) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("insert into usuarios (username, password) values (?,?)", Statement.RETURN_GENERATED_KEYS);

      statement.setString(1, usuario.getUsername());
      statement.setString(2, usuario.getPassword());

      statement.executeUpdate();

      // Obtener ID generado
      ResultSet rs = statement.getGeneratedKeys();
      if (rs.next()) {
        Integer newId = rs.getInt(1);
        usuario.setId(newId);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }

  }

  public void actualizar(Usuario usuario) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("update usuarios set username=?, password=? where id=?");

      statement.setString(1, usuario.getUsername());
      statement.setString(2, usuario.getPassword());
      statement.setInt(3, usuario.getId());

      statement.executeUpdate();

    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public void eliminar(Usuario usuario) {
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("delete from usuarios where id=?");

      statement.setInt(1, usuario.getId());
      statement.executeUpdate();
      usuario.setId(null);

    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Usuario> listar() {
    List<Usuario> usuarios = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from usuarios");

      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        Usuario usuario = parseUsuario(rs);
        usuarios.add(usuario);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

  public Usuario obtenerPorLogin(String login) {
    Usuario usuario = null;

    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from usuarios where username=?");

      statement.setString(1, login);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        usuario = parseUsuario(rs);
      }

    } catch(SQLException e) {
      e.printStackTrace();
    }

    return usuario;
  }

  @Override
  public List<Usuario> filtrar(Usuario usuario) {
    List<Usuario> usuarios = new ArrayList<>();
    try {
      PreparedStatement statement = this.connection
                .prepareStatement("select * from usuarios where username like ?");
      
      String username = "";
      if (usuario.getUsername() != null) {
        username = usuario.getUsername();
      }
      
      statement.setString(1, "%"+username+"%");
      
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        usuarios.add(parseUsuario(rs));
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    }
    
    return usuarios;
  }
  
  private Usuario parseUsuario(ResultSet rs) {
    Usuario usuario = null;
    try {
      usuario = new Usuario();
      usuario.setId(rs.getInt(1));
      usuario.setUsername(rs.getString(2));
      usuario.setPassword(rs.getString(3));
    } catch (SQLException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    
    return usuario;
  }

}