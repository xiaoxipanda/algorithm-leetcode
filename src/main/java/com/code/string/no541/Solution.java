package com.code.string.no541;

/**
 * 反转字符串II
 * https://leetcode.cn/problems/reverse-string-ii/
 */
public class Solution {

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i += 2 * k) {
            if (i + k <= cs.length) {
                reverse(cs, i, i + k - 1);
                continue;
            }
            reverse(cs, i, cs.length - 1);
        }
        return new String(cs);
    }

    public void reverse(char[] cs, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
    }
}
