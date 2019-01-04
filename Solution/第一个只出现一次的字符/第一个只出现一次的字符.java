/*
思路很简单，就是先利用 HashMap遍历一遍并且存储
如果某个元素是第二次甚至多次出现，就把其索引改为 -1
最后再遍历一遍，索引不为 -1 就输出
*/


import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        HashMap<Character , Integer> hashmap = new HashMap<>();
        for(int i = 0 ; i < str.length() ; i++){
            if(hashmap.containsKey(str.charAt(i)) == true){
                hashmap.put(str.charAt(i) , -1 );
            }
            else{
                hashmap.put(str.charAt(i) , i);
            }
        }
        for(int i = 0 ; i < str.length() ; i ++){
            if(hashmap.get(str.charAt(i)) != -1){
                return hashmap.get(str.charAt(i));
            }
        }
        return -1;
    }
}