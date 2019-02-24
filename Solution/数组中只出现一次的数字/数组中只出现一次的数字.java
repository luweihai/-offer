/*
首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。

当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。

依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。
我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位。
我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
*/



//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1)
            return ;
        int temp = 0;    // 表示整个数组进行异或的结果
        for(int i = 0 ; i < array.length ; i ++){  
            temp = temp ^ array[i];
        }
        int cur = 1;  // 表示当前位（实际上是一个数，只有那一个位为1）
        while( (temp & cur) == 0){   // 循环结束后，两个结果只在 cur表示的位出现一次
            cur = cur << 1;
        }
        int[] array1 = new int[array.length];  
        int[] array2 = new int[array.length];
        for(int i = 0 ; i < array.length ; i ++){
            if( (array[i] & cur) == 0 )   // 依据 cur位 进行分类
                array1[i] = array[i];
            else
                array2[i] = array[i];
        }
        for(int i = 0 ; i < array.length ; i ++){
            num1[0] = num1[0] ^ array1[i];
            num2[0] = num2[0] ^ array2[i];
        }
        return ;
    }
}