/*
思路：
为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
*/



import java.util.*;
public class Solution {
    
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();  
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){  //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
        public int compare(Integer o1 , Integer o2){
            return o2 - o1;
        }
    });
    
    public void Insert(Integer num) {
        count ++;

        if( (count % 2) == 0 ){  //当数据总数为偶数时，新加入的元素，应当进入小根堆
                             //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）

            
            maxHeap.offer(num);       // 新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素（自动完成）
            num = maxHeap.poll();
            minHeap.offer(num);          // 筛选排序后的【大根堆中的最大元素】进入小根堆
        }
        else{             //当数据总数为奇数时，新加入的元素，应当进入大根堆（自动完成）
                    //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
             
            minHeap.offer(num);  // 新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            num = minHeap.poll();
            maxHeap.offer(num);   // 筛选后的【小根堆中的最小元素】进入大根堆
        }
         //   count ++;   如果在这个位置，最后的 GetMedian 中count为奇数的时候是 result = minHeap.peek() 
    }

    public Double GetMedian() {
        double result;
        if((count % 2) == 1)
            result = maxHeap.peek();
        else
            result = ( minHeap.peek() + maxHeap.peek() ) / 2.0;
        return result;
    }
}