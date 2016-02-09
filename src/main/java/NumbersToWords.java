import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class NumbersToWords {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/number-text", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/number-text.vtl");

      String number = request.queryParams("number");
      Integer integerNumber = Integer.parseInt(number);
      String numberText = numberConvert(integerNumber);

      model.put("number", numberText);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
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
    HashMap teens = new HashMap();
    teens.put('0', "ten");
    teens.put('1', "eleven");
    teens.put('2', "twelve");
    teens.put('3', "thirteen");
    teens.put('4', "fourteen");
    teens.put('5', "fifteen");
    teens.put('6', "sixteen");
    teens.put('7', "seventeen");
    teens.put('8', "eighteen");
    teens.put('9', "nineteen");
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
        if ( j == 0 && stringNumber.length() > i + 1 && stringNumber.charAt(i + 1) == '1') {
          result = teens.get(stringNumber.charAt(i)) + " " + result;
          i++;
          j += 2;
        } else {
          result =  dictionary.get(j).get(stringNumber.charAt(i)) + " " + result;
          j++;
          }
        }
    result = result.trim();
    return result;
  }
}
