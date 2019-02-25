/*
从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
返回1 + 4 个方向的探索值之和。
探索时，判断当前节点是否可达的标准为：
1）当前节点在矩阵内；
2）当前节点未被访问过；
3）当前节点满足limit限制。
*/


public class Solution {
    int count = 0;
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag = new boolean[rows][cols];
        dfs(threshold , 0 , 0 , rows , cols , flag );
        return count;
    }
    public void dfs(int threshold , int i , int j , int rows , int cols , boolean[][] flag){
        if(i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] ){
            return ;
        }
        if( num(i) + num(j) > threshold )
            return ;
        count ++;
        flag[i][j] = true;
        dfs(threshold , i + 1 , j , rows , cols , flag);
        dfs(threshold , i - 1 , j , rows , cols , flag);
        dfs(threshold , i , j + 1 , rows , cols , flag);
        dfs(threshold , i , j - 1 , rows , cols , flag);
    }
    public int num(int n){
        if(n == 0)
            return 0;
        int result = 0;
        while(n != 0){
            result = result + (n % 10);
            n = n / 10;
        }
        return result;
    }
}