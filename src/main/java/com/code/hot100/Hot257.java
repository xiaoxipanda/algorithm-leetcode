package com.code.hot100;

import com.code.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * https://leetcode.cn/problems/binary-tree-paths/
 */
public class Hot257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode node, String path, List<String> paths) {
        if (node == null) return;

        StringBuilder pathSB = new StringBuilder(path);
        pathSB.append(node.val);
        if (node.left == null && node.right == null) {  // 当前节点是叶子节点
            paths.add(pathSB.toString());  // 把路径加入到答案中
        } else {
            pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
            constructPaths(node.left, pathSB.toString(), paths);
            constructPaths(node.right, pathSB.toString(), paths);
        }
    }
}
