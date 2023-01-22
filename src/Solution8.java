import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8. String to Integer (atoi)
 */
class Solution8 {
  public int myAtoi(String s) {
    s = s.trim();
    if (s.length() == 0) {
      return 0;
    }

    Pattern pattern = Pattern.compile("^\\W{0,1}\\d{1,}");
    Matcher matcher = pattern.matcher(s);
    if (!matcher.find()) {
      return 0;
    }
    s = matcher.group(0).replaceAll("\\+", "");

    long result = (long)Double.parseDouble(s);
    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if (result < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    return (int) result;
  }
}
