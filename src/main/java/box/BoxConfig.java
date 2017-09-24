package box;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class BoxConfig implements MoneyBox {
  private static Properties prop = new Properties();

  /**read properties from file to Properties object.*/
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
      Map<Integer, Integer> valAndNumMap = new TreeMap<>(); // use TreeMap for right order
      String[] currValues = (prop.getProperty(currency + "value")).split(", ");
      String[] currNums = (prop.getProperty(currency + "number")).split(", ");
      for (int i = 0; i < currValues.length; i++) {
        valAndNumMap.put(Integer.parseInt(currValues[i]), Integer.parseInt(currNums[i]));
      }
      currencyMap.put(currency, valAndNumMap);
    }

    return currencyMap;
  }

  private String getFromMap(Integer enteredAmount, Map<Integer, Integer> map) {
    StringBuilder result = new StringBuilder();
    List<Integer> vals = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();

    for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
      vals.add(pair.getKey());
      nums.add(pair.getValue());
    }

    for (int i = vals.size() - 1; i >= 0; i--) {
      int val = vals.get(i);
      int num = nums.get(i);
      if (val > enteredAmount) {
        continue;
      } else if (val == enteredAmount) {
        num--;
        nums.set(i, num);
        break;
      } else {
        while (enteredAmount >= val) {
          enteredAmount -= val;
          num--;
        }
        nums.set(i, num);
      }
    }

    for (int num: nums) {
      result.append(String.valueOf(num)).append(", ");
    }
    return result.toString();
  }

  private void rewriteNumAndAmount(String enteredCur, String newNumbers, int newAmount) {
    try (FileOutputStream fStream = new FileOutputStream("conf.properties");
         OutputStreamWriter out = new OutputStreamWriter(fStream)) {
      try {
        // change property "number"
        prop.setProperty(enteredCur + "number", newNumbers);
        // change property "amount"
        prop.setProperty(enteredCur + "amount", String.valueOf(newAmount));
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
  public boolean isEnoughMoney(String enteredCur, Integer enteredAmount) {
    Map<String, Map<Integer, Integer>> currMap = createMapOfCurAndNumOfVal();

    Map<Integer, Integer> currValAndNum = currMap.get(enteredCur);

    for (Map.Entry<Integer, Integer> value : currValAndNum.entrySet()) {
      if (value.getValue() < 4) {
        return false;
      }
    }

    Map<String, Integer> currencyMap = createMapOfCurAndAmount();

    Integer currAmount = currencyMap.get(enteredCur);

    return currAmount >= enteredAmount;
  }

  @Override
  public void getAmount(String enteredCur, Integer enteredAmount) {
    Map<String, Map<Integer, Integer>> currMap = createMapOfCurAndNumOfVal();
    Map<Integer, Integer> currValAndNum = currMap.get(enteredCur);

    //change number property
    String restOfNumber = getFromMap(enteredAmount, currValAndNum);

    //change amount property
    Map<String, Integer> currencyMap = createMapOfCurAndAmount();
    Integer currAmount = currencyMap.get(enteredCur);
    int restOfAmount = currAmount - enteredAmount;

    rewriteNumAndAmount(enteredCur, restOfNumber, restOfAmount);
  }

  @Override
  public void addNum(String enteredCur, Integer enteredValue, Integer enteredNumber) {
    Map<String, Map<Integer, Integer>> currMap = createMapOfCurAndNumOfVal();
    Map<Integer, Integer> currValAndNum = currMap.get(enteredCur);

    //change value of parameter "number"
    int newNum = enteredNumber + currValAndNum.get(enteredValue);
    currValAndNum.put(enteredValue, newNum);

    StringBuilder newNumbers = new StringBuilder();
    for (Map.Entry<Integer, Integer> value : currValAndNum.entrySet()) {
      newNumbers.append(value.getValue()).append(", ");
    }

    Map<String, Integer> currencyMap = createMapOfCurAndAmount();
    Integer currAmount = currencyMap.get(enteredCur);
    //change value of parameter "amount"
    int newAmount = currAmount + (enteredValue * enteredNumber);


    rewriteNumAndAmount(enteredCur, newNumbers.toString(), newAmount);
  }
}
