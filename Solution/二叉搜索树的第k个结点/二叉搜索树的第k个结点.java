/*
二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
所以，按照中序遍历顺序找到第k 个结点就是结果。
要理解中序遍历的代码，如果在左子树找的结果不为null,就返回。
然后判断根节点，根结点符合要求就返回
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