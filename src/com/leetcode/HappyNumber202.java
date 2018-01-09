package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shilong.zhang on 2018/1/8.
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process:
 Starting with any positive integer,
 replace the number by the sum of the squares of its digits,
 and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */
public class HappyNumber202 {

    class Solution {
        private int digitPowSum(int n) {
            int sum = 0;
            while (n > 0) {
                int remain = n % 10;
                sum += remain*remain;
                n = n / 10;
            }
            return sum;
        }

        /**
         * the digit power sum will be constraint to a certain range when the loop continues.
         * for example, a number with 4 digits. each digit's power can be at most 81, and the sum will be less than 400,
         * which is obviously less than the number itself.
         *
         * Since there will always be a certain range, the digit power sum will end up in a loop. And it's time to return false
         * when such a loop is detected, unless the sum is 1 which will return true.
         *
         * If not want to allocate additional space for Set, we can refer to the Floyd Circle Algorithm used to detect the circle
         * of linkedlist. The solution is <a href="https://leetcode.com/problems/happy-number/discuss/56917">here</a>
         *
         * For more detailed proof of the algorithm, go to <a href="https://discuss.leetcode.com/topic/30520/explanation-of-why-those-posted-algorithms-are-mathematically-valid">here</a>.
         * @param n
         * @return
         */
        public boolean isHappy(int n) {
            if (n < 1) {
                return false;
            }

            Set<Integer> cache = new HashSet<>();

            while (!cache.contains(n)) {
                cache.add(n);
                int digitPowSum = digitPowSum(n);
                if (digitPowSum == 1) {
                    return true;
                }
                n = digitPowSum;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        HappyNumber202 happyNumber202 = new HappyNumber202();
        Solution solution = happyNumber202.new Solution();

        System.out.println(solution.isHappy(19));
    }
}
