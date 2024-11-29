package com.li.medium;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [
 * ["bat"],
 * ["nat","tan"],
 * ["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class GroupAnagrams049 {
    public static void main(String[] args) {
        String[][] strs = {
                {"eat", "tea", "tan", "ate", "nat", "bat"},//[["bat"],["nat","tan"],["ate","eat","tea"]]
                {""},//[[""]]
                {"a"}//[["a"]]
        };
        for (String[] str : strs) {
            System.out.print("[");
            List<List<String>> resList = groupAnagrams(str);
            for (List<String> resStr : resList) {
                System.out.print("[");
                for (String s : resStr) {
                    System.out.print(s + " ");
                }
                System.out.print("]");
            }
            System.out.println("]");
        }
    }

    /**
     * 参考最优解：字符串排序。
     * time: O(nklogk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。
     * space:O(nk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。
     */
    public List<List<String>> groupAnagramsOfficial(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = anagramMap.getOrDefault(key, new ArrayList<>());
            list.add(str);
            anagramMap.put(key, list);
        }
        return new ArrayList<>(anagramMap.values());
    }

    /**
     * 自解：对比异位词
     * time: O(n(k+∣Σ∣))，
     * space: O(n(k+∣Σ∣))
     * 其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度，
     * Σ 是字符集，在本题中字符集为所有小写字母，∣Σ∣=26
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new ArrayList<>();
        int n = strs.length;
        if (n == 1) {
            resList.add(Collections.singletonList(strs[0]));
            return resList;
        }

        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            boolean isFindAnagramStr = false;
            for (Map.Entry<String, List<String>> entrySet : anagramMap.entrySet()) {
                if (isAnagramStr(s, entrySet.getKey())) {
                    List<String> anagramList = entrySet.getValue();
                    anagramList.add(s);
                    anagramMap.put(entrySet.getKey(), anagramList);
                    isFindAnagramStr = true;
                    break;
                }
            }
            if (!isFindAnagramStr) {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(s);
                anagramMap.put(s, anagramList);
            }
        }
        resList.addAll(anagramMap.values());
        return resList;
    }

    /**
     * 是否字母异位词
     * @param s 字符串s
     * @param t 被对比字符串t
     * @return s和t是否为字母异位词
     */
    private static boolean isAnagramStr(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }

        int[] mapChar = new int[26];
        for (char c : s.toCharArray()) {
            mapChar[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            mapChar[c - 'a']--;
            if (mapChar[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
