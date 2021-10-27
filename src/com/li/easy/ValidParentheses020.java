package com.li.easy;

import java.util.Stack;

/**
 * 20 有效的括号
 * 成对出现才有效
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @author system
 */
public class ValidParentheses020 {

    /**
     * 通过栈判断
     *
     * @param s 括号字符串
     * @return 判断是否合法括号输入
     */
    public static boolean isValid(String s) {
        char[] strArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : strArr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //false
        String s1 = "(})";
        //true
        String s2 = "(){}[]";
        //true
        String s3 = "((())){[]}";
        System.out.println(s1 + isValid(s1));
        System.out.println(s2 + isValid(s2));
        System.out.println(s3 + isValid(s3));
    }
}
