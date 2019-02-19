/*
简单的头插入法，引入preHead 可以简单解决
*/


public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode preHead = new ListNode(0);
        ListNode p = head;
        ListNode q = p.next;   // 为了防止断开链接
        while( p != null){
            q = p.next;
            p.next = preHead.next;
            preHead.next = p;
            p = q;
        }
        return preHead.next;
    }
}