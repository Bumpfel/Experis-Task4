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
    wrongChecksumWrongLength(657);
  }
  @Test
  void testWrongChecksumWrongLength2() {
    wrongChecksumWrongLength(890);
  }
  private void wrongChecksumWrongLength(long input) {
    assertFalse(luhnAlgo.isValidCheckSum(input));
    assertFalse(luhnAlgo.isValidCreditCard(input));  
  }


  @Test
  void testCorrectChecksumWrongLength() {
    correctChecksumWrongLength(679);
  }
  @Test
  void testCorrectChecksumWrongLength2() {
    correctChecksumWrongLength(398);
  }
  private void correctChecksumWrongLength(long input) {
    assertTrue(luhnAlgo.isValidCheckSum(input));
    assertFalse(luhnAlgo.isValidCreditCard(input));
  }
    

  @Test
  void testWrongChecksumCorrectLength() {
    wrongChecksumCorrectLength(4242424242424241L);
  }
  @Test
  void testWrongChecksumCorrectLength2() {
    wrongChecksumCorrectLength(1111222233334443L);
  }
  private void wrongChecksumCorrectLength(long input) {
    assertFalse(luhnAlgo.isValidCheckSum(input));
    assertTrue(luhnAlgo.isValidCreditCardLength(input));
  }

  
  @Test
  void testCorrectInput() {
    correctInput(4242424242424242L);
  }
  @Test
  void testCorrectInput2() {
    correctInput(1111222233334444L);
  }
  private void correctInput(long input) {
    assertTrue(luhnAlgo.isValidCheckSum(input));
    assertTrue(luhnAlgo.isValidCreditCard(input));
  }

}
