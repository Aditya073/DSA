/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = head;
        ListNode ptr2 = head;

        while (ptr2.next != null && ptr2.next.next != null) {
            mid = mid.next;
            ptr2 = ptr2.next.next;
        }

        ListNode secondHalf = mid.next;
        mid.next = null;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (secondHalf != null) {
            tail.next = new ListNode(secondHalf.val);
            tail = tail.next;
            secondHalf = secondHalf.next;
        }

        ListNode prev = null;
        ListNode curr = dummy.next;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode reversedHead = prev;

        ListNode first = head;
        ListNode second = reversedHead;

        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }

        if (first != null) {
            first.next = null;
        }

    }
}