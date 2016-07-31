/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode(0);
        ListNode res = new ListNode(0);
        if (head != null && head.next != null) {
            res = reverseList(head.next);
            p.next = head.next;
            head.next = head.next.next;
            p.next.next = head;
            return res;
        } else {
            return head;
        }
    }
}
