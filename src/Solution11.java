/**
 * 11. Container With Most Water
 * <p>
 * Medium level
 */
public class Solution11 {
  public int maxArea(int[] height) {
    int len = height.length;
    int low = 0;
    int high = len - 1;
    int maxArea = 0;
    while (low < high) {
      maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
      if (height[low] < height[high]) {
        ++low;
      } else {
        --high;
      }
    }
    return maxArea;
  }

}
