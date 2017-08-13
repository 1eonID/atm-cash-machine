package Box;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Config {
  private Properties properties = new Properties();

  public Config() {
    try (FileInputStream fStream = new FileInputStream("conf.properties");
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
