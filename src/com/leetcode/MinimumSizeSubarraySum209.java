package com.leetcode;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 */

public class MinimumSizeSubarraySum209 {
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (s < 1 || nums == null || nums.length < 1) {
                return 0;
            }

            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            int left = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                while (sum >= s) {
                    ans = Math.min(ans, i + 1 - left);
                    sum -= nums[left++];
                }
            }
            return (ans != Integer.MAX_VALUE) ? ans : 0;
        }
    }
}
