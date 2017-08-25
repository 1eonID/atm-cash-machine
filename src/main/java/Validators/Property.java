package Validators;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Property {
  private static Properties prop = new Properties();

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

  boolean currencyIsValid(String enteredCur) {
    //load from property file to map, properties of valid currencies
    String[] currencies = (prop.getProperty("currency")).split(", ");

    for (String currency : currencies) {
        if (currency.equals(enteredCur)) {
          return true;
        }
    }
    return false;
  }

  boolean valueIsValid(String enteredCur, Integer enteredValue) {
    //load from property file to map, properties of valid currencies and values to each currencies
    Map<String, String[]> currencyMap = new HashMap<>();
    String[] currencies = (prop.getProperty("currency")).split(", ");
    //each values of each currencies
    for (String currency : currencies) {
      String[] currValue = (prop.getProperty(currency)).split(", ");
      currencyMap.put(currency, currValue);
    }

    String[] currValues = currencyMap.get(enteredCur);
    for (String value : currValues) {
      if (Integer.parseInt(value) == enteredValue) {
        return true;
      }
    }
    return false;
  }
}

