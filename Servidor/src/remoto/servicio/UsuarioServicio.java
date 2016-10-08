package remoto.servicio;

import java.rmi.Remote;
import java.rmi.RemoteException;
import remoto.entidad.Usuario;

public interface UsuarioServicio extends Remote {

  public Boolean esUsuarioValido(Usuario usuario) throws RemoteException;

}