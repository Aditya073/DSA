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
    /*
    head
    Current head of entire list
    
    groupHead
    First node of current group
    
    set
    First node after current group
    
    prevGroupTail
    Tail of already processed list
    
    reversedHead
    Head returned after reversing
    */
    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode set = head;

        ListNode prevGroupTail = null;
        ListNode newHead = head;

        while (set != null) {

            count++;
            ListNode next = set.next;

            if (count == k) {

                ListNode groupHead = newHead;
                ListNode reversedHead = reverse(newHead, next);

                // reconnect the reversed part with the main list 
                if (prevGroupTail != null) {
                    prevGroupTail.next = reversedHead;
                } else {
                    head = reversedHead;
                }

                groupHead.next = next;
                prevGroupTail = groupHead;
                newHead = next;
                count = 0;
            }

            set = next;
        }

        return head;
    }

    public ListNode reverse(ListNode head, ListNode tail) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != tail) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}