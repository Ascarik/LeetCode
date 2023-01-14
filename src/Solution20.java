import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. Valid Parentheses
 */
class Solution20 {
  public boolean isValid(String s) {
    Deque<Character> queue = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      if (queue.isEmpty()) {
        queue.add(s.charAt(i));
        continue;
      }
      Character poll = queue.peekLast();
      if (poll == '(' && s.charAt(i) == ')'
        || poll == '{' && s.charAt(i) == '}'
        || poll == '[' && s.charAt(i) == ']') {
        queue.removeLast();
      } else {
        queue.add(s.charAt(i));
      }
    }
    return queue.isEmpty();
  }
}
