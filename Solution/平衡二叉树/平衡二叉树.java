/*
先求左右子树的高度，如果高度差大于1 就为 false
再递归的判断左右子树
*/


public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        int left_Height = height(root.left);
        int right_Height = height(root.right);
        if(Math.abs(left_Height - right_Height) > 1)
            return false;
        boolean left_Judge = IsBalanced_Solution(root.left);
        boolean right_Judge = IsBalanced_Solution(root.right);
        return left_Judge && right_Judge;
    }
    public int height(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int left = height(root.left);
        int right = height(root.right);
        if(left > right)
            return left + 1;
        else
            return right + 1;
    }
}