package Validators;

import Account.Account;
import Account.UserAccount;

public class AddValidator implements Validator{
  public String[] args;
  private Account userAcc = new UserAccount();

  @Override
  public boolean isValid() {
    if ((args.length == 4) && (args[1].length() == 3)
        && (args[1].equals("USD") || args[1].equals("UAH") || args[1].equals("EUR"))
        && (args[3].matches("\\d+"))) {
      if (args[2].matches("\\d+")) {
        Integer key = Integer.parseInt(args[2]);
        if (userAcc.contains(key)) {
          return true;
        }
      }
    }
    return false;
  }
}
