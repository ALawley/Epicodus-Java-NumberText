import org.junit.*;
import static org.junit.Assert.*;

public class NumbersToWordsTest {

  @Test
  public void numberConvert_SingleDigitNumber_Four() {
    NumbersToWords newNumber = new NumbersToWords();
    assertEquals("four", newNumber.numberConvert(4));
  }
}
