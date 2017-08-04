public class Valid implements Validator {
  String[] args;

  @Override
  public boolean isValid() {
    if (args[0].equals("+")) {
      if ((args.length == 4) && (args[1].length() == 3)
          && (args[1].equals("USD") || args[1].equals("UAH") || args[1].equals("EUR"))
          && (args[3].matches("\\d+"))) {
        if (args[2].matches("\\d+")) {
          Integer key = Integer.parseInt(args[1]);
          contains(key);
        }
      }
      return true;
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

//    Command addCash = new AddOnCard();

//    Command getCash = new GetFromCard();
//
//    Command print = new PrintFromCard();

    return false;
  }


  @Override
  public void validate() {


  }
}
