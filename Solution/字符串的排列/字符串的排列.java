/*
list也有contains()方法，不一定要用Set，但是理论上用Set的效率更高
注意题中要按照字典顺序输出，所以要排序
全排列的代码一定要理解，并且能够背出来
*/

import java.util.ArrayList;
import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length() == 0 )
            return result;
        char[] arr = str.toCharArray();
        dfs(result , arr , 0 );
        Collections.sort(result);
        return result;
    }
    public void dfs(ArrayList<String> result , char[] arr , int start ){
        if(start == arr.length ){
            StringBuffer s = new StringBuffer();
            for(int i = 0 ; i < arr.length ; i ++){
                s.append(arr[i]);
            }
            String temp = s.toString();
            if(result.contains(temp) == false)
                result.add(temp);
        }
        for(int i = start ; i < arr.length ; i++){
            swap(arr , i , start);
            dfs(result , arr , start + 1);       // 注意这里是从 start + 1 开始的 
            swap(arr , i , start);
        }
    }
    public void swap(char[] arr , int i , int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}