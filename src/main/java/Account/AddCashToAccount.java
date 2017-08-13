package Account;

public class AddCashToAccount {

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
}
