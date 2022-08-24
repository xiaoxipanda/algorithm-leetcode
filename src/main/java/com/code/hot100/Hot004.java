package com.code.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class Hot004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并数组
        int[] array = new int[nums1.length + nums2.length];
        int arrayIndex = 0;
        int n1Index = 0, n2Index = 0;
        while (n1Index < nums1.length || n2Index < nums2.length) {
            if (n2Index >= nums2.length) {
                array[arrayIndex++] = nums1[n1Index++];
                continue;
            }
            if (n1Index >= nums1.length) {
                array[arrayIndex++] = nums2[n2Index++];
                continue;
            }
            if (nums1[n1Index] > nums2[n2Index]) {
                array[arrayIndex++] = nums2[n2Index++];
            } else {
                array[arrayIndex++] = nums1[n1Index++];
            }
        }

        // 求中位数
        double res;
        if (array.length % 2 == 0) {
            res = (array[array.length / 2] + array[(array.length) / 2 - 1]) / 2.0;
        } else {
            res = array[array.length / 2];
        }
        return res;
    }

    public static double findMedianSortedArrays01(int[] nums1, int[] nums2) {
        // 合并为list
        List<Integer> resList = new ArrayList<>();
        List<Integer> num1List = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> num2List = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        resList.addAll(num1List);
        resList.addAll(num2List);
        Collections.sort(resList);

        // 求中位数
        double res;
        if (resList.size() % 2 == 0) {
            res = (resList.get(resList.size() / 2) + resList.get((resList.size()) / 2 - 1)) / 2.0;
        } else {
            res = resList.get(resList.size() / 2);
        }
        return res;
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4, 5});
    }
}
