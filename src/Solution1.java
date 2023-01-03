/**
 * 1. Two Sum
 */
public class Solution1 {
  public int[] twoSum(int[] nums, int target) {
    int i = 0;
    int j = nums.length - 1;
    while (i <= j) {
      if (nums[i] + nums[j] == target) {
        break;
      }
      --j;
      if (i == j) {
        j = nums.length - 1;
        ++i;
      }
    }
    return new int[]{i, j};
  }
}
