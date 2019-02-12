/*
使用一个HashMap来统计字符出现的次数，同时用一个ArrayList来记录输入流。
每次返回第一个出现一次的字符都是在这个ArrayList（输入流）中的字符作为 key 去 hashmap中查找。
*/


import java.util.*;
public class Solution {
    HashMap<Character, Integer> hashmap = new HashMap();
    ArrayList<Character> list = new ArrayList<Character>();
    
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(hashmap.containsKey(ch)){
            hashmap.put(ch , hashmap.get(ch) + 1);
        }
        else{
            hashmap.put(ch , 1);
        }
        list.add(ch);
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