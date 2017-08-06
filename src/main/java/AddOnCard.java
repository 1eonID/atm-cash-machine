public class AddOnCard implements Command {
  private Account userAcc;
  private String currency;
  private int value;
  private int number;

  public AddOnCard(final Account account, String currency, int value, int number) {
    this.userAcc = account;
    this.currency = currency;
    this.value = value;
    this.number = number;
  }

  @Override
  public void execute(String[] args) {
    userAcc.addCash(currency, value, number);
  }
}
