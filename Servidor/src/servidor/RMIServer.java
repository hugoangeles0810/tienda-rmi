package servidor;

import db.ConnectionFactory;
import java.rmi.NoSuchObjectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import remoto.servicio.GuiaServicio;
import remoto.servicio.ProductoServicio;
import remoto.servicio.UnidadServicio;
import remoto.servicio.UsuarioServicio;
import repositorio.GuiaCabeceraRepositorio;
import repositorio.GuiaDetalleRepositorio;
import repositorio.ProductoRepositorio;
import repositorio.UnidadRepositorio;
import repositorio.UsuarioRepositorio;
import repositorio.impl.GuiaCabeceraRepositorioImpl;
import repositorio.impl.GuiaDetalleRepositorioImpl;
import repositorio.impl.ProductoRepositorioImpl;
import repositorio.impl.UnidadRepositorioImpl;
import repositorio.impl.UsuarioRepositorioImpl;
import servicio.GuiaServicioImpl;
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
      
      GuiaCabeceraRepositorio guiaCabeceraRepositorio = new GuiaCabeceraRepositorioImpl(ConnectionFactory.getConnection());
      GuiaDetalleRepositorio guiaDetalleRepositorio = new GuiaDetalleRepositorioImpl(ConnectionFactory.getConnection());
      GuiaServicio guiaServicio = new GuiaServicioImpl(guiaCabeceraRepositorio, guiaDetalleRepositorio, productoRepositorio);
      
      registry = LocateRegistry.createRegistry(parametros.getPortRMI());
      
      registry.bind(usuarioServicio.getClass().getInterfaces()[0].getSimpleName(), usuarioServicio);
      registry.bind(unidadServicio.getClass().getInterfaces()[0].getSimpleName(), unidadServicio);
      registry.bind(productoServicio.getClass().getInterfaces()[0].getSimpleName(), productoServicio);
      registry.bind(guiaServicio.getClass().getInterfaces()[0].getSimpleName(), guiaServicio);
      
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
