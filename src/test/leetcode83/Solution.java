package test.leetcode83;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode alpha = head;
        ListNode beta = head;

        beta = beta.next;
        while (beta.next != null) {
            if (alpha.val == beta.val) {
                alpha.next = beta.next;
                beta = beta.next;
            } else {
                alpha = beta;
            }
        }
        if (alpha != null && beta != null && alpha.val == beta.val) {
            alpha.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        tmp.next = new ListNode(1);
        tmp = tmp.next;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = new ListNode(3);

        // print original list
        ListNode ppp = head;
        while (ppp.next != null) {
            System.out.println(ppp.val);
            ppp = ppp.next;
        }
        System.out.println(ppp.val);

        System.out.println("-------------");

        // print duplicated list
        Solution solution = new Solution();
        solution.deleteDuplicates(head);
        ListNode p = head;
        while (p.next != null) {
            System.out.println(p.val);
            p = p.next;
        }
        System.out.println(p.val);
    }
}
