//public class AddOnCard implements Command {
//  private Account userAcc;
//  private String currency;
//  private int value;
//  private int number;
//
//  public AddOnCard(final Account account, String currency, int value, int number) {
//    this.userAcc = account;
//    this.currency = currency;
//    this.value = value;
//    this.number = number;
//  }
//
//  @Override
//  public void execute(String[] args) {
//    currency = args[0];
//    value = Integer.parseInt(args[1]);
//    number = Integer.parseInt(args[2]);
//
//    userAcc.addCash(currency, value, number);
//  }
//}
