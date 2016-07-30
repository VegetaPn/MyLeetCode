/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    private ListNode p = new ListNode(0);

    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            head.next.next = swapPairs(head.next.next);
            p.next = head.next;
            head.next = head.next.next;
            p.next.next = head;
            return p.next;
        } else {
            return head;
        }
    }
}
