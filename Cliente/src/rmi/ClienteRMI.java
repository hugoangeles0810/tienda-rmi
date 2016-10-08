package rmi;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteRMI {
  
  private Registry registry;

  public ClienteRMI(String direccion, Integer puerto) {
    try {
      registry = LocateRegistry.getRegistry(direccion, puerto);
    } catch (RemoteException ex) {
      Logger.getLogger(ClienteRMI.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public  <T extends Remote> T obtenerServicio(Class<T> clazz) {
    try {
      return (T) registry.lookup(clazz.getSimpleName());
    } catch (RemoteException ex) {
      System.out.println("Error: " + ex.getMessage());
    } catch (NotBoundException ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    return null;
  }
  
  public static ClienteRMI getInstance(String direccion, Integer puerto) {
    return new ClienteRMI(direccion, puerto);
  }
  
}
