package user;

public interface User {

  boolean isEnoughMoneyOnAccount(String currency, int amount);

  void addAmount(String currency, int amount);

  void getAmount(String currency, int amount);

  String printBillState();

}
