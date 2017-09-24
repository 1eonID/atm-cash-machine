package validators;

public class AddValidator extends Property implements Validator {
  private Property prop = new Property();

  @Override
  public boolean validate(String[] args) {
    if ((args.length == 4) && (prop.currencyIsValid(args[1]))) {
      if (args[2].matches("\\d+")) {
        int value = Integer.parseInt(args[2]);
        if (prop.valueIsValid(args[1], value)) {
          if (args[3].matches("\\d+")) {
            int number = Integer.parseInt(args[3]);
            if (number > 0) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}
