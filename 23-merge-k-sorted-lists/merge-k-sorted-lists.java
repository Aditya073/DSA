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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> value = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // add all the elements to a single big list
        for (ListNode list : lists) {
            while (list != null) {
                value.add(list.val);
                list = list.next;
            }
        }
        // sort that list
        Collections.sort(value);

        // convert that ArrayList into ListNode
        for (int val : value) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}