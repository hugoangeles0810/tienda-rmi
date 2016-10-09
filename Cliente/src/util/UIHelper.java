package util;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UIHelper {
  
  public static Boolean confirm(Component cmp, String msg) {
    int res = JOptionPane.showConfirmDialog(cmp, msg);
    return res == JOptionPane.OK_OPTION;
  }
  
  public static Boolean confirmDetele(Component cmp) {
    int res = JOptionPane.showConfirmDialog(cmp, "¿Seguro que quieres eliminar el registro?");
    return res == JOptionPane.OK_OPTION;
  }
  
  public static void showInfo(Component cmp, String msg) {
    JOptionPane.showMessageDialog(cmp, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void showError(Component cmp, String msg) {
    JOptionPane.showMessageDialog(cmp, msg, "Error", JOptionPane.ERROR_MESSAGE);
  }
  
  public static void removeRowsOfTable(DefaultTableModel model) {
    for (int k = 0; k < model.getRowCount(); k++) {
      model.removeRow(0);
      k--;
    }
  }
  
  public static void nuevo(JButton btnNuevo, JButton btnGuardar, JButton btnModificar, JButton btnEliminar, JButton btnCancelar) {
    btnNuevo.setEnabled(false);
    btnGuardar.setEnabled(true);
    btnModificar.setEnabled(false);
    btnEliminar.setEnabled(false);
    btnCancelar.setEnabled(true);
  }
  
  public static void cancelar(JButton btnNuevo, JButton btnGuardar, JButton btnModificar, JButton btnEliminar, JButton btnCancelar) {
    btnNuevo.setEnabled(true);
    btnGuardar.setEnabled(false);
    btnModificar.setEnabled(false);
    btnEliminar.setEnabled(false);
    btnCancelar.setEnabled(false);
  }
  
  public static void seleccionar(JButton btnNuevo, JButton btnGuardar, JButton btnModificar, JButton btnEliminar, JButton btnCancelar) {
    btnNuevo.setEnabled(false);
    btnGuardar.setEnabled(false);
    btnModificar.setEnabled(true);
    btnEliminar.setEnabled(true);
    btnCancelar.setEnabled(true);
  }
  
  public static void modificar(JButton btnNuevo, JButton btnGuardar, JButton btnModificar, JButton btnEliminar, JButton btnCancelar) {
    btnNuevo.setEnabled(false);
    btnGuardar.setEnabled(true);
    btnModificar.setEnabled(false);
    btnEliminar.setEnabled(false);
    btnCancelar.setEnabled(true);
  }
  
}
