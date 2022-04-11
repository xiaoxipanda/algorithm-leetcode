package com.code.array.no209;

/**
 * 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author markingWang
 * @date 2022/2/16 2:25 下午
 */
public class Solution {

    /**
     * 暴力解法
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minSubArrayLen = Integer.MAX_VALUE, subArrayLen = 0, subArraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            subArraySum = 0;
            for (int j = i; j < nums.length; j++) {
                subArraySum += nums[j];
                if (subArraySum >= target) {
                    subArrayLen = j - i + 1;
                    minSubArrayLen = minSubArrayLen < subArrayLen ? minSubArrayLen : subArrayLen;
                    break;
                }
            }
        }
        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }

    /**
     * 滑动窗口解法
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen01(int target, int[] nums) {
        int minSubArrayLen = Integer.MAX_VALUE;
        int subArrayLen = 0, subArraySum = 0, leftIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            subArraySum += nums[i];
            while (subArraySum >= target) {
                subArrayLen = i - leftIndex + 1;
                minSubArrayLen = minSubArrayLen < subArrayLen ? minSubArrayLen : subArrayLen;
                subArraySum -= nums[leftIndex++];
            }
        }

        return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;
    }
}
