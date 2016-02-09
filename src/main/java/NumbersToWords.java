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
    HashMap tens = new HashMap();
    tens.put('0', "");
    tens.put('1', "ten");
    tens.put('2', "twenty");
    tens.put('3', "thirty");
    tens.put('4', "forty");
    tens.put('5', "fifty");
    tens.put('6', "sixty");
    tens.put('7', "seventy");
    tens.put('8', "eighty");
    tens.put('9', "ninety");
    dictionary.add(tens);
    HashMap hundreds = new HashMap();
    hundreds.put('0', "");
    hundreds.put('1', "one hundred");
    hundreds.put('2', "two hundred");
    hundreds.put('3', "three hundred");
    hundreds.put('4', "four hundred");
    hundreds.put('5', "five hundred");
    hundreds.put('6', "six hundred");
    hundreds.put('7', "seven hundred");
    hundreds.put('8', "eight hundred");
    hundreds.put('9', "nine hundred");
    dictionary.add(hundreds);
    Integer j = 0;
    for (Integer i = 0; i < stringNumber.length(); i++) {
      if ( i == 12 ) {
        result = "trillion " + result;
        j = 0;
      }
      if ( i == 9 ) {
        result = "billion " + result;
        j = 0;
      }
      if ( i == 6 ) {
        result = "million " + result;
        j = 0;
      }
      if ( i == 3 ) {
        result = "thousand " + result;
        j = 0;
      }
    result =  dictionary.get(j).get(stringNumber.charAt(i)) + " " + result;
    j++;
    }
    result = result.trim();
    return result;
  }
}
