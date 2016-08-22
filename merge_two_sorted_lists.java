/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        ListNode curNode = l1;
        ListNode t;
        while (l2 != null) {
            if (l2.val < curNode.val) {
                t = l2.next;
                l2.next = curNode;
                l1 = l2;
                l2 = t;
                curNode = l1;
            } else if (l2.val >= curNode.val) {
                while (curNode.next != null && l2.val >= curNode.next.val) {
                    curNode = curNode.next;
                }
                t = l2.next;
                l2.next = curNode.next;
                curNode.next = l2;
                curNode = l2;
                l2 = t;
            }
        }
        return l1;
    }
}
