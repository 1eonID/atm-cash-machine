package Commands;

import Account.Account;

public class PrintCommand implements Command {
  private Account userAcc;

  public PrintCommand(final Account account) {
    this.userAcc = account;
  }

  @Override
  public void execute(String[] args) {
    userAcc.printCashOnCard();
  }
}
