import java.util.Map;
import java.util.HashMap;

/** The Receiver class */
public class UserAccount implements Account {

  private Map<String, Map<Integer, Integer>> list = new HashMap<>();
  private Map<Integer, Integer> usd = new HashMap<>();

  MoneyBox money = new Money();

  @Override
  public String addCash(String currency, int value, int number) {
    String reply = "ERROR";


    return reply;
  }

  @Override
  public String getCash(String currency, int amount) {
    String reply = "ERROR";


    return reply;
  }

  @Override
  public String printCashOnCard() {
    String reply = "";

    return reply;
  }

}
