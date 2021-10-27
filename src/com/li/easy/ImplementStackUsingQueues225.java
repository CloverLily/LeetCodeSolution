package com.li.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 两个队列实现栈
 *
 * @author system
 *
 */
public class ImplementStackUsingQueues225 {

    /**
     * Your MyStack object will be instantiated and called as such:
     */
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2 + "," + param_3 + "," + param_4);
    }


    static class MyStack {
        //定义两个队列
        private Queue<Integer> queue1, queue2;
        //栈顶元素
        private int top;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue1 = new ArrayDeque<Integer>();
            queue2 = new ArrayDeque<Integer>();
        }

        /**
         * Push element x onto stack.
         * 模拟入栈
         */
        public void push(int x) {
            if (empty() || queue1.isEmpty()) {
                queue2.add(x);
            } else if (queue2.isEmpty()) {
                queue1.add(x);
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         * 模拟移除栈顶元素
         */
        public int pop() {
            //找到非空队列
            Queue<Integer> queue, emptyQueue;
            queue = queue1.isEmpty() ? queue2 : queue1;
            emptyQueue = queue1.isEmpty() ? queue1 : queue2;

            if (queue == null) {
                return -1;
            }

            while (!queue.isEmpty()) {
                top = queue.poll();
                if (queue.peek() != null) {
                    emptyQueue.offer(top);
                }
            }
            return top;
        }

        /**
         * Get the top element.
         * 模拟获取栈顶元素
         */
        public int top() {
            //找到非空队列
            Queue<Integer> queue, emptyQueue;
            queue = queue1.isEmpty() ? queue2 : queue1;
            emptyQueue = queue1.isEmpty() ? queue1 : queue2;

            if (queue == null) {
                return -1;
            }

            while (!queue.isEmpty()) {
                top = queue.poll();
                emptyQueue.offer(top);
            }
            return top;
        }

        /**
         * Returns whether the stack is empty.
         * 判断栈是否为空
         */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

}
