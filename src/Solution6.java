import java.util.Arrays;

/**
 * 6. Zigzag Conversion
 */
public class Solution6 {
  public String convert(String s, int numRows) {
    if (s == null || s.length() == 0) return "";
    if (numRows == 1) return s;

    String[] result = new String[numRows];
    Arrays.fill(result, "");

    int index = 0;
    int i = 0;
    boolean flag = false;
    while (index < s.length()) {
      result[i] += s.charAt(index++);
      if (i == 0 || i == numRows - 1) {
        flag = !flag;
      }

      if (flag) ++i;
      else --i;
    }
    return String.join("", result);
  }

  public static void main(String[] args) {
    Solution6 s = new Solution6();
    assert s.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR");
    assert s.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI");
    assert s.convert("A", 1).equals("A");
    assert s.convert("AB", 1).equals("AB");
  }
}
