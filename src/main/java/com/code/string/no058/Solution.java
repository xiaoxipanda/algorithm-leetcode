package com.code.string.no058;

/**
 * 左旋转字符串
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Solution {

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder subPre = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            subPre.append(c);
        }
        StringBuilder result = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            result.append(chars[i]);
        }
        result.append(subPre);
        return result.toString();
    }
    public String reverseLeftWords01(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public String reverseLeftWords02(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
