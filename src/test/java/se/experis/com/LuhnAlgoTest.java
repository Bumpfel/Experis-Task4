package se.experis.com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuhnAlgoTest {

  private LuhnAlgo luhnAlgo = new LuhnAlgo();

  @Test
  void isPositiveNr() {
    assertTrue(luhnAlgo.isPositive(123));
  }
  @Test
  void isPositiveNr2() {
    assertFalse(luhnAlgo.isPositive(-81923));
  }


  @Test
  void testWrongChecksumWrongLength() {
    wrongChecksumWrongLength(65, 7);
  }
  @Test
  void testWrongChecksumWrongLength2() {
    wrongChecksumWrongLength(89, 0);
  }
  private void wrongChecksumWrongLength(long input, int chkSum) {
    assertFalse(luhnAlgo.isValidCheckSum(input, chkSum));
    assertFalse(luhnAlgo.isValidCreditCard(input, chkSum));  
  }


  @Test
  void testCorrectChecksumWrongLength() {   
    correctChecksumWrongLength(67, 9);
  }
  @Test
  void testCorrectChecksumWrongLength2() {    
    correctChecksumWrongLength(39, 8);
  }
  private void correctChecksumWrongLength(long input, int chkSum) {
    assertTrue(luhnAlgo.isValidCheckSum(input, chkSum));
    assertFalse(luhnAlgo.isValidCreditCard(input, chkSum));
  }
    

  @Test
  void testWrongChecksumCorrectLength() {
    wrongChecksumCorrectLength(424242424242424L, 1);
  }
  @Test
  void testWrongChecksumCorrectLength2() {
    wrongChecksumCorrectLength(111122223333444L, 3);
  }
  private void wrongChecksumCorrectLength(long input, int chkSum) {
    assertFalse(luhnAlgo.isValidCheckSum(input, chkSum));
    assertTrue(luhnAlgo.isValidCreditCardLength(input, chkSum));
  }

  
  @Test
  void testCorrectInput() {
    correctInput(424242424242424L, 2);
  }
  @Test
  void testCorrectInput2() {
    correctInput(111122223333444L, 4);
  }
  private void correctInput(long input, int chkSum) {
    assertTrue(luhnAlgo.isValidCheckSum(input, chkSum));
    assertTrue(luhnAlgo.isValidCreditCard(input, chkSum));
  }

}
