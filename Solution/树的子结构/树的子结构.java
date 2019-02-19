/*
1、首先设置标志位result = false，因为一旦匹配成功result就设为true，
剩下的代码不会执行，如果匹配不成功，默认返回false
2、递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（），
如果根节点不相同，则判断tree1的左子树和tree2是否相同，
再判断右子树和tree2是否相同
3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
tree1_Has_Tree2中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功，
tree1为空有两种情况（1）如果tree1为空&&tree2不为空说明不匹配，
（2）如果tree1为空，tree2为空，说明匹配成功。
 并且一定要 tree2判断在 tree1判断的前面
*/



public class Solution {
    boolean result = false;
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)   // 题目要求:空树不是任意一个树的子结构
            return false;
        if(root1.val == root2.val){  // 根的值不同就没必要判断了
            result = judge(root1 , root2);
        }
        if(result == false){
            result = HasSubtree(root1.left , root2);
        }
        if(result == false){
            result = HasSubtree(root1.right , root2);
        }
        return result;
    }
    
    // 下面 judge方法判断以 root1为根的树是否包含以 root2 为根的树,但是此处 root2为空也算子树，因为表示递归完成了
    //  一定要从递归的角度去理解这个 judge方法
    public boolean judge(TreeNode root1 , TreeNode root2){
        if(root2 == null)      //  root2 为空 则说明 root2遍历完了，完全匹配到了 root1 ，区分题中要求“空树不是任何树的子树”
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)   // 我们限定了一定要以 root1 和 root2 为根
            return false;
        boolean judge_Left = judge(root1.left , root2.left);
        boolean judge_Right = judge(root1.right , root2.right);
        return judge_Left && judge_Right;
    }
}