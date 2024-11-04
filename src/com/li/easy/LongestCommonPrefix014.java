package com.li.easy;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author system
 */
public class LongestCommonPrefix014 {

    public static void main(String[] args) {
        String[][] strArr = {
                {"flower", "flow", "flight"},//fl
                {"dog", "racecar", "car"},//""
                {""}//""
        };
        for (String[] str : strArr) {
            System.out.println("\"" + longestCommonPrefix(str) + "\"");
        }
    }

    /**
     * 纵向搜索，
     * time: O(N*M), space: O(1)
     */
    public static String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        int length = strs[0].length();
        if (count == 1) {
            return strs[0];
        }


        for (int i = 0; i < length; i++) {
            char charStr = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (strs[j].length() <= i || charStr != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 纵向扫描
     *
     */
    public static String longestCommonPrefixOld(String[] strArr) {
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

}