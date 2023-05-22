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
    ListNode l1Temp = new ListNode(l1.getVal());
    ListNode l2Temp = new ListNode(l2.getVal());
    while (l1.getNext() != null) {
      l1 = l1.getNext();
      l1Temp = new ListNode(l1.getVal(), l1Temp);
    }
    while (l2.getNext() != null) {
      l2 = l2.getNext();
      l2Temp = new ListNode(l2.getVal(), l2Temp);
    }
    int num1 = 0;
    while (l1Temp.getNext() != null) {
      num1 = num1 * 10 + l1Temp.getVal();
      l1Temp = l1Temp.getNext();
    }
    num1 = num1 * 10 + l1Temp.getVal();

    int num2 = 0;
    while (l2Temp.getNext() != null) {
      num2 = num2 * 10 + l2Temp.getVal();
      l2Temp = l2Temp.getNext();
    }
    num2 = num2 * 10 + l2Temp.getVal();

    int sum = num1 + num2;
    ListNode outputTemp = new ListNode(sum % 10);
    while (sum / 10 > 0) {
      sum = sum / 10;
      outputTemp = new ListNode(sum % 10, outputTemp);
    }
    ListNode output = new ListNode(outputTemp.getVal());
    while (outputTemp.getNext() != null) {
      outputTemp = outputTemp.getNext();
      output = new ListNode(outputTemp.getVal(), output);
    }
    return output;
  }
}

class ListNode {
  private int val;
  private ListNode next;

  public ListNode() {

  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public int getVal() {
    return val;
  }

  public ListNode getNext() {
    return next;
  }

  @Override
  public String toString() {
    List<Integer> list = new ArrayList<>();
    ListNode listNode = this;
    while (listNode.getNext() != null) {
      list.add(listNode.getVal());
      listNode = listNode.getNext();
    }
    list.add(listNode.getVal());
    return list.toString();
  }
}