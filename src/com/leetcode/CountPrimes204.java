package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shilong.zhang on 2018/1/9.
 *
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes204 {

    class Solution {

        public int countPrimes(int n) {
            if (n < 2) {
                return 0;
            }

            Set<Integer> nonPrimes = new HashSet<>();
            nonPrimes.add(1);

            int i = 2;
            int twoTimesNum = 4;
            int threeTimesNum = 9;
            int fiveTimesNum = 10;
            int sevenTimesNum = 14;

            while (twoTimesNum < n || threeTimesNum < n || fiveTimesNum < n || sevenTimesNum < n) {
                nonPrimes.add(threeTimesNum);
                if (threeTimesNum < n) {
                    nonPrimes.add(threeTimesNum);
                }
                if (fiveTimesNum < n) {
                    nonPrimes.add(fiveTimesNum);
                }
                if (sevenTimesNum < n) {
                    nonPrimes.add(sevenTimesNum);
                }
                i++;
                twoTimesNum = 2*i;
                threeTimesNum = 3 * i;
                fiveTimesNum = 5 * i;
                sevenTimesNum = 7 * i;
            }

            // less than n -> n-1, exclude 1 -> n-2
            return n - 1 - nonPrimes.size();
        }
    }

    public static void main(String[] args) {
        CountPrimes204 countPrimes204 = new CountPrimes204();
        Solution solution = countPrimes204.new Solution();
        System.out.println(solution.countPrimes(19));
    }

}
