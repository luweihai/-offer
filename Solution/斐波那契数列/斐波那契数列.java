/*
（1）题目中要求从第0项开始，第0项为0，第1项为1
（2）使用数组比递归的效率更高
*/


public class Solution {
    public int Fibonacci(int n) {
        int[] dp = new int[n];
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i < n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}