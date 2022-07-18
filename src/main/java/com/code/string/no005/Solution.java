package com.code.string.no005;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * 替换空格
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class Solution {
    public static String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }

    public static String replaceSpace02(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        replaceSpace("We are happy.");
    }
}
