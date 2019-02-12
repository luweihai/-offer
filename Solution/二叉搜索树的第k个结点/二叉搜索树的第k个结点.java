/*
二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
所以，按照中序遍历顺序找到第k个结点就是结果。
*/
public class Solution {
    int index = 0; //计数器
    TreeNode KthNode(TreeNode root, int k)
    {
        if(root != null){   //中序遍历寻找第k个
            TreeNode node = KthNode(root.left , k);
            if(node != null)   // 注意此处是不为 null 就返回，要理解这里的意思
                return node;
            index ++;         // 中序遍历，在中间判断就可以了
            if(index == k)
                return root;
            node = KthNode(root.right , k);
            if(node != null)  // 注意此处是不为 null 就返回，要理解这里的意思
                return node;
        }
        return null;
    }
}