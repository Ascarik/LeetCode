import java.util.LinkedList;

/**
 * 66. Plus One
 */
class Solution66 {
  public int[] plusOne(int[] digits) {
    int current;
    int next = 1;
    var queue = new LinkedList<Integer>();
    for (int i = digits.length - 1; i >= 0; i--) {
      current = digits[i] + next;
      if (current > 9) {
        queue.addFirst(0);
        next = 1;
      } else {
        queue.addFirst(current);
        next = 0;
      }
    }
    if (next != 0) {
      queue.addFirst(next);
    }
    var result = new int[queue.size()];
    var i = 0;
    for (Integer v : queue) {
      result[i++] = v;
    }
    return result;
  }
}
