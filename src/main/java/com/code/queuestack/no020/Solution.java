package com.code.queuestack.no020;

import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || stack.peek() != c){
                return false;
            }else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
