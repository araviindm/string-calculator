import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.stream.Collectors;

public class StringCalculator {

  public static void main(String args[]) throws Exception {
    System.out.println(add("//[***]\n1***2***3"));
  }

  static int getNumber(String num) {
    int n = 0;
    try {
      n = Integer.parseInt(num);
    } catch (NumberFormatException err) {
      return 0;
    }
    return n;
  }

  static int add(String numbers) throws Exception {
    if (numbers.trim() != "") {
      String delimiter = "[,\n]+";

      if (Pattern.compile("^//").matcher(numbers).find()) {
        delimiter = Character.toString(numbers.charAt(2));
        if ((int) numbers.charAt(2) == 91) {
          String[] arr = numbers.split("]\n");
          delimiter = arr[0].substring(3);
          numbers = arr[1];
        } else {
          numbers = numbers.substring(4);
        }
      }
      String[] num = numbers.split(Pattern.quote(delimiter));
      int sum = 0;
      boolean isNegativePresent = false;
      for (int i = 0; i < num.length; i++) {
        int n = getNumber(num[i]);
        if (n < 0) {
          isNegativePresent = true;
          break;
        } else {
          if (n > 1000) {
            n = 0;
          }
          sum += n;
        }
      }
      if (isNegativePresent) {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
          int n = getNumber(num[i]);
          if (n < 0) {
            arr.add(n);
          }
        }
        String concat = arr
          .stream()
          .map(String::valueOf)
          .collect(Collectors.joining(","));
        String err = "\"negatives not allowed\" - " + concat;
        throw new Exception(err);
      }
      return sum;
    }
    return 0;
  }
}
