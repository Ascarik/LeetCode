import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 5. Longest Palindromic Substring
 */
class Solution5 {
  private boolean isEqual(String s) {
    return s.equals(new StringBuilder(s).reverse().toString());
  }

  public String longestPalindrome(String s) {
    String temp = "";
    if (s == null) {
      return temp;
    } else {
      s = s.trim();
      if (s.length() == 0) return temp;
    }

    Map<Character, List<Integer>> data = new LinkedHashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!data.containsKey(s.charAt(i))) {
        data.put(s.charAt(i), new ArrayList<>());
      }
      data.get(s.charAt(i)).add(i);
    }

    for (Map.Entry<Character, List<Integer>> entry : data.entrySet()) {
      List<Integer> value = entry.getValue();
      if (value.isEmpty()) continue;
      if (temp.length() == 0) {
        temp += temp + entry.getKey();
      }

      end:
      for (int i = 0; i < value.size() - 1; i++) {
        for (int j = i + 1; j < value.size(); j++) {
          String str = s.substring(value.get(i), value.get(j) + 1);
          if (isEqual(str)) {
            if (str.length() > temp.length()) {
              temp = str;
              if (temp.length() == s.length()) break end;
            }
          }
        }
      }
    }
    return temp;
  }
}
