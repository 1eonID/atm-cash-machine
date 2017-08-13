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
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  boolean isValid(String[] args) {
    //load from property file to map, properties of valid currencies and values to each currencies
    Map<String, Integer> currencyMap = new HashMap<>();
    String[] currencies = (prop.getProperty("currency")).split(", ");
    //each values of each currencies
    for (String currency : currencies) {
      String[] currValue = (prop.getProperty(currency)).split(", ");
      for (String value : currValue) {
        currencyMap.put(currency, Integer.parseInt(value));
      }
    }

    if (args[2].matches("\\d+")) {
      Integer key = Integer.parseInt(args[2]);
    }

      return false;
  }
}

