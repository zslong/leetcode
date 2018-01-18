package com.leetcode;

/**
 * Created by shilong.zhang on 2018/1/17.
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class ValidAnagram242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null || s.length() != t.length()) {
                return false;
            }

            int[] cnum = new int[26];

            for (int i = 0; i < s.length(); i++) {
                cnum[s.charAt(i)-'a'] += 1;
                cnum[t.charAt(i)-'a'] -= 1;
            }

            for (int num : cnum) {
                if (num != 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
