package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shilong.zhang on 2018/1/19.
 * Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackUsingQueues225 {
    class MyStack {
        private Queue<Integer> queue1;

        private Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (queue1.isEmpty()) {
                queue2.add(x);
            } else {
                queue1.add(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Queue<Integer> cur = queue1.isEmpty() ? queue2 : queue1;
            Queue<Integer> empty = queue1.isEmpty() ? queue1 : queue2;

            while (cur.size() > 1) {
                empty.add(cur.poll());
            }

            return cur.poll();
        }

        /** Get the top element. */
        public int top() {
            Queue<Integer> cur = queue1.isEmpty() ? queue2 : queue1;
            Queue<Integer> empty = queue1.isEmpty() ? queue1 : queue2;

            while (cur.size() > 1) {
                empty.add(cur.poll());
            }

            int result = cur.poll();
            empty.add(result);

            return result;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues225 implementStackUsingQueues225 = new ImplementStackUsingQueues225();
        MyStack myStack = implementStackUsingQueues225.new MyStack();
        System.out.println(myStack.empty());
        myStack.push(1);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.empty());
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
