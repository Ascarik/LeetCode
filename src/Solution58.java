/**
 * 58. Length of Last Word
 */
public class Solution58 {
  public int lengthOfLastWord(String s) {
    String[] split = s.trim().split(" ");

    if(split.length>0){
      return split[split.length-1].length();
    }
    return 0;
  }
}
