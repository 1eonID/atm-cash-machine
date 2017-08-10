package Validators;

public class PrintValidator implements Validator{
  public String[] args;

  @Override
  public boolean validate() {
    if (args.length == 1) {
      return true;
    }
    return false;
  }
}