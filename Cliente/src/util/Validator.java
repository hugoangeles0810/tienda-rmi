package util;

public class Validator {
  
  public static Boolean esEnteroPositivo(String numStr) {
    try {
      Integer number = Integer.parseInt(numStr);
      return number > 0;
    } catch (NumberFormatException e) {
      return false;
    }
  }
    
}

