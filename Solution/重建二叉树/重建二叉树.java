/*
（1）利用 HashMap存储中序遍历每个元素的位置索引，提高后面查找的效率
（2）注意 build方法有6个参数
（3）root.left、root.right构建的时候的下标要想清楚，right可以利用left的结论
*/


import java.util.HashMap;
public class Solution {
    HashMap<Integer,Integer> hashmap = new HashMap<>();  // 找到中序遍历中每个元素的位置
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null)
            return null;
        for(int i = 0 ; i < in.length ; i ++){
            hashmap.put(in[i] , i);
        }
        TreeNode root = build(pre , 0 , pre.length - 1 , in , 0 , in.length - 1);
        return root;
    }
    public TreeNode build(int[] pre , int preLeft , int preRight , int[] in , int inLeft , int inRight){
        if(preLeft > preRight && inLeft > inRight)
            return null;
        TreeNode root = new TreeNode(pre[preLeft]);
        int index = hashmap.get(root.val);    // 找到中序遍历中的root
        root.left = build(pre , preLeft + 1 , preLeft  + index - inLeft  , in , inLeft , index - 1 );
        root.right = build(pre , preRight - (inRight - index - 1 )  , preRight , in , index + 1 , inRight );
        return root;
    }
}