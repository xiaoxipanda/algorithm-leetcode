package com.code.hash.no349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author markingWang
 * @date 2022/2/25 3:11 下午
 */
public class Solution {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        for (int num1 : nums1) {
            num1Set.add(num1);
        }

        Set<Integer> intersectionSet = new HashSet<>();
        for (int num2 : nums2) {
            if (num1Set.contains(num2)) {
                intersectionSet.add(num2);
            }
        }

        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }
        return intersection;
    }

    public static int[] intersectionStream(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(num1Set::contains).toArray();
    }
}
