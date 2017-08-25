package Commands;

import Account.Account;
import Account.UserAccount;

public class AddCommand implements Command {
  private Account userAcc = new UserAccount();


  @Override
  public void execute(String[] args) {
    String currency = args[1];
    int value = Integer.parseInt(args[2]);
    int number = Integer.parseInt(args[3]);

    userAcc.addCash(currency, value, number);
  }
}
