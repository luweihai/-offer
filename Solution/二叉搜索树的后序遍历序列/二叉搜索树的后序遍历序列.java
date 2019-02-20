/*
（1）空树不为二叉搜索树
（2）二叉搜索树的后序遍历，根结点的值在最右边。也就是说，除了根结点以为的序列的部分
    一半是小于根结点，一半是大于根结点的。
（3）从右边往左边找到最右边的一个左子树的结点，然后判断从左边到这个结点的所有元素的
    值是不是都小于 root的值
*/




public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)  // 空的话不为任何树的后序遍历序列
            return false;
        if(sequence.length == 1)
            return true;
        boolean result = judge(sequence , 0 , sequence.length - 1);
        return result;
    }
    public boolean judge(int[] sequence , int left , int root){
        if(left >= root){
            return true;
        }
        int index = root - 1;     // index是左子树的最右边的结点， 从右边往左边找最右的左子树结点，注意是从 root左边第一个位置开始
        while(sequence[index] > sequence[root] && index > left){ 
            index --;
        }
        for(int i = left ; i < index ; i ++){
            if(sequence[i] > sequence[root])
                return false;
        }
        return judge(sequence , left , index) && judge(sequence , index + 1 , root - 1);
    }
}