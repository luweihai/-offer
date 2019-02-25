/*
Double.parseDouble() 类似于 Integer.parseInt() 方法，只是换成了 double，得到一个 Double对象
*/


public class Solution {
    public boolean isNumeric(char[] str) {
        try{
            double result = Double.parseDouble(String.valueOf(str));
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
}