package se.experis.com;

public final class LuhnAlgo {

  public boolean isValidCreditCard(long cardNr, int checkSum) {
    String cardNrStr = "" + cardNr;

    if(cardNrStr.length() != 15) {
      return false;
    }

    int sum = 0;
    for(int i = cardNrStr.length() - 1; i >= 0; i --) {
      int digit = Integer.parseInt(cardNrStr.substring(i, i + 1));
      int calc = digit * (i % 2 == 0 ? 2 : 1);
      if(calc > 9) {
        calc -= 9;
      }
      sum += calc;
    }
    int calculatedChecksum = sum * 9 % 10;
    return calculatedChecksum == checkSum;
  }
}
