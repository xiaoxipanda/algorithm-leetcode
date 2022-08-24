package com.code.hot100;

import com.code.common.TreeNode;

import java.util.ArrayDeque;

/**
 * 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class Hot104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int maxDepth01(TreeNode root) {
        if (root == null){
            return 0;
        }
        int maxDepth = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int queueLen = queue.size();
            while (queueLen > 0) {
                TreeNode tempPoll = queue.poll();
                if (tempPoll.left != null) {
                    queue.add(tempPoll.left);
                }
                if (tempPoll.right != null) {
                    queue.add(tempPoll.right);
                }
                queueLen--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        maxDepth01(null);
    }
}
