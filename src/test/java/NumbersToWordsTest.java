import org.junit.*;
import static org.junit.Assert.*;

public class NumbersToWordsTest {

  @Test
  public void numberConvert_SingleDigitNumber_Four() {
    NumbersToWords newNumber = new NumbersToWords();
    assertEquals("four", newNumber.numberConvert(4));
  }
  @Test
  public void numberConvert_ThreeDigitNumber_FourHundredEightySix() {
    NumbersToWords newNumber = new NumbersToWords();
    assertEquals("four hundred eighty six", newNumber.numberConvert(486));
  }
  @Test
  public void numberConvert_SixDigitNumber_586257() {
    NumbersToWords newNumber = new NumbersToWords();
    assertEquals("five hundred eighty six thousand two hundred fifty seven", newNumber.numberConvert(586257));
  }
}
