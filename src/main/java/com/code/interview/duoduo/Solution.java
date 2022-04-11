package com.code.interview.duoduo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;

/**
 * 最长公共子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * @author markingWang
 * @date 2021/12/8 7:52 下午
 */
public class Solution {

    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> s3 = new ArrayList<>();
        List<String> strings = mergeAll(s1, s2, s3);
        return ans;
    }

    public final <T> List<T> mergeAll(List<T>... lists) {
        if (lists == null) {
            return new ArrayList<>();
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return Arrays.stream(lists, 1, lists.length - 1)
                .reduce(lists[0], this::merge);
    }

    private <T> List<T> merge(List<T> prior, List<T> origin) {
        Set<T> originSet = new HashSet<>();
        LinkedList<T> merged = new LinkedList<>();

        // 如果prior已经存在于origin，则忽略，否则加入头部
        CollectionUtils.emptyIfNull(origin).stream().peek(originSet::add).forEach(merged::addLast);
        CollectionUtils.emptyIfNull(prior).stream()
                .filter(((Predicate<T>) originSet::contains).negate())
                .forEach(merged::addFirst);
        return merged;
    }

    public static String get(String key) {
        if (null == key) {
            return null;
        }
        return Optional.ofNullable(getPropertyMap()).map(map -> map.get(key)).orElse(null);
    }

    private static Map<String, String> getPropertyMap() {
        Map<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1","123");
        return objectObjectHashMap;
    }


    public static void main(String[] args) {
        String s = get("1");
        System.out.println(s);

    }
}
