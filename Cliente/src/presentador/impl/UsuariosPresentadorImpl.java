package presentador.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import presentador.UsuariosPresentador;
import remoto.entidad.Usuario;
import remoto.servicio.UsuarioServicio;
import remoto.util.RespuestaServidor;
import rmi.ClienteRMI;
import vista.UsuariosVista;

public class UsuariosPresentadorImpl implements UsuariosPresentador{
  
  private UsuariosVista vista;

  public UsuariosPresentadorImpl(UsuariosVista vista) {
    this.vista = vista;
  }
  
  @Override
  public void buscarUsuarios(Usuario filtro) {
    List<Usuario> usuarios = new ArrayList<>();
    
    UsuarioServicio usuarioServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(UsuarioServicio.class);
    
    try {
      usuarios = usuarioServicio.buscarUsuarios(filtro);
    } catch (RemoteException|NullPointerException e) {}
    
    vista.mostrarUsuarios(usuarios);
  }

  @Override
  public void guardarUsuario(Usuario usuario) {
    UsuarioServicio usuarioServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(UsuarioServicio.class); 
    
    try {
      RespuestaServidor respuestaServidor;
      if (usuario.getId() == null) {
        respuestaServidor = usuarioServicio.guardarUsuario(usuario);
      } else {
        respuestaServidor = usuarioServicio.actualizarUsuario(usuario);
      }
      
      if (respuestaServidor.esExito()) {
        vista.onActionSuccess(respuestaServidor.getMsg());
      } else {
        vista.onActionFailed(respuestaServidor.getMsg());
      }
    } catch (RemoteException|NullPointerException ex) {
      vista.showError("Error al conectar con el servidor");
    } 
  }

  @Override
  public void eliminarUsuario(Usuario usuario) {
    UsuarioServicio usuarioServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(UsuarioServicio.class); 
    
    try {
      RespuestaServidor respuestaServidor = usuarioServicio.eliminarUsuario(usuario);
      if (respuestaServidor.esExito()) {
        vista.onActionSuccess(respuestaServidor.getMsg());
      } else {
        vista.onActionFailed(respuestaServidor.getMsg());
      }
    } catch (RemoteException|NullPointerException ex) {
      vista.showError("Error al conectar con el servidor");
    }
  }

  @Override
  public void buscarPorId(Integer id) {
    UsuarioServicio usuarioServicio = ClienteRMI
                                        .getInstance()
                                        .obtenerServicio(UsuarioServicio.class);
    try {
      Usuario usuario = usuarioServicio.obtener(id);
      if (usuario != null) {
        vista.onUsuarioSelected(usuario);
      } else {
        vista.showError("El usuario seleccionado ya no está registrado.");
      }
    } catch (RemoteException|NullPointerException ex) {
      vista.showError("Error al conectar con el servidor.");
    }
  }
  
}
