package com.li.easy;

/**
 * 14 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author system
 */
public class LongestCommonPrefix014 {

    public static String longestCommonPrefix(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }

        //若数组中只有一个元素，则该元素即为最长公共前缀
        if (strArr.length == 1) {
            return strArr[0];
        }

        //若字符数组中存在空字符，则该数组不存在最长公共前缀
        for (String s : strArr) {
            if (s == null || s.length() == 0) {
                return "";
            }
        }

        String prefix = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            prefix = commonPrefix(prefix, strArr[i]);
        }
        return prefix;
    }

    private static String commonPrefix(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0,minLen);
    }

    public static void main(String[] args) {
        String[] strArr = {"flower", "flow", "flight"};
        String[] strArr2 = {"dog", "race", "car"};
        String[] strArr3 = {"aa", "a"};
        System.out.println("a：" + longestCommonPrefix(strArr3) +
                "\nfl:" + longestCommonPrefix(strArr) +
                "\n空：" + longestCommonPrefix(strArr2));
        System.out.println("空：" + longestCommonPrefix(new String[]{""}));
    }

}