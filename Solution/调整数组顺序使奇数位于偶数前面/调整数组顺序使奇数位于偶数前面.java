/*
如果不考虑交换后的顺序，可以用后面的解法
要是考虑交换后的顺序不能改变，要么是 O(n²)的时间复杂度，要么是开一个数组，空间换时间
新开一个数组，原数组分别从头和从尾遍历，新数组也是两个指针从头和从尾遍历
注意最后不能直接 array = temp   这样 array是没改变的
*/


public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0)
            return ;
        int[] temp = new int[array.length];
        int old = 0;   // 奇数索引
        int even = array.length - 1; // 偶数索引
        for(int i = 0 ; i < array.length ; i ++){
            if(array[i] % 2 == 1){
                temp[old ++ ] = array[i];
            }
        }
        for(int i = array.length - 1 ; i >= 0 ; i --){
            if(array[i] % 2 == 0){
                temp[even -- ] = array[i];
            }
        }
        for(int i = 0 ; i < array.length ; i++)
            array[i] = temp[i];
    }
}



// 此处交换后的顺序改变了，是错误的解答，但值得借鉴
public class Solution {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0)
            return ;
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            while(array[left] % 2 == 1){
                left ++;
            }
            while(array[right] % 2 == 0){
                right --;
            }
            swap(array , left , right );
            left ++;
            right --;
        }
    }
    public void swap(int[] array , int left , int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}