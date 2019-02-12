/*
（1）如果此结点有右子树，则找到右子树的最左边结点
（2）如果此结点没有右子树，则往父结点走，直到途中某结点是其父节点的左子树
*/


public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) 
            return null;
        if(pNode.right != null){    //如果有右子树，则找右子树的最左节点
            pNode = pNode.right;
            while(pNode.left != null) 
                pNode = pNode.left;
            return pNode;
        }
        while(pNode.next != null){    // 没右子树，则找第一个当前节点是父节点左孩子的节点
            if(pNode.next.left == pNode) 
                return pNode.next;
            pNode = pNode.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }
}