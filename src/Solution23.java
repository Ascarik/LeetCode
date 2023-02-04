import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 23. Merge k Sorted Lists
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
class Solution23 {
  public ListNode mergeKLists(ListNode[] lists) {
    List<Integer> data = new ArrayList<>();
    for (ListNode list : lists) {
      ListNode move = list;
      while (move != null) {
        data.add(move.val);
        move = move.next;
      }
    }
    data.sort(Comparator.naturalOrder());
    ListNode head = null;
    ListNode current = null;
    ListNode node;
    for (int v : data) {
      node = new ListNode(v);
      if (head == null) {
        current = node;
        head = node;
      } else {
        current.next = node;
        current = node;
      }

    }
    return head;
  }

  ListNode[] set(int[][] data) {
    ListNode[] lists = new ListNode[data.length];
    for (int i = 0; i < data.length; i++) {
      ListNode head = null;
      ListNode current = null;
      for (int j = 0; j < data[i].length; j++) {
        ListNode node = new ListNode(data[i][j]);
        if (head == null) {
          head = node;
          current = node;
        } else {
          current.next = node;
          current = node;
        }
      }
      lists[i] = head;
    }
    return lists;
  }

  public static void main(String[] args) {
    Solution23 s = new Solution23();
    ListNode[] nodes = s.set(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}});
    s.mergeKLists(nodes);
  }
}
