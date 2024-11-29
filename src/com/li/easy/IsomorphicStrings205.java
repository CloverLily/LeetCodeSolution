package com.li.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 *
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 *
 * 提示：
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 */
public class IsomorphicStrings205 {
    public static void main(String[] args) {
        String[] s = {
                "egg",//true
                "foo",//false
                "paper",//true
                "badc"//false
        };
        String[] t = {"add", "bar", "title", "baba"};
        for (int i = 0; i < s.length; i++) {
            System.out.println(isIsomorphic(s[i], t[i]));
        }
    }

    /**
     * 参考最优解：map+set
     * time:O(N), space:O(N)
     */
    public static boolean isIsomorphic(String s, String t) {
        int m = s.length();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Map<Character, Character> s2t = new HashMap<>();
        Set<Character> t2s = new HashSet<>();
        for (int i = 0; i < m; i++) {
            char x = sChar[i];
            char y = tChar[i];

            if (s2t.containsKey(x)) {
                if (s2t.get(x) != y) {
                    return false;
                }
            } else {
                if (t2s.contains(y)) {
                    return false;
                }
                t2s.add(y);
                s2t.put(x, y);
            }
        }
        return true;
    }
}
