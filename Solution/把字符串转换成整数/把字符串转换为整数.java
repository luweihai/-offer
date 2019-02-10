/*
（1）利用 trim() 函数对字符串去除其首尾的空格，必须要放在第一句
（2）设置 positive 判断数字的正负
（3）注意 for 循环的 i 是在外面定义的
（4）正数和负数的求和方法有一个符号的差别
*/



public class Solution {
    public int StrToInt(String str) {
        str = str.trim();
        if(str == null || str.length() == 0)
            return 0;
        boolean positive = true;
        double result = 0;
        int i = 0;
        if(str.charAt(i) == '-'){
            positive = false;
            i ++;
        }
        else if(str.charAt(i) == '+'){
            positive = true;
            i ++;
        }
        else if(str.charAt(i) < '0' || str.charAt(i) > '9' ){
            return 0;
        }
        for(  ; i < str.length() ; i ++){
            int digit = str.charAt(i) - '0';
            if(digit > 9 || digit < 0)
                return 0;
            if( positive == true){
                result = result * 10 + digit;
            }
            else{
                result = result * 10 - digit;
            }
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)result;
    }
}