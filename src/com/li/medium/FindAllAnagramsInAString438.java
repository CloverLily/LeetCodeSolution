package com.li.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的
 * 异位词(字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，并使用所有原字母一次。)的子串，
 * 返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 *
 * 提示:
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 */
public class FindAllAnagramsInAString438 {

    public static void main(String[] args) {
        String[] s = {
                "cbaebabacd",//[0,6]
                "abab"//[0,1,2]
        };
        String[] p = {
                "abc",
                "ab"
        };

        for (int i = 0; i < s.length; i++) {
            List<Integer> res = findAnagramsOfficial2(s[i], p[i]);
//            List<Integer> res = findAnagramsOfficial1(s[i], p[i]);
            System.out.print("[");
            for (int r : res) {
                System.out.print(r + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * 官方：优化的滑动窗口
     * time:O(N),space:O(1)
     */
    public static List<Integer> findAnagramsOfficial2(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        int differ = 0;
        for (int j = 0; j < 26; j++) {
            if (count[j] != 0) {
                differ++;
            }
        }

        if (differ == 0) {
            res.add(0);
        }

        for (int i = 0; i < (sLen - pLen); i++) {
            int countOutIndex = s.charAt(i) - 'a';
            if (count[countOutIndex] == 1) {// 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                differ--;
            } else if (count[countOutIndex] == 0) {// 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                differ++;
            }
            count[countOutIndex]--;

            int countInIndex = s.charAt(i + pLen) - 'a';
            if (count[countInIndex] == -1) {// 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                differ--;
            } else if (count[countInIndex] == 0) {// 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                differ++;
            }
            count[countInIndex]++;

            if (differ == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /**
     * 官方：滑动窗口
     * time:O(N),space:O(1)
     */
    public static List<Integer> findAnagramsOfficial1(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        for (int i = 0; i < (sLen - pLen); i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;

            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
