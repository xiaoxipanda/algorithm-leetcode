package com.code.no003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，从set中移除一个字符
                occ.remove(s.charAt(i - 1));
            }

            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }

            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

    public int lengthOfLongestSubstring01(String s) {
        Map<Character, Integer> tempMap = new HashMap<>();
        int start = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (tempMap.containsKey(ch)) {
                start = Math.max(tempMap.get(ch) + 1, start);
            }
            ans = Math.max(ans, i - start + 1);

            tempMap.put(ch, i);
        }
        return ans;
    }
}
