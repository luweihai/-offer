/*
就和普通的两个数之和差不多
*/

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array == null || array.length == 0)
            return result;
        int left = 0;
        int right = array.length - 1;
        int mul = Integer.MAX_VALUE;
        while(left < right){
            if(array[left] + array[right] == sum ){
                if(array[left] * array[right] < mul){
                    mul = array[left] * array[right];
                    result.add(array[left]);
                    result.add(array[right]);
                }
                left ++;
                right --;
            }
            else if(array[left] + array[right] < sum)
                left ++;
            else 
                right --;
        }
        return result;
    }
}