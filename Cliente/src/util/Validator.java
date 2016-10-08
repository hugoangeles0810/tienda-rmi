package util;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validator {
  
  public static Boolean esEnteroPositivo(String numStr) {
    try {
      Integer number = Integer.parseInt(numStr);
      return number > 0;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  
  public static Boolean isEmpty(String str) {
    return str.equals("");
  }
  
  public static Boolean isEmpty(JTextField jTextField) {
    return isEmpty(jTextField.getText());
  }
  
  public static Boolean isEmpty(JPasswordField jPasswordField) {
    return isEmpty(new String(jPasswordField.getPassword()));
  }
  
  public static Boolean areEquals(String str1, String str2) {
    return str1.equals(str2);
  }
  
  public static Boolean areEquals(JTextField j1, JTextField j2) {
    return areEquals(j1.getText(), j2.getText());
  }
  
  public static Boolean areEquals(JPasswordField jpf1, JPasswordField jpf2) {
    return areEquals(new String(jpf1.getPassword()), new String(jpf2.getPassword()));
  }
    
}

