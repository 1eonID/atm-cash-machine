import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CashMachine {
  private Map<String, Valid> vMap = new HashMap<>();

  private Valid valid = new Valid();

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

    String line = "";
    while (!Objects.equals(line, "exit")) {
      line = reader.readLine();

      String[] args = line.split(" ");
      String cmd = args[0];
      valid.args = args;

      vMap.put(cmd, valid);

      if (valid.isValid()) {
        vMap.get(cmd).execute(args);
      } else {
        System.out.println("You entered invalid description, try again.");
      }
    }

//    final Account user = new UserAccount();
//
//    final SubmenuSelection userSelection = new SubmenuSelection();

  }

}

