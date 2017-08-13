package Validators;

public class AddValidator implements Validator{
  private Property prop = new Property();

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
