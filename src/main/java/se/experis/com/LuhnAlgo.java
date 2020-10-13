package se.experis.com;

public final class LuhnAlgo {

  private final int CREDIT_CARD_LENGTH = 16;

  public int calcCheckSum(long cardNr) {
    String cardNrString = "" + cardNr;
    int len = cardNrString.length();

    int sum = 0;
    for(int i = cardNrString.length() - 2; i >= 0; i --) {
      int digit = Integer.parseInt(cardNrString.substring(i, i + 1));

      boolean doubleValue = (len - i) % 2 == 0;
      int calc = digit * (doubleValue ? 2 : 1);
      
      if(calc > 9) {
        calc -= 9;
      }
      sum += calc;
    }
    
    int calculatedChecksum = sum * 9 % 10;    
    return calculatedChecksum;
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
