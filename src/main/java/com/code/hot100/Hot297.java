package com.code.hot100;

import com.code.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化二叉树
 */
public class Hot297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reSerialize(root, "");
    }

    private String reSerialize(TreeNode node, String s) {
        if (node == null) {
            s += "None,";
            return s;
        }
        s += node.val + ",";
        s = reSerialize(node.left, s);
        s = reSerialize(node.right, s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> dataList = new LinkedList<>(Arrays.asList(data.split(",")));
        return reDeserialize(dataList);
    }

    private  TreeNode reDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(dataList.get(0));
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(dataList.get(0));
        node.left = reDeserialize(dataList);
        node.right = reDeserialize(dataList);
        return node;
    }
}
