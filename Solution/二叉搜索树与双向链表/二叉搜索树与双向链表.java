/*
1.将左子树构造成双链表，并返回链表头节点。
2.定位至左子树双链表最后一个节点。
3.如果左子树链表不为空的话，将当前root追加到左子树链表。
4.将右子树构造成双链表，并返回链表头节点。
5.如果右子树链表不为空的话，将该链表追加到root节点之后。
6.根据左子树链表是否为空确定返回 left 还是 root
*/



public class Solution {
    public TreeNode Convert(TreeNode root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        TreeNode left = Convert(root.left);
        if(left != null){
            TreeNode pre = root.left;
            while(pre != null && pre.right != null){
                pre = pre.right;
            }
            pre.right = root;
            root.left = pre;
        }
        TreeNode right = Convert(root.right);
        if(right != null){
            right.left = root;
            root.right = right;
        }
        if(left != null)  // 这个 if - else 是值得注意的点
            return left;
        else
            return root;
    }
}