package com.code.old.no739;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * tag：单调栈
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length - 1; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] dailyTemperatures01(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];

        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}
