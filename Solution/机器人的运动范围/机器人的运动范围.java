/*
从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
返回1 + 4 个方向的探索值之和。
探索时，判断当前节点是否可达的标准为：
1）当前节点在矩阵内；
2）当前节点未被访问过；
3）当前节点满足limit限制。
*/



public class Solution {
 
    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols];   //记录是否已经走过
        return helper(0, 0, rows, cols, flag, threshold);
    }
 
    public int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j)  > threshold || flag[i][j] == 1) return 0;    
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
            + helper(i + 1, j, rows, cols, flag, threshold)
            + helper(i, j - 1, rows, cols, flag, threshold)
            + helper(i, j + 1, rows, cols, flag, threshold)
            + 1;
    }
 
    public int numSum(int t) {
        int count = 0;
        while (t != 0){
            count = count + (t % 10);
            t = t / 10;
        }
        return  count;
    }
}