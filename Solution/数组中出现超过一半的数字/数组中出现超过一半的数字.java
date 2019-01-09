/*
利用 HashMap 存储即可
*/

import java.util.HashMap;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i = 0 ; i < array.length ; i ++){
            if(hashmap.containsKey(array[i]) == false){
                hashmap.put(array[i] , 1);
            }
            else{
                hashmap.put(array[i] , hashmap.get(array[i]) + 1);
            }
        }
        for(int num : hashmap.keySet() ){
            if( hashmap.get(num) > array.length / 2)
                return num;
        }
        return 0;
    }
}