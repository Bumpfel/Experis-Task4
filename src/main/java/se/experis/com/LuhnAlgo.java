package se.experis.com;

public final class LuhnAlgo {

  private final int CREDIT_CARD_LENGTH = 16;

  public static int calcCheckSum(long cardNr) {
    long number = cardNr / 10;
    int sum = 0;

    for (int i = 0; number > 0; i++) {
      int digit = (int) (number % 10);
      sum += digit * ((i & 1) == 0 ? 2 : 1);
      number /= 10;
    }

    return sum * 9 % 10;
  }
  
  public boolean isValidCheckSum(long cardNr) {
    long checkSum = cardNr % 10;   
    return calcCheckSum(cardNr) == checkSum;
  }

  public boolean isValidCreditCardLength(long cardNr) {
    return ("" + cardNr).length() == CREDIT_CARD_LENGTH;
  }

  public boolean isValidCreditCard(long cardNr) {
    if(!isValidCreditCardLength(cardNr) || !isPositive(cardNr)) {
      return false;
    }

    return isValidCheckSum(cardNr);
  }

  public boolean isPositive(long nr) {
    return nr >= 0;
  }
}
