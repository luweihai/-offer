/*
（1）输入的字符串一般都是用 char *str 表示，此时 str 表示对应字符串的地址
（2）第一趟遍历的时候统计有多少个空格，然后再从后面往前直接改元素的字符串（从前往后要新的空间）

    这个操作要学会
        auto ret= result.c_str();
        strcpy(str, ret);


*/


class Solution {
public:
	void replaceSpace(char *str,int length) {
        string s = str;
        string result = "";

        for(int i = 0; i < s.size() ; i ++){
            if(s.at(i) == ' '){
                result = result + "%20";
            }
            else{
                result = result + s.at(i);
            }
        }
        auto ret= result.c_str();
        strcpy(str, ret);
	}
};
