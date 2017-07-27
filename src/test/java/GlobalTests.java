import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GlobalTests {
  private CashMachine atm1;

  @Before
  public void setUp() {
    atm1 = new CashMachine();

  }

  @Test
  public void testMethodAddCash() {
    atm1.addCash("USD", 100, 30);

    assertThat(atm1.printCash(), is("USD 100 30"));
  }

  @Test
  public void testMethodsAddAndGetCash() {
    atm1.addCash("USD", 100, 30);

    assertThat(atm1.getCash("USD", 3000), is("100 30" + "\n" + "OK"));
  }

  @Test
  public void testForAllMethods() {
    atm1.addCash("USD", 100, 30);
    atm1.addCash("USD", 10, 20);
    atm1.addCash("EUR", 1000, 15);

    atm1.getCash("USD", 3010);

    assertThat(atm1.printCash(), is("USD 10 19" + "\n" + "EUR 1000 15" + "\n" + "OK"));
  }
}

class CashMachine {
  private String currency;
  private int value;
  private int number;
  private int amount;

  public String addCash(String currency, int value, int number) {
    String reply = "ERROR";


    return reply;
  }

  public String getCash(String currency, int amount) {
    String reply = "ERROR";


    return reply;
  }

  public String printCash() {
    String reply = "Sorry, this cash machine is empty, go to the next nearest ATM";


    return reply;
  }
}