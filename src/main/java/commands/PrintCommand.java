package Commands;

import Account.Account;
import Account.UserAccount;

public class PrintCommand implements Command {
  private Account userAcc = new UserAccount();

  @Override
  public void execute(String[] args) {
    userAcc.printBillStateOnCard();
  }
}
