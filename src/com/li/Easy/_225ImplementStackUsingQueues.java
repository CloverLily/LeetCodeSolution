package com.li.Easy;

import java.util.Queue;

/**
 * 两个队列实现栈
 */
public class _225ImplementStackUsingQueues {

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
        }

        /**
         * Push element x onto stack.
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
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            return queue2.remove();
//            while (!queue2.isEmpty()) {
//                queue1.add(queue2.remove());
//            }
        }

        /**
         * Get the top element.
         */
        public int top() {
            return 0;

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
