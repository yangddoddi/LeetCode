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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int nodeCount = 0;
        
        while (temp != null) {
            temp = temp.next;
            nodeCount++;
        }
        
        temp = head;
        
        if (nodeCount == n) {
            head = head.next;
        }
        
        for (int i=1; i<=nodeCount; i++) {
            try {
                if (i + n == nodeCount) {
                    temp.next = temp.next.next;
                }
            
                temp = temp.next;
                
            } catch (Exception e) {
                continue;
            }
        }
        
        return head;
    }
}