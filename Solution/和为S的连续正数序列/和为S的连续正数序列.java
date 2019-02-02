/*
双指针,就是相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。
*/


import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum <= 0 )
            return result;
        int low = 1;
        int high = 2;
        while(high > low){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int temp = (low + high) * (high - low + 1) / 2;
            if(temp == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = low ; i <= high ; i ++){
                    list.add(i);
                }
                result.add(new ArrayList<Integer>(list));
                high ++;     // 此处 low++ 或者 high++ 都可以过
            }
            else if(temp < sum){    //当前和比sum 小，移动 high
                high ++;
            }
            else{    // 当和比sum 大，移动 low
                low ++;
            }
        }
        return result;
    }
}