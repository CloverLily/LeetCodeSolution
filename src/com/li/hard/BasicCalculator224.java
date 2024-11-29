package com.li.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 *
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 * 提示：
 * · 1 <= s.length <= 3 * 10^5
 * · s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * · s 表示一个有效的表达式
 * · '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * · '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * · 输入中不存在两个连续的操作符
 * · 每个数字和运行的计算将适合于一个有符号的 32位 整数
 */
public class BasicCalculator224 {
    public static void main(String[] args) {
        String[] s = {
                "1-(     -2)",//3
                "  30",//30
                "(1)",//1
                "1 + 1",//2
                " 2-1 + 2 ",//3
                "(1+(4+5+2)-3)+(6+8)"//23
        };
        for (String str : s) {
            System.out.println(calculate(str));
        }
    }

    /**
     * 官方：符号计算 + 栈
     * time: O(N), space: O(N)
     */
    public static int calculate(String s) {
        int n = s.length();
        int i = 0;
        int res = 0;
        int sign = 1;
        Deque<Integer> opt = new LinkedList<>();
        opt.push(1);
        while (i < n) {
            if (' ' == s.charAt(i)) {
                i++;
            } else if ('+' == s.charAt(i)) {
                sign = opt.peek();
                i++;
            } else if ('-' == s.charAt(i)) {
                sign = -opt.peek();
                i++;
            } else if ('(' == s.charAt(i)) {
                opt.push(sign);
                i++;
            } else if (')' == s.charAt(i)) {
                opt.pop();
                i++;
            } else {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res;
    }
}
