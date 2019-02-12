/*
算法思想：根据前序遍历规则完成序列化与反序列化。
所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。
当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
另外，结点之间的数值用逗号隔开。
也就是，使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点
不为空时，在转化val所得的字符之后添加一个','作为分割。对于空节点则以'#'代替。
*/
public class Solution {
    int index = -1;   
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        index ++;      // 此式一定要在这个函数的最前面，因为 if中递归需要先 index自增
        if(str == null)
            return null;
        String[] strs = str.split(",");
        if(index >= strs.length  )
            return null;
        TreeNode node = null;
        if(strs[index].equals("#") == false){      // 不为null 
            node = new TreeNode(Integer.valueOf(strs[index]));  // 按照前序遍历重建
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        //  index ++;     放到后面的话，index自增就不会对递归调用产生影响
        return node;
    }
}