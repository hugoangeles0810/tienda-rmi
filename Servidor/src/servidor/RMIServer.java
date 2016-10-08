package servidor;

import db.ConnectionFactory;
import java.rmi.NoSuchObjectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import remoto.servicio.UsuarioServicio;
import repositorio.UsuarioRepositorio;
import repositorio.impl.UsuarioRepositorioImpl;
import servicio.UsuarioServicioImpl;
import util.Parametros;

public class RMIServer {
  private Registry registry;

  public RMIServer() {
  }

  public void iniciarServidor(Parametros parametros) {
    try {
      ConnectionFactory.setParametros(parametros);
      UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorioImpl(ConnectionFactory.getConnection());
      UsuarioServicio usuarioServicio = new UsuarioServicioImpl(usuarioRepositorio);
      
      
      registry = LocateRegistry.createRegistry(parametros.getPortRMI());
      System.out.println(usuarioServicio.getClass().getInterfaces()[0].getSimpleName());
      registry.bind(usuarioServicio.getClass().getInterfaces()[0].getSimpleName(), usuarioServicio);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public void detenerServidor() {
    if (registry != null) {
      try {
        UnicastRemoteObject.unexportObject(registry, true);
        registry = null;
      } catch (NoSuchObjectException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }

}
