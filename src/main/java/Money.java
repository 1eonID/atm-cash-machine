import java.util.HashMap;
import java.util.Map;

class Money implements MoneyBox{
  private Map<Integer, Integer> usd = new HashMap<>();
  private Map<Integer, Integer> eur = new HashMap<>();
  private Map<Integer, Integer> uah = new HashMap<>();


  @Override
  public String add() {
    return null;
  }

  @Override
  public String get() {
    return null;
  }

  @Override
  public String printCashInTerminal() {
    String reply = "Sorry, this cash machine is empty, go to the next nearest ATM";

    return reply;
  }
}