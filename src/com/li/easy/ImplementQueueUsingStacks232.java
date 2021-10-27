package com.li.easy;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @author system
 */
public class ImplementQueueUsingStacks232 {

    /**
     * Your MyQueue object will be instantiated and called as such:
     */
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2 + "," + param_3 + "," + param_4);

    }


    static class MyQueue {

        //定义两个栈stack1,stack2
        private Stack<Integer> stack1, stack2;
        //队列首元素
        private int first;

        /**
         * Initialize your data structure here.
         * 初始化栈
         */
        public MyQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (empty()) {
                return -1;
            }

            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (empty()) {
                return -1;
            }

            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.empty() && stack2.empty();
        }
    }

}




