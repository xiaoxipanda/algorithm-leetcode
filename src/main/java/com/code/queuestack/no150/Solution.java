package com.code.queuestack.no150;

import java.util.ArrayDeque;

/**
 * 逆波兰表达式求值
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (stack.isEmpty() || (!token.equals("+") && !token.equals("-") &&
                    !token.equals("*") && !token.equals("/"))) {
                stack.push(token);
            } else {
                String popFirst = stack.pop();
                String popTwo = stack.pop();
                long result = 0;
                if (token.equals("+")) {
                    result = Long.parseLong(popFirst) + Long.parseLong(popTwo);
                } else if (token.equals("-")) {
                    result = Long.parseLong(popTwo) - Long.parseLong(popFirst);
                } else if (token.equals("*")) {
                    result = Long.parseLong(popFirst) * Long.parseLong(popTwo);
                } else if (token.equals("/")) {
                    result = Long.parseLong(popTwo) / Long.parseLong(popFirst);
                }
                stack.push(String.valueOf(result));
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public int evalRPN01(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                Integer temp1 = stack.pop();
                Integer temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
