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
            boolean[] isPrime = new boolean[n];
            for (int i = 2; i < n; i++) {
                isPrime[i] = true;
            }
            // Loop's ending condition is i * i < n instead of i < sqrt(n)
            // to avoid repeatedly calling an expensive function sqrt().
            for (int i = 2; i * i < n; i++) {
                if (!isPrime[i]) continue;
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        CountPrimes204 countPrimes204 = new CountPrimes204();
        Solution solution = countPrimes204.new Solution();
        System.out.println(solution.countPrimes(19));
    }

}
