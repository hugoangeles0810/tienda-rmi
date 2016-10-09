package servidor;

import db.ConnectionFactory;
import java.rmi.NoSuchObjectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import remoto.servicio.ProductoServicio;
import remoto.servicio.UnidadServicio;
import remoto.servicio.UsuarioServicio;
import repositorio.ProductoRepositorio;
import repositorio.UnidadRepositorio;
import repositorio.UsuarioRepositorio;
import repositorio.impl.ProductoRepositorioImpl;
import repositorio.impl.UnidadRepositorioImpl;
import repositorio.impl.UsuarioRepositorioImpl;
import servicio.ProductoServicioImpl;
import servicio.UnidadServicioImpl;
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
      
      UnidadRepositorio unidadRepositorio = new UnidadRepositorioImpl(ConnectionFactory.getConnection());
      UnidadServicio unidadServicio  = new UnidadServicioImpl(unidadRepositorio);
      
      ProductoRepositorio productoRepositorio = new ProductoRepositorioImpl(ConnectionFactory.getConnection());
      ProductoServicio productoServicio  = new ProductoServicioImpl(productoRepositorio);
      
      
      registry = LocateRegistry.createRegistry(parametros.getPortRMI());
      
      registry.bind(usuarioServicio.getClass().getInterfaces()[0].getSimpleName(), usuarioServicio);
      registry.bind(unidadServicio.getClass().getInterfaces()[0].getSimpleName(), unidadServicio);
      registry.bind(productoServicio.getClass().getInterfaces()[0].getSimpleName(), productoServicio);
      
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
