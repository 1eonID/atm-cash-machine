package commands;

import account.Account;
import account.UserAccount;

public class GetCommand implements Command {
  private Account userAcc = new UserAccount();

  @Override
  public String execute(String[] args) {
    String currency = args[1];
    Integer amount = Integer.parseInt(args[2]);

    return userAcc.getCash(currency, amount);
  }
}
