/*
max 记录 最大值
min 记录  最小值
min , max 都不记0
满足条件 
（1）max - min < 5
（2）除0外没有重复的数字(牌)
（3）数组长度 为5
*/



import java.util.*;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5)
            return false;
        HashSet<Integer> hashset = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < numbers.length ; i ++){
            if(numbers[i] < 0 || numbers[i] > 13)
                return false;
            if(numbers[i] == 0){    // 不记录 0 
                continue;
            }
            else{
                if(hashset.contains(numbers[i])){  // 存在非0重复元素
                    return false;
                }
                else{
                    hashset.add(numbers[i]);
                }
                if(numbers[i] > max)   // 更新 max
                    max = numbers[i];
                if(numbers[i] < min)    // 更新 min
                    min = numbers[i];
            }
        }
        if(max - min < 5)    // 最大值减去最小值大于5
            return true;
        else
            return false;
    }
}