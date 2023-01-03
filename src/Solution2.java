import java.math.BigInteger;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

/**
 * 2. Add Two Numbers
 */
public class Solution2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    String[] values = new BigInteger(extracted(l1))
      .add(new BigInteger(extracted(l2))).toString().split("");
    ListNode head = null;
    for (String value : values) {
      if (head == null) {
        head = new ListNode(Integer.parseInt(value), null);
      } else {
        head = new ListNode(Integer.parseInt(value), head);
      }

    }
    return head;
  }

  private static String extracted(ListNode listNode) {
    StringBuilder result = new StringBuilder();
    if (listNode != null) {
      ListNode temp = listNode;
      while (temp != null) {
        result.insert(0, temp.val);
        temp = temp.next;
      }
    }
    return result.toString();
  }
}
