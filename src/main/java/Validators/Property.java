package Validators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Property {
  private Properties prop = new Properties();

  Property() {
    try (FileInputStream fStream = new FileInputStream("prop.properties");
         InputStreamReader in = new InputStreamReader(fStream)) {
      try {
        prop.load(in);
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  boolean isValid(String[] args) {
    //load from property file to map, properties of valid currencies and values to each currencies
    Map<String, String[]> currencyMap = new HashMap<>();
    String[] currencies = (prop.getProperty("currency")).split(", ");
    //each values of each currencies
    for (String currency : currencies) {
      String[] currValue = (prop.getProperty(currency)).split(", ");
      currencyMap.put(currency, currValue);
    }

    if (args[2].matches("\\d+")) {
      Integer key = Integer.parseInt(args[2]);
      String[] currValues = currencyMap.get(args[1]);
      if (currValues.)
    }

      return false;
  }
}

