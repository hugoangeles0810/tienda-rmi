package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.Parametros;

public class ConnectionFactory {
  
  private static Connection connection = null;
  private static Parametros parametros = null;

  public static void setParametros(Parametros params) {
    parametros = params;
  }

  public static Connection getConnection() {
    try {

      if (connection == null || connection.isClosed()) {
        String driver = "com.mysql.jdbc.Driver";
        String host = parametros.getHostDB();
        Integer port = parametros.getPortDB();
        String user = parametros.getUserDB();
        String pass = parametros.getPassDB();
        String database = parametros.getNameDB();
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false";

        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, pass);
      }

    } catch(ClassNotFoundException e) {
      connection = null;
      e.printStackTrace();
    } catch(SQLException e) {
      connection = null;
      e.printStackTrace();
    }

    return connection;
  }

  public static Boolean testConnection() {
    Boolean isConnected = false;
    Connection conTest = null;
    try {
      String driver = "com.mysql.jdbc.Driver";
      String host = parametros.getHostDB();
      Integer port = parametros.getPortDB();
      String user = parametros.getUserDB();
      String pass = parametros.getPassDB();
      String database = parametros.getNameDB();
      String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false";

      Class.forName(driver);
      conTest = DriverManager.getConnection(url, user, pass);
      
      isConnected = conTest != null && !conTest.isClosed();
    } catch(ClassNotFoundException e) {
      isConnected = false;
      e.printStackTrace();
    } catch(SQLException e) {
      isConnected = false;
      e.printStackTrace();
    }

    return isConnected;
  }

}
