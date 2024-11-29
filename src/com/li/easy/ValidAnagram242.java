package com.li.easy;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
 * 字母异位词（字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，并使用所有原字母一次。）。
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
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t 仅包含小写字母
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 */
public class ValidAnagram242 {

    public static void main(String[] args) {
        String[] s = {
                "anagram",//true
                "rat"//false
        };
        String[] t = {
                "nagaram",
                "car"
        };
        for (int i = 0; i < s.length; i++) {
            System.out.println(isAnagram(s[i], t[i]));
        }
    }

    /**
     * 自解：字母映射数组
     * time:O(N), space:O(1)
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sChar = new int[26];
        for (char c : s.toCharArray()) {
            sChar[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            int index = c - 'a';
            sChar[index]--;
            if (sChar[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
