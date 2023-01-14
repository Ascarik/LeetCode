/**
 * 14. Longest Common Prefix
 */
class Solution14 {
  public String longestCommonPrefix(String[] strs) {
    StringBuilder result = new StringBuilder();
    if (strs == null || strs.length == 0) return result.toString();
    int index = 0;
    char temp;
    while (index < 200) {
      if (index >= strs[0].length()) return result.toString();
      temp = strs[0].charAt(index);

      for (String str : strs) {
        if (str.length() > index) {
          if (str.charAt(index) != temp) return result.toString();
        } else {
          return result.toString();
        }
      }
      ++index;
      result.append(temp);
    }
    return result.toString();
  }

}
