package com.code.hash.no383;

/**
 * 赎金信
 * https://leetcode-cn.com/problems/ransom-note/
 *
 * @author markingWang
 * @date 2022/2/25 7:01 下午
 */
public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (char m : magazine.toCharArray()) {
            table[m - 'a']++;
        }
        for (char r : ransomNote.toCharArray()) {
            table[r - 'a']--;
            // 如果小于零说明 ransomNote里出现的字符，magazine没有
            if (table[r - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
