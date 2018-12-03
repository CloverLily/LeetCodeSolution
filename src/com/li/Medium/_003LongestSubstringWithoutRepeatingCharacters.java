package com.li.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

        int i = 0, j = 1;
        Map<Character,Integer> strSet = new HashMap<>();
        while (j < s.length()) {
            if (!strSet.containsKey(s.charAt(j))) {
                strSet.put(s.charAt(j),j);
                j++;
            } else {
                //i直接跳到重复位置
                i=Math.max(strSet.get(s.charAt(j)),i);
            }

        }


        return j-i;
    }
}

/**
 * Java（假设字符集为 ASCII 128）
 *
 * 以前的我们都没有对字符串 s 所使用的字符集进行假设。
 *
 * 当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
 *
 * 常用的表如下所示：
 *
 * int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’
 * int [128] 用于ASCII码
 * int [256] 用于扩展ASCII码
 *
 * public class Solution {
 *     public int lengthOfLongestSubstring(String s) {
 *         int n = s.length(), ans = 0;
 *         int[] index = new int[128]; // current index of character
 *         // try to extend the range [i, j]
 *         for (int j = 0, i = 0; j < n; j++) {
 *             i = Math.max(index[s.charAt(j)], i);
 *             ans = Math.max(ans, j - i + 1);
 *             index[s.charAt(j)] = j + 1;
 *         }
 *         return ans;
 *     }
 * }
 *
 * 复杂度分析
 *
 * 时间复杂度：O(n)，索引j将会迭代n次。
 *
 * 空间复杂度（HashMap）：O(min(m, n))，与之前的方法相同。
 *
 * 空间复杂度（Table）：O(m)，m 是字符集的大小。
 */
