package com.li.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 *
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 *
 * 提示:
 *
 *     1 <= s.length <= 10^5
 *     s 只包含小写字母
 */
public class FirstUniqueCharacterInAString387 {

    public static void main(String[] args) {

        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println(firstUniqChar(s3));

    }

    public static int firstUniqChar(String s) {
        char[] sArr = s.toCharArray();

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sArr.length; i++) {
            if (indexMap.containsKey(sArr[i])) {
                indexMap.put(sArr[i], -1);
            } else {
                indexMap.put(sArr[i], i);
            }
        }

        int minIndex = sArr.length;
        for (Integer index : indexMap.values()) {
            if (index != -1 && index < minIndex) {
                minIndex = index;
            }
        }

        return minIndex == sArr.length ? -1 : minIndex;
    }

}
