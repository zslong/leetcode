package com.leetcode;

/**
 * Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */

public class Trie208 {

    class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }

    class Trie {

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curNode.children[index] == null) {
                    curNode.children[index] = new TrieNode();
                }
                curNode = curNode.children[index];
            }
            curNode.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curNode.children[index] == null) {
                    return false;
                }
                curNode = curNode.children[index];
            }
            return curNode.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (curNode.children[index] == null) {
                    return false;
                }
                curNode = curNode.children[index];
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    public static void main(String[] args) {
        Trie208 trie208 = new Trie208();
        Trie trie = trie208.new Trie();
        trie.insert("hello");
        System.out.println(trie.search("hello"));
        System.out.println(trie.startsWith("he"));
        System.out.println(trie.search("hellp"));
        System.out.println(trie.startsWith("h"));
    }
}
