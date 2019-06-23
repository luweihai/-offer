/*
（1）C++ 中数组（包括多维数组）是用 vector 进行表示的，例如  vector<vector<int>> array
（2）vector 判断是否为空 不能用  array == null  而是要用 vector.empty() 方法
（3）vector 拿到其大小的方法是  size()
*/


class Solution {
public:
    bool Find(int target, vector<vector<int> > array) {
        if(array.empty() || array.size() == 0){
            return false;
        }
        int rows = array.size();
        int cols = array[0].size();
        int row = 0, col = cols - 1;
        while(row <= rows - 1 && col >= 0){
            if(array[row][col] == target){
                return true;
            }
            else if(array[row][col] > target){
                col --;
            }
            else{
                row ++;
            }
        }
        return false;
    }
};