package com.li.easy;
/**
 * 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 *
 * 提示：
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @author system
 */
public class FindTheIndexOfTheFirstOccurrenceInAString028 {

    public static void main(String[] args) {
        String[] haystack = {
                "sadbutsad", //0
                "leetcode"//-1
        };
        String[] needle = {
                "sad",
                "leeto"
        };
        for (int i = 0; i < haystack.length; i++) {
            System.out.println(strStrBest(haystack[i], needle[i]));
//            System.out.println(strStr(haystack[i], needle[i]));
        }
    }

    /**
     * 暴力解法,挨个比较
     * time:O(N*M), space:O(1)
     */
    public static int strStrBest(String haystack, String needle) {
        int sourceLength = haystack.length();
        int targetLength = needle.length();
        if (sourceLength < targetLength) {
            return -1;
        }

        int startIndex;
        int j = 0;
        for (int i = 0; (i + targetLength) <= sourceLength; i++) {
            startIndex = i;
            while (j < targetLength) {
                if (haystack.charAt(startIndex) != needle.charAt(j)) {
                    j = 0;
                    break;
                } else {
                    startIndex++;
                    j++;
                }
            }
            if (j == targetLength) {
                return i;
            }
        }
        return -1;
    }

    /**
     * time:O(N), space: O(1)
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
