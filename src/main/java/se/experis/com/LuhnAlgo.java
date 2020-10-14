package se.experis.com;

public final class LuhnAlgo {

  private final int CREDIT_CARD_LENGTH = 16;

  public int calcCheckSum(long cardNrWithoutCheckSum) {
    long number = cardNrWithoutCheckSum;
    int sum = 0;

    for (int i = 0; number > 0; i++) {
      int digit = (int) (number % 10);
      
      int calc = digit * ((i & 1) == 0 ? 2 : 1);
      if(calc > 10) {
        calc -= 9;
      }

      sum += calc;
      number /= 10;
    }

    return sum * 9 % 10;
  }
  
  public boolean isValidCheckSum(long cardNrWithoutCheckSum, int checkSum) {
    return calcCheckSum(cardNrWithoutCheckSum) == checkSum;
  }

  public boolean isValidCreditCardLength(long cardNrWithoutCheckSum, int checkSum) {
    return ("" + cardNrWithoutCheckSum + checkSum).length() == CREDIT_CARD_LENGTH;
  }

  public boolean isValidCreditCard(long cardNrWithoutCheckSum, int checkSum) {
    if(!isValidCreditCardLength(cardNrWithoutCheckSum, checkSum) || !isPositive(cardNrWithoutCheckSum)) {
      return false;
    }

    return isValidCheckSum(cardNrWithoutCheckSum, checkSum);
  }

  public boolean isPositive(long nr) {
    return nr >= 0;
  }
}
