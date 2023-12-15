class Solution28 {
  public int strStr(String haystack, String needle) {
    haystack = haystack.toLowerCase();
    needle = needle.toLowerCase();
    return haystack.indexOf(needle);
  }
}
