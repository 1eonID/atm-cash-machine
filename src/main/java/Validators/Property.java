package Validators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Property {
  private Properties properties = new Properties();

  public Property() {
    try (FileInputStream fStream = new FileInputStream("prop.properties");
         InputStreamReader in = new InputStreamReader(fStream)) {

      try {
        properties.load(in);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

