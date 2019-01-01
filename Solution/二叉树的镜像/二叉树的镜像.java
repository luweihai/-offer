/*
先左右子树交换，然后再分别递归左右子树
*/

public class Solution {
    public void Mirror(TreeNode root) {
        TreeNode temp = null;
        if (root != null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null)
                Mirror(root.left);
            if (root.right != null)
                Mirror(root.right);
        }
    }
}