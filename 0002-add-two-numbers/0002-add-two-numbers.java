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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = (l1.val + l2.val >= 10) ? 1 : 0;
        ListNode node = new ListNode((l1.val + l2.val >= 10) ? l1.val + l2.val - 10 : l1.val + l2.val);
        ListNode prev = node;
        while (l1.next != null || l2.next != null) {
            int n1 = (l1.next == null) ? 0 : l1.next.val;
            int n2 = (l2.next == null) ? 0 : l2.next.val;
            int sum = n1 + n2 + temp;
            
            l1 = (l1.next == null) ? l1 : l1.next;
            l2 = (l2.next == null) ? l2 : l2.next;
            
            if (sum >= 10) {
                temp = 1;
                sum = sum - 10;
            } else {
                temp = 0;
            }
            
            prev.next = new ListNode(sum);
            prev = prev.next;
        }
        
        if (temp != 0) {
            prev.next = new ListNode(1);
        }
        
        return node;
    }
}