import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CashMachine {
  private String currency;
  private int value;
  private int number;
  private int amount;

  void menu() throws IOException {
    System.out.println("Hi! Choose, what type of operation do you need:" + "\n"
        + "Enter '+ XXX aa bb', if you need add money on your card" + "\n"
        + "Enter '- XXX cc', if you need get cash from your card" + "\n"
        + "Enter '?', if you need print, how much money on your card" + "\n"
        + "where:" + "\n"
        + "XXX - code of your currency (example: 'USD' - for United States Dollar)" + "\n"
        + "aa - is the value of notes" + "\n"
        + "bb - is the number of notes" + "\n"
        + "cc - is the amount of money do you need");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();

    String[] args = line.split(" ");

    final Account user = new UserAccount();


    final SubmenuSelection userSelection = new SubmenuSelection();

    switch (args[0]) {
      case "+":
        if ((args.length == 4) && (args[1].length() == 3)
            && (args[1].equals("USD") || args[1].equals("UAH") || args[1].equals("EUR"))) {
          currency = args[1];
        }
        if (args[2].matches("\\d+")) {
          value = Integer.parseInt(args[2]);;
        }
        if (args[3].matches("\\d+")) {
          number = Integer.parseInt(args[3]);;
        }

        Command addCash = new AddOnCard(user, currency, value, number);

        System.out.println(userSelection.storeAndExecute(addCash));
        break;
      case "-":
          if ((args.length == 3) && (args[1].length() == 3)
              && (args[1].equals("USD") || args[1].equals("UAH") || args[1].equals("EUR"))) {
            currency = args[1];
          }
          if (args[2].matches("\\d+")) {
            amount = Integer.parseInt(args[2]);;
          }

        Command getCash = new GetFromCard(user, currency, amount);


        System.out.println(userSelection.storeAndExecute(getCash));
        break;
      case "?":
        Command print = new PrintFromCard(user);

        System.out.println(userSelection.storeAndExecute(print));
        break;
      default:
        System.out.println("You entered invalid characters, try again.");
        break;
    }

  }

}

