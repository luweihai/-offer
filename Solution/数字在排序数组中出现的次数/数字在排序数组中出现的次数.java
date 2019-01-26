/*
思路很简单，就是利用二分查找找到第一个结点和最后一个结点，然后计算其差值即可
注意二分查找的时候，要判断前一个和后一个是否也是我们要找的值
*/



public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length-1);
        int lastK = getLastK(array, k, 0, length-1);
        if(firstK != -1 && lastK != -1){
             return lastK - firstK + 1;
        }
        return 0;
    }
    //递归写法
    private int getFirstK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] > k){
            return getFirstK(array, k, start, mid-1);
        }
        else if (array[mid] < k){
            return getFirstK(array, k, mid+1, end);
        }
        else if(mid - 1 >= 0 && array[mid - 1] == k){    // 此处要注意这个 mid - 1 是要判断的
            return getFirstK(array, k, start, mid - 1);
        }
        else{
            return mid;
        }
    }
    //循环写法
    private int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) / 2 ;
        while(start <= end){
            if(array[mid] > k){
                end = mid - 1;
            }
            else if(array[mid] < k){
                start = mid + 1;
            }
            else if(mid + 1 < length && array[mid + 1] == k){   // 此处要注意 mid + 1是要判断的
                start = mid + 1;
            }
            else{
                return mid;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }
}