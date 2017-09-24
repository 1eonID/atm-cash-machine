import org.junit.Test;
import validators.AddValidator;
import validators.PrintValidator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidatorsPackTests {
  @Test
  public void testCorrectAddValidationMethod() {
    AddValidator addValid = new AddValidator();
    String addCommand = "+ USD 100 30";
    String[] args = addCommand.split(" ");

    assertThat(addValid.validate(args), is(true));
  }

  @Test
  public void testInCorrectAddValidationMethod() {
    AddValidator addValid = new AddValidator();
    String addCommand1 = "+ USD 333 30";
    String addCommand2 = "+ USSD 100 30";
    String addCommand3 = "+ USD 100 -30";
    String addCommand4 = "+ USD 30";
    String[] args1 = addCommand1.split(" ");
    String[] args2 = addCommand2.split(" ");
    String[] args3 = addCommand3.split(" ");
    String[] args4 = addCommand4.split(" ");

    assertThat(addValid.validate(args1), is(false));
    assertThat(addValid.validate(args2), is(false));
    assertThat(addValid.validate(args3), is(false));
    assertThat(addValid.validate(args4), is(false));
  }

  @Test
  public void testCorrectPrintValidationMethod() {
    PrintValidator printValid = new PrintValidator();
    String addCommand = "?";
    String[] args = addCommand.split(" ");

    assertThat(printValid.validate(args), is(true));
  }

  @Test
  public void testInCorrectPrintValidationMethod() {
    PrintValidator printValid = new PrintValidator();
    String addCommand1 = "";
    String addCommand2 = "? ?";
    String addCommand3 = "??";
    String addCommand4 = "1";
    String[] args1 = addCommand1.split(" ");
    String[] args2 = addCommand2.split(" ");
    String[] args3 = addCommand3.split(" ");
    String[] args4 = addCommand4.split(" ");

    assertThat(printValid.validate(args1), is(false));
    assertThat(printValid.validate(args2), is(false));
    assertThat(printValid.validate(args3), is(false));
    assertThat(printValid.validate(args4), is(false));
  }
}
