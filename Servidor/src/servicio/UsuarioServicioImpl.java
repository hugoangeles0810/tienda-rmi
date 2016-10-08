package servicio;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import remoto.entidad.Usuario;
import repositorio.UsuarioRepositorio;
import remoto.servicio.UsuarioServicio;
import remoto.util.RespuestaServidor;

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

  @Override
  public List<Usuario> buscarUsuarios(Usuario usuario) throws RemoteException {
    return usuarioRepositorio.filtrar(usuario);
  }

  @Override
  public RespuestaServidor guardarUsuario(Usuario usuario) throws RemoteException {
    if (!esDuplicado(usuario)) {
      usuarioRepositorio.guardar(usuario);
      return RespuestaServidor.getExito("Usuario registrado existosamente.");
    } else {
      return RespuestaServidor.getError("El username ingresado ya está registrado.");
    }
  }
  
  private Boolean esDuplicado(Usuario usuario) {
    Usuario userFlag = usuarioRepositorio.obtenerPorLogin(usuario.getUsername());
    
    return userFlag != null && !userFlag.getId().equals(usuario.getId());
  }

  @Override
  public RespuestaServidor actualizarUsuario(Usuario usuario) throws RemoteException {
    if (!esDuplicado(usuario)) {
      usuarioRepositorio.actualizar(usuario);
      return RespuestaServidor.getExito("Usuario actualizado existosamente.");
    } else {
      return RespuestaServidor.getError("El username ingresado no está disponible.");
    }
  }

  @Override
  public RespuestaServidor eliminarUsuario(Usuario usuario) throws RemoteException {
    try {
      usuarioRepositorio.eliminar(usuario);
      return RespuestaServidor.getExito("Usuario elimnado.");
    } catch(Exception e) {
      return RespuestaServidor.getError("Error al eliminar el usuario.");
    }
  }
}