/*
标准的回溯解法，注意只能是叶子结点才满足要求。
这种回溯也尽量用 list.add()  list.remove() 的模板，容易理解
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        if(root.val == target && root.left == null && root.right == null){
            result.add(new ArrayList<Integer>(list));
            return result;
        }
        search(root , target , result , list);
        return result;
    }
    public void search(TreeNode root , int sum , ArrayList<ArrayList<Integer>> result , ArrayList<Integer> list){
        if(sum < 0)
            return;
        if(root.val == sum && root.left == null && root.right == null){
            result.add(new ArrayList<Integer>(list));
            return ;
        }
        if(root.left != null){
            list.add(root.left.val);
            search(root.left , sum - root.val , result , list);
            list.remove(list.size() - 1);
        }
        if(root.right != null){
            list.add(root.right.val);
            search(root.right , sum - root.val , result , list );
            list.remove(list.size() - 1);
        }
    }
}








