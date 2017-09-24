package Box;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BoxConfig implements MoneyBox {
  private static Properties prop = new Properties();

  public BoxConfig() {
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

  private Map<String, Map<Integer, Integer>> createMapOfCurAndNumOfVal() {
    //load from config file to map, all currencies
    Map<String, Map<Integer, Integer>> currencyMap = new HashMap<>();

    String[] currencies = (prop.getProperty("currency")).split(", ");

    for (String currency : currencies) {
      Map<Integer, Integer> valAndNumMap = new HashMap<>();
      String[] currValues = (prop.getProperty(currency + "value")).split(", ");
      String[] currNums = (prop.getProperty(currency + "number")).split(", ");
      for (int i = 0; i < currValues.length; i++) {
        valAndNumMap.put(Integer.parseInt(currValues[i]), Integer.parseInt(currNums[i]));
      }
      currencyMap.put(currency, valAndNumMap);
    }

    return currencyMap;
  }

  public boolean isEnoughMoney(String enteredCur, Integer enteredAmount) {
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
        //getting logic!!!
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

  public void addNum(String enteredCur, Integer enteredValue, Integer enteredNumber) {
    Map<String, Map<Integer, Integer>> currMap= createMapOfCurAndNumOfVal();

    Map<Integer, Integer> currValAndNum = currMap.get(enteredCur);
    int newNum = enteredNumber + currValAndNum.get(enteredValue);
    currValAndNum.put(enteredValue, newNum);
    String newNumbers = String.valueOf(currValAndNum.values()); //need to testing!!!

    try (FileOutputStream fStream = new FileOutputStream("conf.properties");
         OutputStreamWriter out = new OutputStreamWriter(fStream)) {
      try {
        prop.setProperty(enteredCur + "number", newNumbers);
        prop.store(out, null);
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
