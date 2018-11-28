package com.li.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 20 有效的括号
 * 成对出现才有效
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
class _020ValidParentheses {

    /**
     * 通过栈判断
     *
     * @param s 括号字符串
     * @return 判断是否合法括号输入
     */
    public static boolean isValid(String s) {
        char[] strs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == '(' || strs[i] == '[' || strs[i] == '{') {
                stack.push(strs[i]);
            } else if (stack.isEmpty()) {
                return false;
            } else if (strs[i] == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (strs[i] == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (strs[i] == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "(})";//false
        String s2 = "(){}[]";//true
        String s3 = "((())){[]}";//true
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
    }
}
