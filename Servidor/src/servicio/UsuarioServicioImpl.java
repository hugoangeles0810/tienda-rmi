package servicio;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import remoto.entidad.Usuario;
import repositorio.UsuarioRepositorio;
import remoto.servicio.UsuarioServicio;

public class UsuarioServicioImpl extends UnicastRemoteObject
                 implements UsuarioServicio {

  private UsuarioRepositorio usuarioRepositorio;

  public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) throws RemoteException {
    super();
    this.usuarioRepositorio = usuarioRepositorio;
  }

  public Boolean esUsuarioValido(Usuario usuario) throws RemoteException {
    Usuario testUser = usuarioRepositorio.obtenerPorLogin(usuario.getUsername());
    return testUser != null && testUser.getPassword().equals(usuario.getPassword());
  }

}