/**
 * 21. Merge Two Sorted Lists
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
class Solution21 {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode current = null;
    ListNode head = null;
    ListNode l1 = list1;
    ListNode l2 = list2;
    int value;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        value = l2.val;
        l2 = l2.next;
      } else if (l2 == null) {
        value = l1.val;
        l1 = l1.next;
      } else if (l1.val >= l2.val) {
        value = l2.val;
        l2 = l2.next;
      } else {
        value = l1.val;
        l1 = l1.next;
      }
      ListNode tail = new ListNode(value);
      if (head != null) {
        current.next = tail;
        current = tail;
      } else {
        current = tail;
        head = tail;
      }
    }
    return head;
  }
}
