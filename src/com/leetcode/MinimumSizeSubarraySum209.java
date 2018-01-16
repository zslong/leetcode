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

            int left = 0;
            int right = 0;
            int sum = nums[left];
            int len = nums.length + 1;

            while (right < nums.length) {
                if (sum >= s) {
                    int tempLen = right - left + 1;
                    if (tempLen < len) {
                        len = tempLen;
                    }
                    sum -= nums[left];
                    left++;
                    if (left > right && left < nums.length) {
                        right = left;
                        sum = nums[left];
                    }
                } else {
                    right++;
                    if (right < nums.length) {
                        sum += nums[right];
                    }
                }
            }

            if (sum >= s) {
                int tempLen = right - left + 1;
                if (tempLen < len) {
                    len = tempLen;
                }
            }

            return len > nums.length ? 0 : len;
        }
    }
}
