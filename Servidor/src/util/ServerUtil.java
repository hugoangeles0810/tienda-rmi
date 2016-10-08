package util;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class ServerUtil {
  
  public static final int MIN_PORT_NUMBER = 1092;
  public static final int MAX_PORT_NUMBER = 49151;

  public static boolean portAvailable(int port) {
    if (port < MIN_PORT_NUMBER || port > MAX_PORT_NUMBER) {
        return false;
    }

    ServerSocket ss = null;
    DatagramSocket ds = null;
    try {
        ss = new ServerSocket(port);
        ss.setReuseAddress(true);
        ds = new DatagramSocket(port);
        ds.setReuseAddress(true);
        return true;
    } catch (IOException e) {
    } finally {
        if (ds != null) {
            ds.close();
        }

        if (ss != null) {
            try {
                ss.close();
            } catch (IOException e) {}
        }
    }

    return false;
  }
}
