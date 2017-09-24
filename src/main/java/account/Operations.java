package Account;

public interface Operations {

  String addCashToAccount(String currency, int value, int number);

  String getCashFromAccount(String currency, int amount);

  String printBillStateOnAccount();

}
