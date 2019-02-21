/*
思路很简单，就是先利用 HashMap遍历一遍并且存储
如果某个元素是第二次甚至多次出现，就把其索引改为 -1
最后再遍历一遍，索引不为 -1 就输出
但是要注意，一定要用LinkedHashMap，不然顺序没法保证
*/


import java.util.LinkedHashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        LinkedHashMap<Character , Integer> hashmap = new LinkedHashMap<>();
        for(int i = 0 ; i < str.length() ; i ++){
            char ch = str.charAt(i);
            if(hashmap.containsKey(ch)){
                hashmap.put(ch , -1);
            }
            else{
                hashmap.put(ch , i);
            }
        }
        for(char c : hashmap.keySet()){
            if(hashmap.get(c) != -1){
                return hashmap.get(c);
            }
        }
        return -1;
    }
}