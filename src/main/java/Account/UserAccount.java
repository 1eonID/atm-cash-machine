package Account;

import Box.Money;
import Box.MoneyBox;

import java.util.Map;
import java.util.HashMap;

/** The Receiver class */
public class UserAccount implements Account {

  private Map<String, AccountOperations> list;

  MoneyBox money = new Money();

  @Override
  public String addCash(String currency, int value, int number) {

    return list.get(currency).addCashToAccount();
  }

  @Override
  public String getCash(String currency, int amount) {

    return list.get(currency).getCashFromAccount();
  }

  @Override
  public String printCashOnCard() {

    return list.get().getCashFromAccount();
  }
}
