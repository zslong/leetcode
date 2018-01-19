package com.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by shilong.zhang on 2018/1/19.
 * Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes222 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            int depth = 0;
            int lastLevelCnt = 0;
            Map<TreeNode, Integer> nodeLevel = new HashMap<>();
            nodeLevel.put(root, 1);

            while (stack.size() > 0) {
                TreeNode top = stack.pop();
                if (top.left == null) {
                    if (nodeLevel.get(top) < depth) {
                        break;
                    } else {
                        depth = nodeLevel.get(top);
                        lastLevelCnt += 1;
                    }
                } else if (top.right == null) {
                    depth = nodeLevel.get(top) + 1;
                    lastLevelCnt += 1;
                    break;
                } else {
                    nodeLevel.put(top.right, nodeLevel.get(top) + 1);
                    nodeLevel.put(top.left, nodeLevel.get(top) + 1);
                    stack.push(top.right);
                    stack.push(top.left);
                }
            }

            int res = 0;
            for (int i = 0; i < depth-1; i++) {
                res += Math.pow(2, i);
            }
            res += lastLevelCnt;

            return res;
        }
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes222 countCompleteTreeNodes222 = new CountCompleteTreeNodes222();
        TreeNode root = countCompleteTreeNodes222.new TreeNode(1);
        TreeNode left = countCompleteTreeNodes222.new TreeNode(2);
        TreeNode right = countCompleteTreeNodes222.new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode lleft = countCompleteTreeNodes222.new TreeNode(4);
        TreeNode lright = countCompleteTreeNodes222.new TreeNode(5);
        left.left = lleft;
        left.right = lright;

        Solution solution = countCompleteTreeNodes222.new Solution();
        System.out.println(solution.countNodes(root));
    }
}
