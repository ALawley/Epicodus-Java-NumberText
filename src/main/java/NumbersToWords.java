import java.util.HashMap;
import java.util.ArrayList;

public class NumbersToWords {
  public static void main(String[] args) {

  }

  public static String numberConvert(Integer number) {
    String result = "";
    String stringNumber = Integer.toString(number);
    StringBuffer buffer = new StringBuffer(stringNumber);
    stringNumber = buffer.reverse().toString();
    ArrayList<HashMap> dictionary = new ArrayList<HashMap>();
    HashMap ones = new HashMap();
    ones.put('0', "");
    ones.put('1', "one");
    ones.put('2', "two");
    ones.put('3', "three");
    ones.put('4', "four");
    ones.put('5', "five");
    ones.put('6', "six");
    ones.put('7', "seven");
    ones.put('8', "eight");
    ones.put('9', "nine");
    dictionary.add(ones);
    for (Integer i = 0; i < stringNumber.length(); i++) {
    result =  dictionary.get(i).get(stringNumber.charAt(i)) + result;
    }
    return result;
  }
}
