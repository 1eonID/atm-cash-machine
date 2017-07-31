import java.util.HashMap;
import java.util.Map;

public class UserCard implements Card{
  private Map<Integer, Integer> usd = new HashMap<>();
  private Map<Integer, Integer> eur = new HashMap<>();
  private Map<Integer, Integer> uah = new HashMap<>();

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
