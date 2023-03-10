
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode a = head;
        if (a == null){return head;}
        ListNode b = head.next;
        if (b == null){return head;}
        ListNode p = null;
        head = b;
        while (a.next != null && b.next != null){
            a.next = b.next;
            b.next = a;
            if (p != null){
                p.next = b;
            }
            p = a;
            a = a.next;
            b = a.next;
        }
        if (b != null){
            a.next = b.next;
            b.next = a;
            if (p != null){
                p.next = b;
            }
        }
        return head;
    }
}