package Account;

import Box.Money;
import Box.MoneyBox;

import java.util.Map;
import java.util.HashMap;

/** The Receiver class */
public class UserAccount implements Account {

  private Map<String, AccountOperations> list = createMap();
  private Map<Integer, Integer> usd = new HashMap<>();
  private Map<Integer, Integer> eur = new HashMap<>();
  private Map<Integer, Integer> uah = new HashMap<>();

  MoneyBox money = new Money();

  @Override
  public String addCash(String currency, int value, int number) {
    if (currency.equals("USD")) {
      int tmp = usd.get(value) + number;
      usd.put(value, tmp);
    }
    if (currency.equals("EUR")) {
      int tmp = eur.get(value) + number;
      eur.put(value, tmp);
    }
    if (currency.equals("UAH")) {
      int tmp = uah.get(value) + number;
      uah.put(value, tmp);
    }

    return ("OK" + "\n");
  }

  @Override
  public String getCash(String currency, int amount) {
    String reply = "ERROR";


    return reply;
  }

  @Override
  public String printCashOnCard() {
    String reply = "";

    return reply;
  }

  public boolean contains(Integer key) {
    return usd.containsKey(key);
  }

  private Map<String, AccountOperations> createMap() {
    Map<String, AccountOperations> list = new HashMap<>();
    int n = 0;
    for (int i = 0; i <= 4; i++) {
      n = n + 1;
      usd.put(n, 0);
      eur.put(n, 0);
      uah.put(n, 0);
      n = n * 5;
      usd.put(n, 0);
      eur.put(n, 0);
      uah.put(n, 0);
    }
    list.put("USD", usd);
    list.put("EUR", eur);
    list.put("UAH", uah);

    return list;
  }

}
