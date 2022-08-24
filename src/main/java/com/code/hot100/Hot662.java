package com.code.hot100;

import com.code.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树最大宽度
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */
public class Hot662 {
    Map<Integer, Integer> left;
    int ans;

    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.putIfAbsent(depth, pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }

    /**
     * 节点最多的层对应的节点数
     */
    public int widthOfBinaryTree01(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int tmpAns = 0;
            while (queueSize > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                if (node.left != null || node.right != null) {
                    tmpAns++;
                }
                queueSize--;
            }
            ans = Math.max(ans, tmpAns);
        }

        return ans;
    }
}
