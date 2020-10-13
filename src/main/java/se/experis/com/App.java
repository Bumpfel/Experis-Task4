package se.experis.com;

public final class App {

  public static void main(String[] args) {
    // isValidCreditCard(4444555566667777L);
    System.out.println(isValidCreditCard(7992739871L, 3));
  }

  static boolean isValidCreditCard(long cardNr, int checkSum) {
    String cardNrStr = "" + cardNr;

    // if(cardNrStr.length() != 16) {
    //   return false;
    // }

    int sum = 0;
    for(int i = cardNrStr.length() - 1; i >= 0; i --) {
      int digit = Integer.parseInt(cardNrStr.substring(i, i + 1));
      int calc = digit * (i % 2 == 1 ? 2 : 1);
      if(calc > 9) {
        calc -= 9;
      }
      sum += calc;
    }
    int calculatedChecksum = sum * 9 % 10;

    System.out.println("calc " + calculatedChecksum);
    
    return calculatedChecksum == checkSum;
  }
}
