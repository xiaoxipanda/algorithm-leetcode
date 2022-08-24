package com.code.hot100;

import com.code.common.TreeNode;

import java.util.*;

/**
 * 二叉树中和为某一值的路径
 * https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class Hot034 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> queue = new ArrayDeque<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        queue.addLast(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0){
            res.add(new LinkedList<>(queue));
        }
        dfs(node.left, target);
        dfs(node.right, target);
        queue.pollLast();
    }

}
