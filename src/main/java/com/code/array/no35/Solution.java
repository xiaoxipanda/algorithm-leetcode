package com.code.array.no35;

/**
 *
 * 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author markingWang
 * @date 2022/2/16 2:10 下午
 */
public class Solution {

    /**
     * [left, right]
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length, left = 0, right = length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return right + 1;
    }
}
