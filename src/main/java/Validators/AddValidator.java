package Validators;

public class AddValidator extends Property implements Validator{
  private Property prop;

  @Override
  public boolean validate(String[] args) {
    if ((args.length == 4) && (args[3].matches("\\d+"))) {
      if (prop.isValid(args)) {
          return true;
      }
    }
    return false;
  }
}
