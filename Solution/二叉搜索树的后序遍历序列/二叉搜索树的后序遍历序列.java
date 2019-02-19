/*
（1）空树不为二叉搜索树
（2）二叉搜索树的后序遍历，根结点的值在最右边。也就是说，除了根结点以为的序列的部分
    一半是小于根结点，一半是大于根结点的。
（3）从右边往左边找到最右边的一个左子树的结点，然后判断从左边到这个结点的所有元素的
    值是不是都小于 root的值
*/




public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        if(sequence.length == 1)
            return true;
        return judge(sequence , 0 , sequence.length - 1);
    }
    public boolean judge(int[] sequence , int left , int root){
        if(left >= root)
            return true;
        int i = root - 1;   // 从右边往左边找最右的左子树结点，注意是从 root左边第一个位置开始
        while( sequence[i] > sequence[root] && i > left ){
            i --;
        }
        for(int j = left ; j < i  ; j ++){  // j 是不能到 i 的
            if(sequence[j] > sequence[root])
                return false;
        }
        return judge(sequence , left , i ) && judge(sequence , i  , root - 1);
    }
}