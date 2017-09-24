package validators;

public class GetValidator implements Validator {
  private Property prop = new Property();

  @Override
  public boolean validate(String[] args) {
    if ((args.length == 3) && (prop.currencyIsValid(args[1]))) {
      if (args[2].matches("\\d+")) {
        int amount = Integer.parseInt(args[2]);
        if ((amount > 0) && (amount <= 100_000)) {
          return true;
        }
      }
    }
    return false;
  }
}