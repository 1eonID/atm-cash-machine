package Box;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config {
  private static Properties prop = new Properties();

  public Config() {
    try (FileInputStream fStream = new FileInputStream("conf.properties");
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

  boolean isEnoughMoney(String enteredCur, Integer enteredAmount) {
    //load from config file to map, all currencies
    Map<String, Integer> currencyMap = new HashMap<>();
    String[] currencies = (prop.getProperty("currency")).split(", ");
    //search for the rest of the money (all currencies) in the terminal
    for (String currency : currencies) {
      Integer currAmount = Integer.parseInt(prop.getProperty(currency + "amount"));
      currencyMap.put(currency, currAmount);
    }

    Integer currAmount = currencyMap.get(enteredCur);

    return currAmount >= enteredAmount;
  }

  public void getAmount(String enteredCur, Integer enteredAmount) {

  }

  public void addAmount(String enteredCur, Integer value, Integer number) {

  }
}
