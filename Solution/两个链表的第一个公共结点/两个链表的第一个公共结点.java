/*
因为链表只要有一个结点相同，后续的结点肯定也是相同的
所以我们先分别求出两个链表的长度，然后计算长度差div，让长度更长的链表先走div 步
这样两个链表的剩余结点数就相同了
再逐步进行判断就可以了
*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        while( p1 != null){
            p1 = p1.next;
            len1 ++;
        }
        while( p2 != null){
            p2 = p2.next;
            len2 ++;
        }
        p1 = pHead1;
        p2 = pHead2;
        if(len1 < len2){
            int div = len2 - len1;
            while( div > 0){
                p2 = p2.next;
                div --;
            }
        }
        else{
            int div = len1 - len2;
            while(div > 0){
                p1 = p1.next;
                div --;
            }
        }
        while(p1 != p2 ){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}