package Commands;

import Account.Account;

public class GetCommand implements Command {
  private Account userAcc;
  private String currency;
  private int amount;


  @Override
  public void execute(String[] args) {
    currency = args[1];
    amount = Integer.parseInt(args[2]);

    userAcc.getCash(currency, amount);
  }
}
