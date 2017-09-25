package commands;

import account.Account;
import account.UserAccount;

public class PrintCommand implements Command {
  private Account userAcc = new UserAccount();

  @Override
  public String execute(String[] args) {
    return userAcc.printBillStateOnCard();
  }
}
