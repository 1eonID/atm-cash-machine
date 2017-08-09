package Commands;

import Account.Account;

public class PrintFromCard implements Command {
  private Account userAcc;

  public PrintFromCard(final Account account) {
    this.userAcc = account;
  }

  @Override
  public void execute(String[] args) {
    userAcc.printCashOnCard();
  }
}
