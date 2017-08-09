package Validators;

public class PrintValidator implements Validator{
  public String[] args;

  @Override
  public boolean isValid() {
    if (args.length == 1) {
      return true;
    }
    return false;
  }
}