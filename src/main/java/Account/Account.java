package Account;

public interface Account {

  String addCash(String currency, int value, int number);

  String getCash(String currency, int amount);

  String printCashOnCard();
}
