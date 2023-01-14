/**
 * 9. Palindrome Number
 */
class Solution9 {
  public boolean isPalindrome(int x) {
      String first = String.valueOf(x);
      String second = new StringBuilder(first).reverse().toString();
      return first.equals(second);
  }
}
