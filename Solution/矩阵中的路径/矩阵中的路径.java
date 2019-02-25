/*
其实就是简单的回溯算法，中间利用一个标志数组（矩阵搜索是二维数组，但是此处输入矩阵为一维表示二维）表示矩阵中某个元素是否被访问。
然后再往上下左右四个方向进行深度优先搜索即可
*/

public class Solution {
    boolean[][] flag ;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {    
        flag = new boolean[rows][cols];
        for(int i = 0 ; i < rows ; i ++){
            for(int j = 0 ; j < cols ; j ++){
                boolean result = dfs(matrix , i , j , rows , cols , str , 0 );
                if(result == true)
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[] matrix , int i,int j,int rows,int cols , char[] str,int start){
        int index = i * cols + j;   // 关键是这一步
        if(i < 0 || j < 0 || i>= rows || j>= cols || matrix[index] != str[start] || flag[i][j] == true)  
            return false;
        if(start == str.length - 1)
            return true;
        flag[i][j] = true;
        boolean result =  dfs(matrix , i + 1 , j , rows , cols , str , start + 1 ) ||
                          dfs(matrix , i - 1 , j , rows , cols , str , start + 1) ||
                          dfs(matrix , i , j + 1 , rows , cols , str , start + 1) ||
                          dfs(matrix , i , j - 1 , rows , cols , str , start + 1);
        flag[i][j] = false;
        return result;
    }
}