package Box;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Config {
  FileInputStream fileInputStream;
  Properties prop = new Properties();

  try {
    fileInputStream = new FileInputStream("conf.properties");
    prop.load(fileInputStream);

    String currency = prop.getProperty("currency");
    String value = prop.getProperty("value");

  } catch (IOException e) {
    e.printStackTrace();
  }
}
