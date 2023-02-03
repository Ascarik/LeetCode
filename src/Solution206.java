/**
 * 206. Reverse Linked List
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {
  public ListNode reverseList(ListNode head) {
    ListNode h = null;
    ListNode move = head;
    while (move != null) {
      ListNode temp = new ListNode(move.val);
      if (h == null) {
        h = temp;
      } else {
        temp.next = h;
        h = temp;
      }
      move = move.next;
    }
    return h;
  }
}
