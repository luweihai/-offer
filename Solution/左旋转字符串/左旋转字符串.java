/*
分割为两个字符串然后拼接就可以了啊
但是，一般还是不能投机取巧。
记得以前有个例子是左移数组，其实这个例子也是一样
把字符串转化为数组，然后左边部分反转，右边部分反转，再整体反转即可
*/


public class Solution {
    public String LeftRotateString(String str,int n) {
        char[] chars = str.toCharArray();        
        if(chars.length < n) 
            return "";
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);
        StringBuilder sb = new StringBuilder(chars.length);
        for(char c : chars){
            sb.append(c);
        }
        return sb.toString();
    }
     
    public void reverse(char[] chars,int low,int high){
        char temp;
        while(low<high){
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}





// 投机取巧的做法，面试不一定能过
public class Solution {
    public String LeftRotateString(String str,int n) {
        //保证旋转的位数大于字符串的长度，否则返回空字符串
        if(str.length() < n)
            return "";
        //把原字符串截取成俩字符串，然后拼接
        String s1 = str.substring(0, n);
        String s2 = str.substring(n,str.length());
        return s2 + s1;
    }
}