package com.code.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 2 个有序数组 A 和 B，只含有数字，每个数组内的元素都有可能重复。请写一个函数，判断 B 是否为 A 的子集。如果是，返回 true；反之，返回 false。
 */
public class Solution {

    public boolean isSubArray(int[] a, int[] b) {
        Map<Integer, Integer> aMap = new HashMap<>();
        for (int ae : a) {
            aMap.put(ae, aMap.getOrDefault(ae, 0) + 1);
        }
        for (int be : b) {
            if (!aMap.containsKey(be)) {
                return false;
            }
            if (aMap.get(be) - 1 > 0) {
                aMap.put(be, aMap.get(be) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isSubArray1(int[] a, int[] b) {
        if (b.length == 0) {
            return true;
        }
        int pa = 0, pb = 0;
        while (pa < a.length) {
            if (b[pb] == a[pa]) {
                pb++;
                if (pb >= b.length) {
                    return true;
                }
            }
            pa++;
        }
        return false;
    }

    public static boolean isSubArray2(int[] a, int[] b) {
        if (b.length == 0) {
            return true;
        }
        int pb = 0;
        Map<Integer, Boolean> tempMap = new HashMap<>();

        for (int pa = 0; pa < a.length; ) {
            if (b[pb] == a[pa]) {
                tempMap.putIfAbsent(pa, false);
                pa++;
            } else {
                tempMap.putIfAbsent(pb, true);
                Boolean tmpB = tempMap.get(pb - 1);
                if (pb > 0 && tmpB != null && tmpB) {
                    return false;
                }
                pb++;
                if (pb == b.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSubArray3(int[] a, int[] b) {
        if (b.length == 0) {
            return true;
        }

        if (b.length > a.length) {
            return false;
        }
        int pa = 0, pb = 0;
        while (a[pa] > b[pb]) {
            pb++;
        }
        if (pb >= b.length || a[pa] > b[pb]) {
            return false;
        }

        while (pa < a.length - 1 && pb < b.length - 1 && a[pa] == a[pa + 1] && a[pa + 1] != b[pb + 1]) {
            pa++;
        }

        while (pb < b.length && a[pa] == b[pb]) {
            pa++;
            pb++;
        }
        return pb == b.length && a[pa - 1] == b[pb - 1];
    }

    public static void main(String[] args) {
        boolean subArray1 = isSubArray2(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3});
        System.out.println(subArray1);
        boolean subArray2 = isSubArray2(new int[]{1, 2, 3, 4}, new int[]{1, 3});
        System.out.println(subArray2);
        boolean subArray3 = isSubArray2(new int[]{1, 2, 3, 4}, new int[]{1, 2, 2, 3});
        System.out.println(subArray3);

        boolean subArray4 = isSubArray2(new int[]{1, 1, 2, 3, 4}, new int[]{1, 2, 3});
        System.out.println(subArray4);
        boolean subArray5 = isSubArray2(new int[]{1, 1, 1, 2, 3, 4}, new int[]{1, 2, 3});
        System.out.println(subArray5);
        boolean subArray6 = isSubArray2(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4});
        System.out.println(subArray6);
        boolean subArray7 = isSubArray2(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4});
        System.out.println(subArray7);
    }


}
