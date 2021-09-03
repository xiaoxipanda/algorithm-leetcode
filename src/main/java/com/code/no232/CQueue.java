package com.code.no232;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * tag: 栈、设计、队列
 */
public class CQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

        if (outStack.isEmpty()){
            return -1;
        }

        return outStack.pop();
    }


}
