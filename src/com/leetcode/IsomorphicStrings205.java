package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shilong.zhang on 2018/1/11.
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */

public class IsomorphicStrings205 {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s == null || t == null || s.length() != t.length()) {
                return false;
            }

            int len = s.length();
            int[] m1 = new int[256];
            int[] m2 = new int[256];
            Arrays.fill(m1, -1);
            Arrays.fill(m2, -1);

            for (int i = 0; i < len; i++) {
                if (m1[(int) s.charAt(i)] != m2[(int) t.charAt(i)]) {
                    return false;
                }
                m1[(int) s.charAt(i)] = i;
                m2[(int) t.charAt(i)] = i;
            }

            return true;
        }
    }
}
