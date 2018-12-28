/*
（1）此题可以用递归，见方法2 。递归的话，就要在全局设置 ArrayList，这样才可以一直用到同一个 List。
    递归的代码只是把书上的打印部分换成了添加进 list的操作。
    注意此处尽管方法会有返回值，但是我们不需要用这个返回值。 这是一个关键的点
（2）可以投机取巧，利用 ArrayList 的 add(0 , val) 实现每次在第一个位置插入也就实现了逆置
*/

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode == null)
            return result;
        while(listNode != null){
            result.add( 0 , listNode.val);    // 头插法
            listNode = listNode.next;
        }
        return result;
    }
}

public class Solution {
    ArrayList<Integer> result=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null){
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);         // 书上只是把此处换成了打印的操作 
        }
        return result;
    }
} 