/*
简单的层次遍历，记住层次遍历的代码
*/

import java.util.ArrayList;
import java.util.*;
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        int curCount = 1;
        int nextCount = 0;
        queue.offer(root);
        TreeNode pointer ;
        while(queue.isEmpty() == false){
            pointer = queue.poll();
            curCount -- ;
            result.add(pointer.val);
            if(pointer.left != null){
                queue.offer(pointer.left);
                nextCount ++;
            }
            if(pointer.right != null){
                queue.offer(pointer.right);
                nextCount ++;
            }
            if(curCount == 0){
                curCount = nextCount;
                nextCount = 0;
            }
        }
        return result;
    }
}