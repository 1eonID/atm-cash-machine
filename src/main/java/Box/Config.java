package Box;

import java.io.*;
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
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Map<String, Integer> createMapOfCurAndAmount() {
    //load from config file to map, all currencies
    Map<String, Integer> currencyMap = new HashMap<>();
    String[] currencies = (prop.getProperty("currency")).split(", ");
    //search for the rest of the money (all currencies) in the terminal
    for (String currency : currencies) {
      Integer currAmount = Integer.parseInt(prop.getProperty(currency + "amount"));
      currencyMap.put(currency, currAmount);
    }
    return currencyMap;
  }

  boolean isEnoughMoney(String enteredCur, Integer enteredAmount) {
    Map<String, Integer> currencyMap = createMapOfCurAndAmount();

    Integer currAmount = currencyMap.get(enteredCur);

    return currAmount >= enteredAmount;
  }

  public void getAmount(String enteredCur, Integer enteredAmount) {
    Map<String, Integer> currencyMap = createMapOfCurAndAmount();

    Integer currAmount = currencyMap.get(enteredCur);
    int restOfMoney = currAmount - enteredAmount;

    try (FileOutputStream fStream = new FileOutputStream("conf.properties");
         OutputStreamWriter out = new OutputStreamWriter(fStream)) {
      try {
        //getting logic
        prop.setProperty(enteredCur + "amount", String.valueOf(restOfMoney));
        prop.store(out, null);
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addAmount(String enteredCur, Integer enteredValue, Integer enteredNumber) {

  }
}
