import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class Solution26 {
  public int removeDuplicates(int[] nums) {
    Set<Integer> set = new LinkedHashSet<>();
    Arrays.stream(nums).forEach(set::add);
    int count = set.size();
    if (count > 1) {
      int i = 0;
      for (Integer v : set) {
        nums[i++] = v;
      }
      for (; i < nums.length; i++) {
        nums[i] = 0;
      }
    }
    return count;
  }
}
