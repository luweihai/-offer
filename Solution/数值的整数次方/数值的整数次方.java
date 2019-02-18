/*
利用二分法，每次计算当前计算结果的一半。注意 负数次方的时候，先将负数变为正数，然后底数取倒数
*/

public class Solution {
    public double Power(double base, int exponent) {
        if(exponent == 0)
            return 1;
        if(base == 1)
            return base;
        int half_Exponent = exponent / 2;
        if(exponent < 0){
            half_Exponent = -half_Exponent;
            base = 1 / base;
        }
        double result = Power(base , half_Exponent);  // 不要把这步写到 return 语句中
        if(exponent % 2 == 0)
            return result * result;
        else
            return base * result * result; 
  }
}