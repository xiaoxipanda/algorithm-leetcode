package com.code.hot100;

import com.code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class Hot114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre = list.get(i - 1), curr = list.get(i);
            pre.left = null;
            pre.right = curr;
        }
    }

    private void preorderTraversal(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }

}
