package com.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */

public class BinaryTreeRightSideView199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            Queue<TreeNode> curLevel = new LinkedList<>();
            Queue<TreeNode> nextLevel = new LinkedList<>();
            curLevel.add(root);

            while (curLevel.size() > 0) {
                TreeNode node = curLevel.poll();
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }

                if (curLevel.size() == 0) {
                    result.add(node.val);
                    curLevel = nextLevel;
                    nextLevel = new LinkedList<>();
                }
            }

            return result;
        }
    }
}
