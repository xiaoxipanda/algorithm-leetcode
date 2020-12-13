package com.code.code1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 7 0
 * 2 1
 * -2 2
 * -6 3
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {

    /**
     * 暴力解法
     */
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表
     */
    public static int[] twoSum01(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tempMap.containsKey(nums[i])) {
                indexs[0] = tempMap.get(nums[i]);
                indexs[1] = i;
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            tempMap.put(target - nums[i], i);
        }
        return indexs;
    }

    /**
     * 哈希表2
     */
    public static int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(nums[i])) {
                return new int[]{resultMap.get(nums[i]), i};
            }
            // 将数据存入 key为补数 ，value为下标
            resultMap.put(target - nums[i], i);
        }
        return new int[0];
    }

    /**
     * 哈希表3
     */
    public static int[] twoSum03(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(target - nums[i])) {
                return new int[]{resultMap.get(target - nums[i]), i};
            }
            resultMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        System.out.println("result: " + Arrays.toString(result));
    }
}
