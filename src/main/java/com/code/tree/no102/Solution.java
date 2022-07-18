package com.code.tree.no102;

import com.code.common.TreeNode;

import java.util.*;

/**
 * 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int queueLen = queue.size();
            while (queueLen > 0) {
                TreeNode tempPoll = queue.poll();
                if (tempPoll.left != null) {
                    queue.addLast(tempPoll.left);
                }
                if (tempPoll.right != null) {
                    queue.addLast(tempPoll.right);
                }
                tempList.add(tempPoll.val);
                queueLen--;
            }
            res.add(tempList);
        }

        return res;
    }

    public List<List<Integer>> levelOrder01(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderFunc(root, 0, res);
        return res;
    }

    public void levelOrderFunc(TreeNode node, int deep, List<List<Integer>> res) {
        if (node == null) return;
        deep++;

        if (res.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            res.add(item);
        }
        res.get(deep - 1).add(node.val);

        levelOrderFunc(node.left, deep, res);
        levelOrderFunc(node.right, deep, res);
    }
}
