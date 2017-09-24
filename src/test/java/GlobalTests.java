import account.Account;
import account.UserAccount;
import org.junit.Test;
import org.junit.Before;
import validators.AddValidator;
import validators.PrintValidator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GlobalTests {
  private CashMachine atm1;
  private Account card;

  @Before
  public void setUp() {
    atm1 = new CashMachine();
    card = new UserAccount();

  }



//  @Test
//  public void testMethodAddCash() {
//    assertThat(card.addCash("USD", 100, 30), is("USD 100 30"));
//  }
//
//  @Test
//  public void testMethodsAddAndGetCash() {
//    card.addCash("USD", 100, 30);
//
//    assertThat(card.getCash("USD", 3000), is("100 30" + "\n" + "OK"));
//  }
//
//  @Test
//  public void testForAllMethods() {
//    card.addCash("USD", 100, 30);
//    card.addCash("USD", 10, 20);
//    card.addCash("EUR", 1000, 15);
//
//    card.getCash("USD", 3010);
//
//    assertThat(card.printBillStateOnCard(), is("USD 10 19" + "\n" + "EUR 1000 15" + "\n" + "OK"));
//  }
}
