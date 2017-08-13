package Commands;

import Account.Account;

public class AddCommand implements Command {
  private Account userAcc;
  private String currency;
  private int value;
  private int number;


  @Override
  public void execute(String[] args) {
    currency = args[0];
    value = Integer.parseInt(args[1]);
    number = Integer.parseInt(args[2]);

    userAcc.addCash(currency, value, number);
  }
}
