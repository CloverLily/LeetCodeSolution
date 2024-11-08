package com.li.hard;


/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 *
 * 提示：
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s 和 t 由英文字母组成
 *
 *
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */
public class MinimumWindowSubstring076 {

    public static void main(String[] args) {
        String[] s = {
                "aa",//"aa"
                "bba",//"ba"
                "ADOBECODEBANC",//"BANC"
                "a",//"a"
                "a",//""
        };
        String[] t = {
                "aa",
                "ab",
                "ABC",
                "a",
                "aa"
        };
        for (int i = 0; i < s.length; i++) {
            System.out.println("\"" + minWindow(s[i], t[i]) + "\"");
        }
    }

    /**
     * 参考最优解：ASCII表转数组 + 滑动窗口。
     * time:O(N) , pace:O(1)
     */
    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }

        int[] tCode = new int[128];
        for (char c : t.toCharArray()) {
            tCode[c]++;
        }

        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = m + 1;
        int have = 0;
        int need = t.length();
        char[] sArr = s.toCharArray();
        while (right < m) {
            if (tCode[sArr[right]] > 0) {
                have++;
            }
            tCode[sArr[right]]--;

            //满足最小字符串后开始从左缩短该字符串长度
            if (have == need) {
                while (left < right && tCode[sArr[left]] < 0) {
                    tCode[sArr[left]]++;
                    left++;
                }
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    start = left;
                }
            }
            right++;
        }
        return minLen == m + 1 ? "" : s.substring(start, start + minLen);
    }

}
