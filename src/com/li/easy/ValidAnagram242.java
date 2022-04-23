package com.li.easy;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *     1 <= s.length, t.length <= 5 * 10^4
 *     s 和 t 仅包含小写字母
 * @author kang
 */
public class ValidAnagram242 {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        String s2 = "rat", t2 = "car";

        System.out.println(isAnagram(s2, t2));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] tLetterCnt = new int[26];

        for (char c : t.toCharArray()) {
            tLetterCnt[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            tLetterCnt[c - 'a']--;
            if (tLetterCnt[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
