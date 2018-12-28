/*
我们观察二维数组，可以发现从左到右，从上到下，元素的大小是依此增大的。
所以我们先从右上角出发，要是当前元素等于 target就直接返回，要是大于 target 
就将当前位置往左边移动一个单位（因为当前位置的下面和右边的元素都比当前位置元素大，可以丢弃）
要是小于 target 就将当前位置往下面移动一个单位（因为当前位置上面的元素都比当前位置小）
*/


public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0 )
            return false;
        int row =  0;       // 从右上角开始寻找
        int col = array[0].length - 1 ;
        while( row < array.length && col >= 0 ){
            if(array[row][col] == target){
                return true;
            }
            else if(array[row][col] < target ){  //当前位置下移，因为下面的元素更大
                row ++;
            }
            else{                   // 当前位置左移，因为左边的元素更小
                col --;
            }
        }
        return false;
    }
}