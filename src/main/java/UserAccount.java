import java.util.Map;
import java.util.HashMap;

/** The Receiver class */
public class UserAccount implements Account {

  private Map<String, Map<Integer, Integer>> list = new HashMap<>();
  private Map<Integer, Integer> usd = new HashMap<>();
  private Map<Integer, Integer> eur = new HashMap<>();
  private Map<Integer, Integer> uah = new HashMap<>();
  initMap();

  MoneyBox money = new Money();

  @Override
  public String addCash(String currency, int value, int number) {
    String reply = "ERROR";


    return reply;
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

  private void initMap() {
    int n = 0;
    for (int i = 1; i <= 5000; ) {
      if (n < 4) {
        i = (int) Math.pow(10, n);
        usd.put(i, 0);
        eur.put(i, 0);
        uah.put(i, 0);
      }
      i = i * 5;
      usd.put(i, 0);
      eur.put(i, 0);
      uah.put(i, 0);
      n++;
    }
    list.put("USD", usd);
    list.put("EUR", eur);
    list.put("UAH", uah);
  }

}
