/*
1、最常规的冒泡排序算法，要注意外层 k次循环就可以了，而且理清楚最小的元素是放左边和放右边的逻辑
2、利用最大堆进行选择，此处利用优先队列 PriorityQueue
（1）生成最大堆，注意是 num2 - num1 ，都是 Integer类型
（2）注意优先队列的构造方法
（3）先将前 k 个元素加入堆，然后如果堆顶比待加入元素大，就更新堆顶，这样到最后就只剩下k 个最小的元素在堆里面了
3、利用快速排序的思想，注意各个函数的书写。
（1）patition方法，pivoKey 是轴元素，一般取第一个。内层的while 循环也要加 start < end ，从右到左边，里面就是两次 swap
（2）要 patition 返回值（最后left的位置）为 k - 1 ，循环才结束
（3）分 index < k - 1 和 index > k -1 两种情况讨论，前者就重新划分右半部分，后者就重新划分左半部分
*/


// 基于快速排序的思想，时间为O(n)，但是要数组是可以改变的条件下
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.length == 0 || k <= 0)
            return result;
        if(input.length < k)
            return result;
        int start = 0;
        int end = input.length - 1;
        int index = patition(input , start , end);
        while(index != k - 1){
            if(index < k - 1){
                start = index + 1;
                index = patition(input , start , end);
            }
            else{
                end = index - 1;
                index = patition(input , start , end);
            }
        }
        for(int i = 0 ; i < k ; i ++){
            result.add(input[i]);
        }
        return result;
    }
    public int patition(int[] arr , int start , int end){
        int pivotKey = arr[start];
        while(start < end){
            while(start < end && arr[end] >= pivotKey){
                end --;
            }
            swap(arr , start , end);
            while(start < end  && arr[start] <= pivotKey){
                start ++;
            }
            swap(arr , start , end);
        }
        return start ;                //  记住这里是返回 start
    }
    public void swap(int[] arr , int left , int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}






// 根据冒泡排序，时间复杂度为O(kn)
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.length == 0)
            return result;
        if(input.length < k)
            return result;
        for(int i = 0 ; i < k ; i ++){
            for(int j = 0 ; j < input.length - i - 1 ; j ++){
                if(input[j] < input[j + 1] ){
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            result.add(input[input.length - i - 1]);
        }
        return result;
    }
}



// 时间复杂度为O(nlogk)
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input == null || input.length == 0 || k <= 0)
            return result;
        if(input.length < k)
            return result;
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(k , new MyComparator());
        for(int i = 0 ; i < input.length ; i ++){
            if(i < k){    // 前 k 个全部加入
                minQueue.offer(input[i]);
            }
            else{    
                if(minQueue.peek() > input[i]){   // 如果 堆顶元素大于加入的元素 
                    minQueue.poll();
                    minQueue.offer(input[i]);
                }
            }
        }
        result.addAll(minQueue);
        return result;
    }
    public class MyComparator implements Comparator<Integer>{  // 此处形成的是最大堆
        public int compare(Integer num1 , Integer num2){
            return num2 - num1;      // 要记住这里是 num2 - num1 
        }
    } 
}