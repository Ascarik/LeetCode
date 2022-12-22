import java.util.function.Function;

/**
 * 12. Integer to Roman
 */
class Solution12 {
  public String intToRoman(int num) {
    Function<Integer, String> func = (v) -> switch (v) {
      case 1 -> "I";
      case 5 -> "V";
      case 10 -> "X";
      case 50 -> "L";
      case 100 -> "C";
      case 500 -> "D";
      case 1000 -> "M";
      default -> "";
    };
    StringBuilder result = new StringBuilder();
    int step = 1;
    while (num > 0) {
      int i = num % 10;
      if (i < 4) {
        result.insert(0, func.apply(step).repeat(i));
      } else if (i == 4) {
        result.insert(0, func.apply(step).repeat(5 - i) + func.apply(step * 5));
      } else if (i == 5) {
        result.insert(0, func.apply(i * step));
      } else if (i < 9) {
        result.insert(0, func.apply(step * 5) + func.apply(step).repeat(i - 5));
      } else {
        result.insert(0, func.apply(step).repeat(10 - i) + func.apply(step * 10));
      }

      num /= 10;
      step *= 10;
    }

    return result.toString();
  }
}
