/**
 * 7. Reverse Integer
 */
public class Solution7 {
  public int reverse(int x) {
    Long plusX = Math.abs((long) x);
    int sign = x < 0 ? -1 : 1;

    String strX = String.valueOf(plusX);

    String result = "";
    boolean flag = true;
    for (int i = strX.length() - 1; i >= 0; i--) {
      if (flag && strX.charAt(i) == '0') continue;
      else if (strX.charAt(i) != '0') {
        flag = false;
      }
      result = result + strX.charAt(i);
    }
    if (result.length() == 0) return 0;
    long l = sign * Long.parseLong(result);
    if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) return 0;
    return (int) l;
  }
}
