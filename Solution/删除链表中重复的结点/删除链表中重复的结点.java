/*
（1）新建一个头结点要方便得多
（2）要是 p.val == p.next.val ，就再用一层循环把相同值的结点全部跳过
（3）很奇怪的是，pre.next = p 这句话一定要是在跳出循环的位置
*/



public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode pointer = pHead;
        while(pointer != null && pointer.next != null){
            if( pointer.val == pointer.next.val){
                int val = pointer.val;
                while( pointer != null && pointer.val == val ){
                    pointer = pointer.next;
                }
                pre.next = pointer;     // 记住这句一定要加在这里
            }
            else{
                //   pre.next = pointer;      为什么这句写在这里，最后加上 pre.next = null 过不了
                pre = pointer;
                pointer = pointer.next;
            }
        }
        return newHead.next;
    }
}