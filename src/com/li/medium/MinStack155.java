package com.li.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * · MinStack() 初始化堆栈对象。
 * · void push(int val) 将元素val推入堆栈。
 * · void pop() 删除堆栈顶部的元素。
 * · int top() 获取堆栈顶部的元素。
 * · int getMin() 获取堆栈中的最小元素。
 *
 * 示例 1:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 提示：
 * -2^31 <= val <= 2^31 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 10^4 次
 */
public class MinStack155 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(-2147483648);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

/**
 * 参考最优解：无需辅助空间
 *
 * stack用来存储和min的差值，min存储最小值，每次出栈的时候通过差值和当前min计算要出栈的值和之前的min
 * 如果差值diff大于等于0，说明要出栈的值大于等于当前min，那么要出栈的值在入栈的时候没有更新min，返回min+diff；
 * 如果插值diff小于0，说明当前要出栈的值就是min(因为入栈的时候我们选择的就是min和入栈元素的最小值)，同时，通过min-diff计算出之前min
 * 要注意的是diff可能会超出int范围，类似于 Integer.MAX_VALUE - 1 这种，所以diff要用Long存
 */

class MinStack {

    /**
     * 当前列表最小值
     */
    private Integer minVal;
    /**
     * 和最小值差值列表
     */
    private List<Long> diffs;

    public MinStack() {
        this.minVal = Integer.MAX_VALUE;
        this.diffs = new ArrayList<>();
    }

    public void push(int val) {
        long diff = Math.subtractExact((long) val, minVal);
        diffs.add(diff);
        minVal = Math.min(minVal, val);
    }

    public void pop() {
        long diff = diffs.remove(diffs.size() - 1);
        if (diff < 0) {
            minVal = Math.toIntExact(minVal - diff);
        }
    }

    public int top() {
        long diff = diffs.get(diffs.size() - 1);
        if (diff < 0) {
            return minVal;
        }
        return (int) (minVal + diff);
    }

    public int getMin() {
        return minVal;
    }

}

/**
 * 官方：辅助最小值空间
 */
class MinStackOfficial {

    /**
     * 值对应的最小值
     */
    private List<Integer> minVals;
    /**
     * 值堆栈
     */
    private List<Integer> vals;

    public MinStackOfficial() {
        this.minVals = new ArrayList<>();
        minVals.add(Integer.MAX_VALUE);
        this.vals = new ArrayList<>();
    }

    public void push(int val) {
        vals.add(val);
        int minVal = Math.min(val, minVals.get(minVals.size() - 1));
        minVals.add(minVal);
    }

    public void pop() {
        vals.remove(vals.size() - 1);
        minVals.remove(minVals.size() - 1);
    }

    public int top() {
        return vals.get(vals.size() - 1);
    }

    public int getMin() {
        return minVals.get(minVals.size() - 1);
    }

}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
