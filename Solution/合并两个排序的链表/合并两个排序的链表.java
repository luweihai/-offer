/*
利用尾插法
当一个链表的全部结点都被访问过的时候，还要判断另外一个链表的结点是否全部都被访问过
如果没有被访问过，就全部插入到结果链表的最后面
*/

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode result = new ListNode(0);
        ListNode q = result;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while( p1 != null && p2 != null){
            if(p1.val < p2.val){
                q.next = p1;
                p1 = p1.next;
            }
            else{
                q.next = p2;
                p2 = p2.next;
            }
            q = q.next;
        }
        if( p1 == null){
            while(p2 != null){
                q.next = p2;
                p2 = p2.next;
                q  = q.next;
            }
        }
        if( p2 == null){
            while(p1 != null){
                q.next = p1;
                p1 = p1.next;
                q = q.next;
            }
        }
        return result.next;
    }
}