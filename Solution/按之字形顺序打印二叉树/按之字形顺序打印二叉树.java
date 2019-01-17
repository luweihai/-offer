/*
* 基本和层次遍历一样，中间利用一个 flag 和 Collections.reverse() 实现反转
*/


class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null )
            return result;
        zigzagLeverOrderCore(root , result );
        return result;
    }
    public void zigzagLeverOrderCore( TreeNode root , ArrayList<ArrayList<Integer>> result ){
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode pointer = null;
        int curCount = 1;
        int nextCount = 0;
        boolean flag = false ;    // false 表示 不反转 ， true 表示反转  
        while( queue.isEmpty() == false ){
            pointer = queue.poll();
            curCount --;
            temp.add(pointer.val);
            if( pointer.left != null){
                queue.offer( pointer.left);
                nextCount ++;
            }
            if( pointer.right != null){
                queue.offer( pointer.right );
                nextCount ++;
            }
            if( curCount == 0 ){
                if(flag == true){
                    Collections.reverse(temp);  //反转
                    curCount = nextCount;
                    nextCount = 0;
                    result.add(new ArrayList<Integer>(temp) );
                    temp.clear();
                    flag = false;
                }
                else{
                    curCount = nextCount;
                    nextCount = 0;
                    result.add(new ArrayList<Integer>(temp) );
                    temp.clear();
                    flag = true;
                }
            }
        }
    }
}