/*
先左右子树交换，然后再分别递归左右子树，反过来也可以
*/

public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null)
            return ;
        if(root.left == null && root.right == null)
            return ;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}