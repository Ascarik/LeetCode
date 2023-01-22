import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 4. Median of Two Sorted Arrays
 */
class Solution4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    List<Integer> nums = new ArrayList<>();

    Arrays.stream(nums1).forEach(nums::add);
    Arrays.stream(nums2).forEach(nums::add);
    nums.sort(Comparator.naturalOrder());

    int fullLength = nums1.length + nums2.length;
    int middle = fullLength / 2;

    if (fullLength % 2 == 0) {
      return (nums.get(middle - 1) + nums.get(middle)) / 2.0;
    } else {
      return nums.get(middle);
    }
  }
}
