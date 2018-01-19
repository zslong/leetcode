package com.leetcode;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */

public class ProductOfArrayExceptSelf238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            if (nums == null) {
                return null;
            }

            int[] res = new int[nums.length];
            if (nums.length == 0) {
                return res;
            }

            int leftProduct = 1;
            res[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                res[i] = leftProduct * nums[i-1];
                leftProduct = res[i];
            }

            int rightProduct = nums[nums.length - 1];
            for (int i = nums.length -2; i >= 0; i--) {
                res[i] = rightProduct * res[i];
                rightProduct *= nums[i];
            }

            return res;
        }
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf238 productOfArrayExceptSelf238 = new ProductOfArrayExceptSelf238();
        Solution solution = productOfArrayExceptSelf238.new Solution();
        int[] nums = new int[]{1, 2, 3, 4};
        Arrays.stream(solution.productExceptSelf(nums)).forEach(System.out::println);
    }
}
