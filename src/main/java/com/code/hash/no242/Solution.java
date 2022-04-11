package com.code.hash.no242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author markingWang
 * @date 2022/2/25 11:29 上午
 */
public class Solution {


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (char sc : s.toCharArray()) {
            table[sc - 'a']++;
        }

        for (char tc : t.toCharArray()) {
            table[tc - 'a']--;
            if (table[tc - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram01(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (char sc : s.toCharArray()) {
            table[sc - 'a']++;
        }

        for (char tc : t.toCharArray()) {
            table[tc - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram02(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char sc : s.toCharArray()) {
            characterIntegerMap.merge(sc, 1, Integer::sum);
        }
        for (char tc : t.toCharArray()) {
            Integer mergeValue = characterIntegerMap.merge(tc, -1, Integer::sum);
            if (mergeValue < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram03(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

}
