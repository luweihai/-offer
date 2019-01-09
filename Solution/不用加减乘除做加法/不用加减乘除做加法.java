/*
1、计算ab的进位的话，只有二者同为1才进位，因此进位可以标示为 (a and b) << 1 ，注意因为是进位，所以需要向左移动1位 
2、于是a+b可以看成 （a xor b）+ （(a and b) << 1），这时候如果 (a and b) << 1 不为0
   递归调用这个方式，因为（a xor b）+ （(a and b) << 1） 也有可能进位，所以我们需要不断的处理进位。
*/


public class Solution {
    public int Add(int num1,int num2) {
        if(num1 == 0)
            return num2;
        if(num2 == 0)
            return num1;
        int temp1 = num1 ^ num2;
        int temp2 = (num1 & num2) << 1;   // temp2 是体现了进位
        if(temp2 == 0)
            return temp1;
        else
            return Add(temp1 , temp2);
    }
}