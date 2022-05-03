package com.li.easy;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 *     1 <= s.length <= 10^4
 *     s 仅由括号 '()[]{}' 组成
 *
 * @author system
 */
public class ValidParentheses020 {

    public static void main(String[] args) {
        //false
        String s1 = "(})";
        //true
        String s2 = "(){}[]";
        //true
        String s3 = "((())){[]}";
        System.out.println(s1 + isValid0503(s1));
        System.out.println(s2 + isValid0503(s2));
        System.out.println(s3 + isValid0503(s3));
    }

    /**
     * 通过栈判断
     *
     * @param s 括号字符串
     * @return 判断是否合法括号输入
     */
    public static boolean isValid0503(String s) {
        int length = s.length();
        //若字符串长度为奇数，则一定不能组合成功
        if (length % 2 == 1) {
            return false;
        }

        char[] sChars = s.toCharArray();
        Stack<Character> sStack = new Stack<>();

        for (char sChar : sChars) {

            if (sChar == '(' || sChar == '{' || sChar == '[') {
                sStack.push(sChar);
            } else if (sStack.isEmpty()) {
                return false;
            } else if (sStack.peek() == '(' && sChar == ')') {
                sStack.pop();
            } else if (sStack.peek() == '{' && sChar == '}') {
                sStack.pop();
            } else if (sStack.peek() == '[' && sChar == ']') {
                sStack.pop();
            } else {
                return false;
            }
        }

        return sStack.isEmpty();
    }

}
