/*
左子树的左子树 与 右子树的右子树对称，左子树的右子树 与 右子树的左子树对称
*/

public class Solution {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null )
            return true;
        if(pRoot.left == null && pRoot.right == null)
            return true;
        if(pRoot.left == null || pRoot.right == null)
            return false;
        return judge(pRoot.left , pRoot.right);
    }
    boolean judge(TreeNode left , TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val )
            return false;
        boolean judge_1 = judge(left.left , right.right);
        boolean judge_2 = judge(left.right , right.left);
        return judge_1 && judge_2;
    }
}