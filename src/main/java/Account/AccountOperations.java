package Account;

public class AccountOperations {

  public String addCashToAccount(String currency, int value, int number) {
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

  public String getCashFromAccount(String currency, int amount) {

    return "OK";
  }

  public String printCashOnAccount() {
    String reply = "";

    return reply;
  }

}
