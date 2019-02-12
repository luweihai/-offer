/*
利用数组模拟圆圈，注意数组的下标重新置0
此外，注意被删除的元素在数组中被设置为 -1
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