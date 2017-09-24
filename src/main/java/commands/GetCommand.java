package Commands;

import Account.Account;
import Account.UserAccount;

public class GetCommand implements Command {
  private Account userAcc = new UserAccount();

  @Override
  public void execute(String[] args) {
    String currency = args[1];
    Integer amount = Integer.parseInt(args[2]);

    userAcc.getCash(currency, amount);
  }
}
