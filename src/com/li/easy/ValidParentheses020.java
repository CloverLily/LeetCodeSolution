package com.li.easy;

import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
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
 * 输入：s = "([])"
 * 输出：true
 *
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 *
 * @author system
 */
public class ValidParentheses020 {

    public static void main(String[] args) {
        String[] s = {
                "()",//true
                "()[]{}",//true
                "(]",//false
                "([])"//true
        };
        for (String str : s) {
            System.out.println(isValid(str));
        }
    }

    /**
     * 自解：栈
     * time：O(N), space: O(N)
     */
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char last = stack.peek();
                if ((last != '(' && c == ')') || (last != '{' && c == '}') || (last != '[' && c == ']')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
