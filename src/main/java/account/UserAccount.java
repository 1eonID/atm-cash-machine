package Account;

/* The Receiver class */
public class UserAccount implements Account {

  private Operations oper = new AccountOperations();

  @Override
  public String addCash(String currency, int value, int number) {

    return oper.addCashToAccount(currency, value, number);
  }

  @Override
  public String getCash(String currency, int amount) {

    return oper.getCashFromAccount(currency, amount);
  }

  @Override
  public String printBillStateOnCard() {

    return oper.printBillStateOnAccount();
  }
}
