/*
使用一个HashMap来统计字符出现的次数,然后去 hashmap中查找。
*/


import java.util.*;
public class Solution {
    HashMap<Character, Integer> hashmap = new HashMap();
    
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(hashmap.containsKey(ch)){
            hashmap.put(ch , hashmap.get(ch) + 1);
        }
        else{
            hashmap.put(ch , 1);
        }
    }
     
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {   
        for(char key : list){
            if(hashmap.get(key)== 1){
                return key;
            }
        }
        return '#';
    }
}