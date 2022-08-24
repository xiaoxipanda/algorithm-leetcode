package com.code.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 * https://leetcode.cn/problems/min-stack/
 */
public class Hot155 {

    class MinStack {

        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
