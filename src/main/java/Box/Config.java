package Box;

public class Config {
  Properties properties = new Properties();
try {
    properties.load(new FileInputStream("path/filename"));
  } catch (IOException e) {
  ...
  }

  for(String key : properties.stringPropertyNames()) {
    String value = properties.getProperty(key);
    System.out.println(key + " => " + value);
  }
}
