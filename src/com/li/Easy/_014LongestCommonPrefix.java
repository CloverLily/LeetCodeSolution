package com.li.Easy;

/**
 * 14 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
class _014LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        //若数组中只有一个元素，则该元素即为最长公共前缀
        if (strs.length == 1) return strs[0];

        //若字符数组中存在空字符，则该数组不存在最长公共前缀
        for (String s : strs) {
            if (s == null || s.length() == 0) {
                return "";
            }
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
        }
        return prefix;

    }

    private static String commonPrefix(String str1, String str2) {
        String prefix = str1;
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLen; i++) {
            if (prefix.charAt(i) != str2.charAt(i)) {
                return prefix.substring(0, i);
            }
        }
        return prefix.substring(0,minLen);
    }

    //测试
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {"aa", "a"};
        System.out.println("a：" + longestCommonPrefix(strs3) +
                "\nfl:" + longestCommonPrefix(strs) +
                "\n空：" + longestCommonPrefix(strs2));
        System.out.println("空：" + longestCommonPrefix(new String[]{""}));
    }

}