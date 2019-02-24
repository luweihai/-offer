/*
就和普通的两个数之和差不多,注意左右夹逼，根据抛物线的性质，遇到的第一组是乘积最小的
*/

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length == 0)
            return result;
        int left = 0 , right = array.length - 1;
        while(left < right){
            if(array[left] + array[right] == sum){
                result.add(array[left]);
                result.add(array[right]);
                return result;
            }
            else if(array[left] + array[right] < sum)
                left ++;
            else
                right --;
        }
        return result;
    }
}