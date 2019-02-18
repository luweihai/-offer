/*
对于有可能涉及到 head 的操作，最好是在 head之前设置一个 preHead 使操作更方便
设置一个指针 fast，使其先走 k 步（走的过程中判断 k 是否大于链表长度）
再设置一个指针 slow 与 fast 同时走
当 fast 走到链表尾的时候 slow 也走到了相应的位置。
*/

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0)
            return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast = preHead;
        while(k > 0 && fast != null){
            fast = fast.next;
            k --;
        }
        if(fast == null)
            return null;
        ListNode slow = preHead;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}