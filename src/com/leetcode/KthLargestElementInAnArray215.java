package com.leetcode;

import java.util.Arrays;

/**
 * Created by shilong.zhang on 2018/1/22.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            for (int i = 1; i < k; i++) {
                siftUp(nums, i);
            }

            for (int i = k; i < nums.length; i++) {
                if (nums[i] > nums[0]) {
                    int temp = nums[0];
                    nums[0] = nums[i];
                    nums[i] = temp;
                    siftDown(nums, 0, k-1);
                }
            }

            return nums[0];
        }

        private void siftDown(int[] nums, int start, int end) {
            int i = start;
            int j = i << 2 + 1;
            int temp = nums[i];
            while (j <= end) {
                if (j < end && nums[j] > nums[j + 1]) {
                    j++;
                }
                if (temp <= nums[j]) {
                    break;
                } else {
                    nums[i] = nums[j];
                    i = j;
                    j = i << 2 + 1;
                }
            }
            nums[i] = temp;
        }

        private void siftUp(int[] nums, int start) {
            int j = start;
            int i = (j-1)/2;
            int temp = nums[j];
            while (j > 0) {
                if (nums[i] <= temp) {
                    break;
                } else {
                    nums[j] = nums[i];
                    j = i;
                    i = (j-1)/2;
                }
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        KthLargestElementInAnArray215 kthLargestElementInAnArray215 = new KthLargestElementInAnArray215();
        Solution solution = kthLargestElementInAnArray215.new Solution();
        System.out.println(solution.findKthLargest(nums, k));
    }
}
