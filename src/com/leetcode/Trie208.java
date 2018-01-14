package com.leetcode;

/**
 * Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */

public class Trie208 {
    class Trie {

        class Node {
            char[] chars = new char[26];
            Node[] nodes = new Node[26];

            Node(){
                for (int i = 0; i < 26; i++) {
                    chars[i] = 'a' - 1;
                }
            }
        }

        private Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {

        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
