package com.code.no011;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @date 2021/9/3 1:45 下午
 */
public class Solution {

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(area, ans);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}
