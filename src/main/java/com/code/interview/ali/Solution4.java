package com.code.interview.ali;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {

    /**
     * 存放符合条件的结果集合
     */
    static List<List<Integer>> res = new ArrayList<>();

    /**
     * 存放符合条件结果
     */
    static LinkedList<Integer> path = new LinkedList<>();

    /**
     * 存放是否已经使用过
     */
    static boolean[] used;

    public static List<List<Integer>> all(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        preAll(nums);
        return res;
    }

    public static void preAll(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                // 已经被使用
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            // 递归继续往path中添加元素
            preAll(nums);
            // 回溯每次删除path中的最后一个元素
            path.removeLast();
            // 设置为false，为下一次使用
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> all = all(new int[]{1, 2, 3, 4});
        for (List<Integer> eles : all) {
            for (Integer ele : eles) {
                System.out.print(ele);
            }
            System.out.println();
        }
    }

}
