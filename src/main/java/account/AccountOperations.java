package Account;

import Box.BoxConfig;
import Box.MoneyBox;
import User.UserConfig;
import User.User;

class AccountOperations implements Operations {
  private MoneyBox boxConf = new BoxConfig();
  private User user = new UserConfig();

  public String addCashToAccount(String currency, int value, int number) {
    boxConf.addNum(currency, value, number);
    user.addAmount(currency, (value * number));

    return ("OK" + "\n");
  }

  public String getCashFromAccount(String currency, int amount) {
    if (!user.isEnoughMoneyOnAccount(currency,amount)) {
      return "Sorry, not enough money on your account";
    } else {
      if (!boxConf.isEnoughMoney(currency, amount)) {
        return "Sorry, not enough money in the box, try to use another nearest ATM";
      } else {
        boxConf.getAmount(currency, amount);
        user.getAmount(currency, amount);
      }
    }
    return "OK";
  }

  public String printBillStateOnAccount() {

    return user.printBillState();
  }

}
