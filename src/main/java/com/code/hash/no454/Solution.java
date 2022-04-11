package com.code.hash.no454;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 * https://leetcode-cn.com/problems/4sum-ii/
 *
 * @author markingWang
 * @date 2022/2/25 4:41 下午
 */
public class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> fourSumMap = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
//                fourSumMap.merge(n1 + n2, 1, Integer::sum);
                fourSumMap.put(n1 + n2, fourSumMap.getOrDefault(n1 + n2, 0) + 1);
            }
        }

        int counter = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                if (fourSumMap.containsKey(-(n3 + n4))) {
                    counter += fourSumMap.get(-(n3 + n4));
                }
            }
        }
        return counter;
    }
}
