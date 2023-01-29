/**
 * 69. Sqrt(x)
 */
public class Solution69 {
  public int mySqrt(int x) {
    int count = 0;

    for (int i = 1; x - i >= 0; ) {
      x -= i;
      ++count;
      i += 2;
    }
    System.out.println(count);
    return count;
  }

  public static void main(String[] args) {
    Solution69 s = new Solution69();
    System.out.println(s.mySqrt(605) == 24);
    System.out.println(s.mySqrt(9) == 3);
  }
}
