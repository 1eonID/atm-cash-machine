package Validators;

public class PrintValidator implements Validator {

  @Override
  public boolean validate(String[] args) {
    return args.length == 1;
  }
}