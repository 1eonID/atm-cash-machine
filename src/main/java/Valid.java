public class Valid implements Validator, Command {
  String[] args;
  private Account userAcc = new UserAccount();

  @Override
  public boolean isValid() {
    if (args[0].equals("+")) {
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
    }

    if (args[0].equals("-")) {
      if ((args.length == 3) && (args[1].length() == 3)
          && (args[1].equals("USD") || args[1].equals("UAH") || args[1].equals("EUR"))) {
        if (args[2].matches("\\d+")) {
          return true;
        }
      }
    }

    if (args[0].equals("?") && args.length == 1) {
      return true;
    }

    return false;
  }

  @Override
  public void execute(String[] args) {
    String cmd = args[0];
    String currency;
    int value;
    int number;
    int amount;

    if (cmd.equals("+")) {
      currency = args[1];
      value = Integer.parseInt(args[2]);
      number = Integer.parseInt(args[3]);

      userAcc.addCash(currency, value, number);
    } else if (cmd.equals("-")) {
      currency = args[1];
      amount = Integer.parseInt(args[2]);

      userAcc.getCash(currency, amount);
    } else {
      userAcc.printCashOnCard();
    }
  }
}
