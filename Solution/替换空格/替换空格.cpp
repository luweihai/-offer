/*
（1）输入的字符串一般都是用 char *str 表示，此时 str 表示对应字符串的地址
（2）第一趟遍历的时候统计有多少个空格，然后再从后面往前直接改元素的字符串（从前往后要新的空间）
*/


class Solution {
public:
    void replaceSpace(char *str,int length) {
        int count = 0;
        for(int i=0; i<length; i++){
            if(str[i] == ' ')
                count ++;
        }
        for(int i = length - 1; i>= 0; i --){
            if(str[i] != ' '){
                str[i + 2 * count] = str[i];
            }
            else{
                count--;
                str[i + 2 * count] = '%';
                str[i + 2 * count + 1] = '2';
                str[i + 2 * count + 2] = '0';
            }
        }
    }
};