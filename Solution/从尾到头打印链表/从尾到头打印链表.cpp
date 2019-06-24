/*
（1）vector 初始化的时候是不需要 new 的，相当于直接定义就可以用了
（2）C++ 中是用 NULL
（3）带指针的结构体，是用 -> 而不是 .
（4）vec 如果要取第一个位置就用 vec.begin()，如果要取最后一个位置就用 vec.end()
 */


class Solution {
public:
    vector<int> result;
    vector<int> printListFromTailToHead(ListNode* head) {
        if(head == NULL){
            return result;
        }
        printListFromTailToHead(head->next);
        result.push_back(head->val);
        return result;
    }
};



class Solution {
public:
    vector<int> printListFromTailToHead(ListNode* head) {
        vector<int> result;
        if(head == NULL){
            return result;
        }
        while(head != NULL){
            result.insert(result.begin(), head->val);
            head = head->next;
        }
        return result;
    }
};