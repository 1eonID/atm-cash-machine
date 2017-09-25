package commands;

import account.Account;
import account.UserAccount;

public class AddCommand implements Command {
  private Account userAcc = new UserAccount();


  @Override
  public String execute(String[] args) {
    String currency = args[1];
    int value = Integer.parseInt(args[2]);
    int number = Integer.parseInt(args[3]);

    return userAcc.addCash(currency, value, number);
  }
}
