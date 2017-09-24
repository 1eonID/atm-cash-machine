package User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class UserConfig implements User {

  private static Properties prop = new Properties();

  public UserConfig() {
    try (FileInputStream fStream = new FileInputStream("users.properties");
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

  private void rewriteAmount(String enteredCur, int restOfMoney) {

    try (FileOutputStream fStream = new FileOutputStream("users.properties");
         OutputStreamWriter out = new OutputStreamWriter(fStream)) {
      try {
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

  @Override
  public boolean isEnoughMoneyOnAccount(String enteredCur, int enteredAmount) {
    Map<String, Integer> currencyMap = createMapOfCurAndAmount();

    Integer currAmount = currencyMap.get(enteredCur);

    return currAmount >= enteredAmount;
  }

  @Override
  public void addAmount(String enteredCur, int enteredAmount) {
    Map<String, Integer> currencyMap = createMapOfCurAndAmount();

    Integer currAmount = currencyMap.get(enteredCur);
    int restOfMoney = currAmount + enteredAmount;

    rewriteAmount(enteredCur, restOfMoney);
  }

  @Override
  public void getAmount(String enteredCur, int enteredAmount) {
    Map<String, Integer> currencyMap = createMapOfCurAndAmount();

    Integer currAmount = currencyMap.get(enteredCur);
    int restOfMoney = currAmount - enteredAmount;

    rewriteAmount(enteredCur, restOfMoney);
  }

  @Override
  public String printBillState() {
    Map<String, Integer> currencyMap = createMapOfCurAndAmount();

    Set<String> set = currencyMap.keySet();
    String result = "";

    return result;
  }
}
