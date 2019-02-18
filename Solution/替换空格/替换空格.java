/*
首先，StringBuffer 也有与String相同的 length() charAt()  indexOf()等方法
还有 setCharAt(index , char )   insert(index , String )  append(String )  delete(start , end )等方法

我们先遍历一遍找到字符串中的全部的空格并且计数
然后从右边到左边遍历，遍历的过程中遇到 空格 ' ' 就替换成 '%' ，然后加入 "20"
*/


/*
最简单的办法，新建一个 StringBuffer，然后从原先StringBuffer逐个扫描判断是否是 " "就可以了
*/
public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char b = str.charAt(i);
            if(String.valueOf(b).equals(" ")){
                out.append("%20");
            }
            else{
                out.append(b);
            }
        }
        return out.toString();     
    }
}


//  利用正则表达式中 和 String 的 replaceAll()方法
public class Solution {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }
}





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