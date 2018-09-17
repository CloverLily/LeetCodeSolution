package com.li.Easy;

import java.util.ArrayList;
import java.util.List;

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
 */
class _20ValidParentheses {
    public static boolean isValid(String s) {
        char[] sArr = s.toCharArray();
        List<Character> sList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            switch (sArr[i]) {
                case '(':
                    sList.add(sArr[i]);
                    break;
                case ')':
                    if (sList == null || sList.size() == 0 || !sList.get(sList.size() - 1).equals('(')) {
                        return false;
                    } else {
                        sList.remove(sList.size() - 1);
                        break;
                    }
                case '{':
                    sList.add(sArr[i]);
                    break;
                case '}':
                    if (sList == null || sList.size() == 0 || !sList.get(sList.size() - 1).equals('{')) {
                        return false;
                    } else {
                        sList.remove(sList.size() - 1);
                        break;
                    }
                case '[':
                    sList.add(sArr[i]);
                    break;
                case ']':
                    if (sList == null || sList.size() == 0 || !sList.get(sList.size() - 1).equals('[')) {
                        return false;
                    } else {
                        sList.remove(sList.size() - 1);
                        break;
                    }
            }
        }
        if (sList.size() == 0 || sList == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}
