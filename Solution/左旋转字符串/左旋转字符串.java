/*
分割为两个字符串然后拼接就可以了啊
但是，一般还是不能投机取巧。
记得以前有个例子是左移数组，其实这个例子也是一样
把字符串转化为数组，然后左边部分反转，右边部分反转，再整体反转即可
*/


public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 )
            return "";
        char[] arr = str.toCharArray();
        invert(arr , 0 , str.length() - 1);  
        invert(arr , 0 , str.length() - n - 1);   // 要想清楚循环左移3位 应该反转哪些字符，用纸模拟下
        invert(arr , str.length() - n  , str.length() - 1);
        return String.valueOf(arr);
    }
    public void invert(char[] arr , int left , int right){
        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
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