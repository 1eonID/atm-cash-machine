import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CashMachine{
  private String currency;
  private int value;
  private int number;
  private int amount;

  void menu() throws IOException {
    Card card = new UserCard();
    System.out.println("Hi! Choose, what type of operation do you need:" + "\n" +
        "Enter '1', if you need add money on your card" + "\n" +
        "Enter '2', if you need get cash from your card" + "\n" +
        "Enter '3', if you need print, how much money on your card");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int menuNum = Integer.parseInt(reader.readLine());

    if (menuNum == 1) {
      System.out.println("You choose menu for adding money to your card." + "\n" +
          "Enter your operation in format: 'XXX aa bb', where:" + "\n" +
          "XXX - code of your currency (example: 'USD' - for United States Dollar)" + "\n" +
          "aa - is the value of notes" + "\n" +
          "bb - is the number of notes");
      String line = reader.readLine();

      String[] parts = (line + " ").split("\\p{P}?[ \\t\\n\\r]+");
      if ((parts.length == 3) && (parts[0].length() == 3) &&
          (parts[0].equals("USD") || parts[0].equals("UAH") || parts[0].equals("EUR"))) {

      }

      System.out.println(card.addCash(currency, value, number));
    } else if (menuNum == 2) {
      System.out.println(("You choose menu for geting money from your card." + "\n" +
          "Enter your operation in format: 'XXX aa', where:" + "\n" +
          "XXX - code of your currency (example: 'USD' - for United States Dollar)" + "\n" +
          "aa - is the amount of money do you need"));
      String line = reader.readLine();

      String[] parts = (line + " ").split("\\p{P}?[ \\t\\n\\r]+");
      if ((parts.length == 3) && (parts[0].length() == 3) &&
          (parts[0].equals("USD") || parts[0].equals("UAH") || parts[0].equals("EUR"))) {

      }

      System.out.println(card.getCash(currency, amount));
    } else if (menuNum == 3) {
      System.out.println(card.printCashOnCard());
    } else {
      System.out.println("You entered invalid characters, try again.");
    }

  }

}

