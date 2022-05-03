package com.li.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 *
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 *     void push(int x) 将元素 x 推到队列的末尾
 *     int pop() 从队列的开头移除并返回元素
 *     int peek() 返回队列开头的元素
 *     boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * 说明：
 *     你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *     你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * 示例 1：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 * 提示：
 *     1 <= x <= 9
 *     最多调用 100 次 push、pop、peek 和 empty
 *     假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 * 进阶：
 *     你能否实现每个操作均摊时间复杂度为 O(1) 的队列？
 *     换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 *
 * @author system
 */
public class ImplementQueueUsingStacks232 {

    public static void main(String[] args) {
        // Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param1 = obj.pop();
        obj.push(3);
        obj.push(4);
        int param2 = obj.pop();
        int param3 = obj.peek();
        int param4 = obj.pop();

        System.out.println(param1 + "," + param2 + "," + param3 + "," + param4);
    }

    private static class MyQueue {

        /**
         * 栈1
         */
        private Deque<Integer> myQueue1;
        /**
         * 栈2
         */
        private Deque<Integer> myQueue2;
        /**
         * 栈顶元素值
         */
        private Integer top = -1;

        public MyQueue() {
            this.myQueue1 = new LinkedList<>();
            this.myQueue2 = new LinkedList<>();
        }

        public void push(int x) {
            if (myQueue1.isEmpty()) {
                top = x;
            }
            myQueue1.push(x);
        }

        public int pop() {
            if (this.empty()) {
                return -1;
            }

            if (myQueue2.isEmpty()) {
                while (myQueue1.peek() != null) {
                    myQueue2.push(myQueue1.pop());
                }
            }
            return myQueue2.pop();
        }

        public int peek() {
            if(!myQueue2.isEmpty()){
                return myQueue2.peek();
            }
            return top;
        }

        public boolean empty() {
            return myQueue1.isEmpty() && myQueue2.isEmpty();
        }
    }

}




