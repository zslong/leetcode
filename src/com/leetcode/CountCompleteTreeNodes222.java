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

    /**
     * Explanation

     The height of a tree can be found by just going left. Let a single node tree have height 0. Find the height h of the whole tree. If the whole tree is empty, i.e., has height -1, there are 0 nodes.

     Otherwise check whether the height of the right subtree is just one less than that of the whole tree, meaning left and right subtree have the same height.

     If yes, then the last node on the last tree row is in the right subtree and the left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of the left subtree plus the 1 root node plus recursively the number of nodes in the right subtree.
     If no, then the last node on the last tree row is in the left subtree and the right subtree is a full tree of height h-2. So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus recursively the number of nodes in the left subtree.
     Since I halve the tree in every recursive step, I have O(log(n)) steps. Finding a height costs O(log(n)). So overall O(log(n)^2).

     <a href="https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958">origin solution</a>
     */
    class Solution {
        int height(TreeNode root) {
            return root == null ? -1 : 1 + height(root.left);
        }
        public int countNodes(TreeNode root) {
            int h = height(root);
            return h < 0 ? 0 :
                    height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                            : (1 << h-1) + countNodes(root.left);
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
