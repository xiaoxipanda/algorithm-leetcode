package com.code.string.no151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 颠倒字符串中的单词
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 */
public class Solution {
    public static String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static String reverseWords01(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        for (int i = 0; i < chars.length && chars[i] == ' '; i++) begin++;
        for (int i = chars.length - 1; i > 0 && chars[i] == ' '; i--) end--;

        // 移动字符串数组，去掉单词中多余的空格
        int count = 0;
        for (int i = begin; i <= end; i++) {
            if (i > begin && chars[i] == ' ' && chars[i - 1] == ' ') continue;
            chars[begin + count++] = chars[i];
        }

        // 反装整个数组
        reverse(chars, begin, begin + count - 1);

        // 将每个单词反转回来
        int start = begin;
        for (int i = begin + 1;i < begin + count;i++) {
            if (chars[i] == ' ') {
                reverse(chars,start,i - 1);
                start = i + 1;
            } else if (i == begin + count - 1) {
                reverse(chars,start,i);
            }
        }

        return String.copyValueOf(chars,begin,count);
    }

    public static void reverse(char[] cs, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
    }

    public static void main(String[] args) {
        String the_sky_is_blue = reverseWords("the sky is blue");
        System.out.println(the_sky_is_blue);
    }
}
