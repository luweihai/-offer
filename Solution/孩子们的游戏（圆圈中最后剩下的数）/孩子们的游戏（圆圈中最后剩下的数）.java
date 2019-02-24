/*
利用数组模拟圆圈，注意数组的下标重新置0
外层循环是只要没有全部被删除就循环。
利用count记录剩余没有被删除，step记录当前一轮循环走过的有效的距离，注意要跳过已经被删除的
注意这个 i 是从 -1 开始，而且 i ++ 的位置要求很苛刻
*/


public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)
            return -1;
        int[] array = new int[n];
        int i = -1 , step = 0 , count = n;   // i是第i个孩子的编号
        while(count > 0){   // 跳出循环时，最后一个元素也被设置为 -1
            i ++;
            if(i >= n)
                i = 0;
            if(array[i] == -1)   // 跳过已经被删除的对象
                continue;
            step ++;         // step 记录当前循环走过的人数
            if(step == m){    // 找到了要删除的对象
                array[i] = -1;
                step = 0;
                count --;
            }
        }
        return i;   // 返回最后一个被设置为 -1 的元素
    }
}