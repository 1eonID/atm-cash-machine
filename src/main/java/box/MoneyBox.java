package Box;

public interface MoneyBox {

  boolean isEnoughMoney(String enteredCur, Integer enteredAmount);

  void addNum(String enteredCur, Integer enteredValue, Integer enteredNumber);

  void getAmount(String enteredCur, Integer enteredAmount);

}
