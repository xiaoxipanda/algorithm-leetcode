package com.code.old.no647;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * tag：字符串，动态规范
 */
public class Solution {
    int num = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i + 1);
        }
        return num;
    }

    public void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }
}
