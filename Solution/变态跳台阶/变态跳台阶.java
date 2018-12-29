/*
要理解题目的意思，既然每次可以跳不限制个台阶，那么每次个台阶都可以从底下其他全部的位置跳上来
利用 dp[]数组存储跳到当前台阶的方法数目
也就有  dp[n] = dp[n - 1] + dp[n - 2] + ... + dp[1] + dp[0]
*/

public class Solution {
    public int JumpFloorII(int target) {
        int dp[] = new int[target];
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 0 ; i < target ; i ++){
            for(int j = 0 ; j < i ; j ++){
                dp[i] = dp[i] + dp[j];
            }
        }
        return dp[target - 1];
    }
}