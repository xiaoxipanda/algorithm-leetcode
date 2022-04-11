package com.code.hash.no001;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author markingWang
 * @date 2022/2/25 4:14 下午
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tempMap.containsKey(target - nums[i])) {
                return new int[]{i, tempMap.get(target - nums[i])};
            }
            tempMap.put(nums[i], i);
        }
        return new int[0];
    }
}
