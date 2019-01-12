/*
1、首先设置标志位result = false，因为一旦匹配成功result就设为true，
剩下的代码不会执行，如果匹配不成功，默认返回false
2、递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（），
如果根节点不相同，则判断tree1的左子树和tree2是否相同，
再判断右子树和tree2是否相同
3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
tree1_Has_Tree2中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功，
tree1为空有两种情况（1）如果tree1为空&&tree2不为空说明不匹配，
（2）如果tree1为空，tree2为空，说明匹配。
 
*/



public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root2 == null)    // 题目要求:空树不是任意一个树的子结构
            return false;
        if(root1 == null)
            return false;
        if(root1.val == root2.val){
            result = tree1_Has_Tree2(root1 , root2);
        }
        if(result == false){
            result = HasSubtree(root1.left , root2);
        }
        if(result == false){
            result = HasSubtree(root1.right , root2);
        }
        return result;
    }
    // 下面的方法是判断具有相同根的 root1 和 root2 是否满足 root1 包含 root2
    public boolean tree1_Has_Tree2(TreeNode root1 , TreeNode root2){
        if(root2 == null)  // 如果 tree2为空，则说明第二棵树遍历完了，即匹配成功
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val){
            return false;
        }
        boolean judge_Left = tree1_Has_Tree2(root1.left , root2.left);
        boolean judge_Right = tree1_Has_Tree2(root1.right , root2.right);
        return judge_Left && judge_Right;
    }
}