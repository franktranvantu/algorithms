import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    ListNode output = addTwoNumbers(l1, l2);
    System.out.println(output);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int sum = 0;
      if (l1 != null) {
        sum = l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum = sum + l2.val;
        l2 = l2.next;
      }
      sum = sum + carry;
      carry = sum / 10;
      current.next = new ListNode(sum % 10);
      current = current.next;
    }
    return dummy.next;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  String toString() {
    List<Integer> list = new ArrayList<>();
    ListNode listNode = this;
    while (listNode.next != null) {
      list.add(listNode.val);
      listNode = listNode.next;
    }
    list.add(listNode.val);
    return list.toString();
  }
}