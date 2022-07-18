package com.code.string.no344;

/**
 * 反转字符串
 * https://leetcode.cn/problems/reverse-string/
 */
public class Solution {
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < s.length / 2; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }

    }

    public void reverse(char[] cs, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            cs[i] ^= cs[j];
            cs[j] ^= cs[i];
            cs[i] ^= cs[j];
        }
    }
}
