package com.li.Easy;

/**
 * 14 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
class _14LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (String s : strs) {
            if (s == null || s.length() == 0)
                return "";
        }

        if (strs.length == 1) return strs[0];

        String prefix = strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            prefix = commonPrefix(prefix, strs[i + 1]);
        }
        return prefix;

    }

    private static String commonPrefix(String str1, String str2) {
        String prefix = str1;
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (prefix.charAt(i) != str2.charAt(i)) {
                prefix = prefix.substring(0, i);
                break;
            }
        }

        if (prefix == null || prefix.length() == 0) {
            return "";
        } else if (prefix.length() > len) {
            return prefix.substring(0, len);
        } else {
            return prefix;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {"ca", "a"};
        System.out.println(longestCommonPrefix(strs3));
        // System.out.println(longestCommonPrefix(new String[]{""}));
    }

}