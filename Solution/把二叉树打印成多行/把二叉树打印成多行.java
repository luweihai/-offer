/*
简单的层次遍历的模板
*/

import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = pRoot;
        queue.offer(p);
        int curCount = 1;
        int nextCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(queue.isEmpty() == false){
            p = queue.poll();
            curCount --;
            list.add(p.val);
            if(p.left != null){
                queue.offer(p.left);
                nextCount ++;
            }
            if(p.right != null){
                queue.offer(p.right);
                nextCount ++;
            }
            if(curCount == 0){
                curCount = nextCount;
                nextCount = 0;
                result.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        return result;
    }
}