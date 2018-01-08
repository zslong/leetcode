package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shilong.zhang on 2018/1/8.
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 For example:
 Given the below binary tree,

   1
  / \
 2   3
 Return 6.
 */
public class BinayTreeMaxPathSum124 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode root) {
        Map<String, Integer> maxMap = new HashMap<>();
        maxMap.put("max", Integer.MIN_VALUE);

        maxPathSum(root, maxMap);

        return maxMap.get("max");
    }

    public int maxPathSum(TreeNode node, Map<String, Integer> maxMap) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            if (node.val > maxMap.get("max")) {
                maxMap.put("max", node.val);
            }
            return node.val;
        }

        int leftmax = Integer.max(0, maxPathSum(node.left, maxMap));
        int rightmax = Integer.max(0, maxPathSum(node.right, maxMap));
        int curmax = node.val + leftmax + rightmax;

        if (curmax > maxMap.get("max")) {
            maxMap.put("max", curmax);
        }

        // return the max value that can be extended to node's parent node
        return node.val + Integer.max(leftmax, rightmax);
    }

}
