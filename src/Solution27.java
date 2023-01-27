import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 27. Remove Element
 */
public class Solution27 {
  public int removeElement(int[] nums, int val) {
    List<Integer> list = new LinkedList<>();
    Arrays.stream(nums).filter(v -> v != val).forEach(list::add);
    int count = list.size();
    if (count > 0) {
      int i = 0;
      for (Integer v : list) {
        nums[i++] = v;
      }
      for (; i < nums.length; ++i) {
        nums[i] = 0;
      }
    }
    return count;
  }
}
