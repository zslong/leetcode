package com.leetcode;

/**
 * Created by shilong.zhang on 2018/1/3.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // get linkedlist length
            ListNode cur = head;
            int length = 0;
            while (cur != null) {
                length++;
                cur = cur.next;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode left, right, tail;
            for (int step = 1; step < length; step *= 2) {
                cur = dummy.next;
                tail = dummy;
                while (cur != null) {
                    left = cur;
                    right = split(left, step);
                    cur = split(right, step);
                    tail = merge(left, right, tail);
                }
            }

            return dummy.next;
        }

        private ListNode split(ListNode head, int n) {
            for (int i = 1; head != null && i < n; i++) {
                head = head.next;
            }

            if (head == null) {
                return null;
            }

            ListNode second = head.next;
            head.next = null;
            return second;
        }

        private ListNode merge(ListNode hl, ListNode hr, ListNode head) {
            ListNode cur = head;

            while (hl != null && hr != null) {
                if (hl.val > hr.val) {
                    cur.next = hr;
                    hr = hr.next;
                } else {
                    cur.next = hl;
                    hl = hl.next;
                }
                cur = cur.next;
            }

            cur.next = hl == null ? hr : hl;
            while (cur.next != null) cur = cur.next;
            return  cur;
        }
    }

    public static void main(String[] args) {
        SortLinkedList sortLinkedList = new SortLinkedList();
        Solution solution = sortLinkedList.new Solution();
        ListNode head = sortLinkedList.new ListNode(2);
        head.next = sortLinkedList.new ListNode(1);
        head = solution.sortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
