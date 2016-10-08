import javax.swing.UIManager;
import ui.FramePrincipal;

public class Main {

  public static void main(String args[]) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      new FramePrincipal();

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
