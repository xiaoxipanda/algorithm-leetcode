package com.code.no053;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class no053 {
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            max = Math.max(pre, max);
        }
        return max;
    }
}
