package com.code.array.no27;

/**
 * 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author markingWang
 * @date 2022/2/16 11:20 上午
 */
public class Solution {

    /**
     * 暴力解法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j <= size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }

    /**
     * 快慢指针解法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement01(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    /**
     * 快慢指针优化解法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement02(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right--];
            } else {
                left++;
            }
        }
        return left;
    }
}
