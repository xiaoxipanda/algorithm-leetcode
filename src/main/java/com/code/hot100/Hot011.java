package com.code.hot100;

/**
 * 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class Hot011 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(area, ans);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
