package com.li.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，
 * 例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 *
 * 示例1:
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 *
 *
 * 提示:
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 */
public class WordPattern290 {

    public static void main(String[] args) {
        String[] patterns = {"abba", "abba", "aaaa"};
        String[] s = {
                "dog cat cat dog",//true
                "dog cat cat fish",//false
                "dog cat cat dog"//false
        };
        for (int i = 0; i < s.length; i++) {
            System.out.println(wordPattern(patterns[i], s[i]));
        }
    }

    /**
     * 自解：映射表
     * time:O(N)，space:O(N)
     */
    public static boolean wordPattern(String pattern, String s) {
        char[] pChar = pattern.toCharArray();
        String[] sWords = s.split(" ");
        int m = pChar.length;
        int n = sWords.length;
        if (m != n) {
            return false;
        }

        Map<String, Character> s2p = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (s2p.containsKey(sWords[i])) {
                if (s2p.get(sWords[i]) != pChar[i]) {
                    return false;
                }
            } else {
                if (s2p.containsValue(pChar[i])) {
                    return false;
                }
                s2p.put(sWords[i], pChar[i]);
            }
        }
        return true;
    }
}
