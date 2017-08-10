package Validators;

public class GetValidator implements Validator{
  public String[] args;

  @Override
  public boolean validate() {
    if ((args.length == 3) && (args[1].length() == 3)
        && (args[1].equals("USD") || args[1].equals("UAH") || args[1].equals("EUR"))) {
      if (args[2].matches("\\d+")) {
        return true;
      }
    }
    return false;
  }
}