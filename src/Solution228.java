import java.util.LinkedList;
import java.util.List;

/**
 * 228. Summary Ranges
 */
class Solution228 {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new LinkedList<>();

    if (nums.length == 0) {
      return result;
    }

    int start = 0;
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      if (str.isEmpty()) {
        str.append(nums[i]);
        result.add(str.toString());
        start = nums[i];
      } else if (nums[i] - start != 1) {
        String s = result.get(result.size() - 1);
        if (!s.equals(String.valueOf(nums[i - 1]))) {
          s += "->" + nums[i - 1];
          result.set(result.size() - 1, s);
        }
        str = new StringBuilder();
        str.append(nums[i]);
        result.add(str.toString());
        start = nums[i];

      } else {
        start = nums[i];
        if (i == nums.length - 1) {
          String s = result.get(result.size() - 1);
          s += "->" + nums[i];
          result.set(result.size() - 1, s);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution228 s = new Solution228();
    assert s.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).containsAll(List.of("0->2", "4->5", "7"));
    assert s.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}).containsAll(List.of("0", "2->4", "6", "8->9"));
  }
}
