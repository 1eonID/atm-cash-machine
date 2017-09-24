package validators;

public class PrintValidator implements Validator {

  @Override
  public boolean validate(String[] args) {
    return ((args.length == 1) && (args[0].equals("?")));
  }
}