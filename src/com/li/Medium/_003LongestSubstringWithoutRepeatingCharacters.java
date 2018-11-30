package com.li.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * <p>
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class _003LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.trim().length() == 0) {
            return 1;
        }
        int i = 0, j = i;
        int max = Integer.MIN_VALUE;
        int count = 0;
        Set<Character> strSet = new HashSet<>();
        while (j < s.length()) {
            if (!strSet.contains(s.charAt(j))) {
                strSet.add(s.charAt(j));
                count++;
                j++;
            } else {
                if (max < count) {
                    max = count;
                }
                i++;
                j = i;
                count = 0;
                strSet.clear();
            }

            if (max >= (s.length() - i)) {
                return max;
            }
        }

        if (max < count) {
            max = count;
        }

        return max;
    }
}
