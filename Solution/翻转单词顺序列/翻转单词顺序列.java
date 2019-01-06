/*
利用 String.split(String regex) 进行字符串的分割
注意，如果一个字符串仅有空格，就不用切割，直接返回自己
尽量用 StringBuffer或者 StringBuilder 
而不是想办法让字符串数组交换然后生成字符串
*/


public class Solution {
    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0)
            return str;
        if(str.trim().equals(""))
            return str;
        String[] arr = str.split(" ");
        StringBuffer result = new StringBuffer();
        for(int i = arr.length - 1 ; i >= 0 ; i --){
            result.append(arr[i]);
            if(i > 0)
                result.append(" ");
        }
        return result.toString();
    }
}