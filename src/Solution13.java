import java.util.function.Function;

/**
 * 13. Roman to Integer
 */
class Solution13 {
  public int romanToInt(String s) {
    Function<Character, Integer> func = (v) -> switch (v) {
      case 'I' -> 1;
      case 'V' -> 5;
      case 'X' -> 10;
      case 'L' -> 50;
      case 'C' -> 100;
      case 'D' -> 500;
      case 'M' -> 1000;
      default -> 0;
    };

    int count = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      if (i - 1 >= 0 && func.apply(s.charAt(i)) > func.apply(s.charAt(i - 1))) {
        count += func.apply(s.charAt(i)) - func.apply(s.charAt(i - 1));
        i--;
      } else {
        count += func.apply(s.charAt(i));
      }
    }
    return count;
  }
}
