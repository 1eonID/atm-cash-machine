package Commands;

import Account.Account;

public class PrintCommand implements Command {
  private Account userAcc;

  @Override
  public void execute(String[] args) {
    userAcc.printCashOnCard();
  }
}
