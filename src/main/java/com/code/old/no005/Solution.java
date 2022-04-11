package com.code.old.no005;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Solution {

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        String longestPalindrome = "";
        String palindrome;
        for (int i = 0; i < s.length()-1; i++) {
            palindrome = findLongestPalindrome(s, i, i);
            if (palindrome.length() > longestPalindrome.length()){
                longestPalindrome = palindrome;
            }

            palindrome = findLongestPalindrome(s, i, i + 1);
            if (palindrome.length() > longestPalindrome.length()){
                longestPalindrome = palindrome;
            }
        }

        return longestPalindrome;
    }

    private String findLongestPalindrome(String s, int start, int end) {;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
