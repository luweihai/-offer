/*
首先，StringBuffer 也有与String相同的 length() charAt()  indexOf()等方法
还有 setCharAt(index , char )   insert(index , String )  append(String )  delete(start , end )等方法

我们先遍历一遍找到字符串中的全部的空格并且计数
然后从右边到左边遍历，遍历的过程中遇到 空格 ' ' 就替换成 '%' ，然后加入 "20"
*/


public class Solution {
    public String replaceSpace(StringBuffer str) {
    	if(str == null || str.length() == 0)
            return "";
        int count = 0;
        for(int i = 0 ; i < str.length() ; i ++){
            if(str.charAt(i) == ' ')
                count ++;
        }
        for(int i = str.length() - 1 ; i >= 0 ; i --){
            if(str.charAt(i) == ' '){
                str.setCharAt(i , '%');
                str.insert(i + 1 , "20");
            }
        }
        return str.toString();
    }
}