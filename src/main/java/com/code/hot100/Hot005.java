package com.code.hot100;

/**
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class Hot005 {
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String longestPalindromeRes = "";
        String palindrome;
        for (int i = 0; i < s.length() -1; i++) {
            palindrome = findLongestPalindrome(s, i, i);
            if (palindrome.length() > longestPalindromeRes.length()) {
                longestPalindromeRes = palindrome;
            }

            palindrome = findLongestPalindrome(s, i, i + 1);
            if (palindrome.length() > longestPalindromeRes.length()) {
                longestPalindromeRes = palindrome;
            }
        }
        return longestPalindromeRes;
    }

    public static String findLongestPalindrome(String s, int start, int end) {
        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }

    public static void main(String[] args) {
        String babad = longestPalindrome("babad");
        System.out.println(babad);
    }
}
