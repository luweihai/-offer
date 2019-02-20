/*
list也有contains()方法，不一定要用Set，但是理论上用Set的效率更高
注意题中要按照字典顺序输出，所以要排序
全排列的代码一定要理解，并且能够背出来
*/

import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length() == 0)
            return result;
        char[] array = str.toCharArray();
        dfs(array , result , 0);
        Collections.sort(result);   // 因为要按照字典顺序排序
        return result;
    }
    public void dfs(char[] array , ArrayList<String> result , int start ){
        if(start == array.length){
            String temp = String.valueOf(array);   // String.valueOf(char[] ) 字符数组转字符串
            if(result.contains(temp) == false)   // 因为字符会重复，所以要保证不出现重复的结果
                result.add(temp);
        }
        for(int i = start ; i < array.length ; i ++){
            swap(array , start , i);
            dfs(array , result , start + 1); // 注意这里是从 start + 1 开始的，要理解为什么从 start+1 开始
            swap(array , start , i);
        }
    }
    public void swap(char[] array , int left , int right){
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}