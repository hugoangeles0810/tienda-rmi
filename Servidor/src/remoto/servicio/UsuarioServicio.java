package remoto.servicio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import remoto.entidad.Usuario;
import remoto.util.RespuestaServidor;

public interface UsuarioServicio extends Remote {

  public Boolean esUsuarioValido(Usuario usuario) throws RemoteException;
  public List<Usuario> buscarUsuarios(Usuario usuario) throws RemoteException;
  public RespuestaServidor guardarUsuario(Usuario usuario) throws RemoteException;
  public RespuestaServidor actualizarUsuario(Usuario usuario) throws RemoteException;
  public RespuestaServidor eliminarUsuario(Usuario usuario) throws RemoteException;

}