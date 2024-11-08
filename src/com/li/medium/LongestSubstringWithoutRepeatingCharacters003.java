package com.li.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串（子字符串 是字符串中连续的 非空 字符序列。） 的长度。
 * 
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 提示：
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 *
 * @author system
 */
public class LongestSubstringWithoutRepeatingCharacters003 {

    public static void main(String[] args) {
        String[] s = {
                "au",//2
                "abcabcbb",//3
                "bbbbb",//1
                "pwwkew"//3
        };
        for (String str : s) {
            System.out.println(lengthOfLongestSubstring20241106(str));
//            System.out.println(lengthOfLongestSubstring(str));
        }
    }

    /**
     * 滑动窗口，
     * time:O(N),space:O(N)
     */
    public static int lengthOfLongestSubstring20241106(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int i = 0;
        int j = 0;
        int maxCnt = 0;
        Map<Character, Integer> strIndexMap = new HashMap<>();
        while (i <= j && j < n) {
            Integer repeatJ = strIndexMap.get(s.charAt(j));
            if (repeatJ != null && repeatJ >= i) {
                maxCnt = Math.max(maxCnt, j - i);
                i = strIndexMap.get(s.charAt(j)) + 1;
            }
            strIndexMap.put(s.charAt(j), j);
            j++;
        }
        maxCnt = Math.max(maxCnt, j - i);
        return maxCnt;
    }

    /**
     * 滑动窗口解法
     * @param s 字符串
     * @return 最大无重复子字符串中的字符个数
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), max = 0;
        //字符-（索引+1）表
        Map<Character, Integer> strMap = new HashMap<>();
        //创建窗口[i,j]
        for (int i = 0, j = 0; j < n; j++) {
            //判断该字符是否已保存在表中
            if (strMap.containsKey(s.charAt(j))) {
                //如果有且包含在目前的窗口中，则更新左区间的索引为该字符的索引+1,即向右滑动窗口左区间
                i = Math.max(strMap.get(s.charAt(j)), i);
            }
            //保存（该字符，字符的下一个位置）
            strMap.put(s.charAt(j), j + 1);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    /**
     * 较优秀的解法
     * 采用字符矩阵
     *
     * Java（假设字符集为 ASCII 128）
     * 以前的我们都没有对字符串s所使用的字符集进行假设。
     * 当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
     * 常用的表如下所示：
     * int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’
     * int [128] 用于ASCII码
     * int [256] 用于扩展ASCII码
     *
     * 复杂度分析
     * 时间复杂度：O(n)，索引j将会迭代n次。
     * 空间复杂度（HashMap）：O(min(m, n))，与之前的方法相同。
     * 空间复杂度（Table）：O(m)，m 是字符集的大小。
     */
    public static int lengthOfLongestSubstring2(String s) {
        //字符串长度n，最长子字符串中的字符个数max
        int n = s.length(), max = 0;
        // 索引数组（存放字符目前的索引+1）
        int[] index = new int[128];
        // 创建窗口并滑动，最后锁定最长不重复子字符串[i,j]
        for (int j = 0, i = 0; j < n; j++) {
            //如果该字符未出现过，则不更新；
            // 如果该字符已出现但在区间外，即比i小，也不更新；
            // 如果该字符已出现过且在区间中，即比i大，则更新i；
            i = Math.max(index[s.charAt(j)], i);
            max = Math.max(max, j - i + 1);
            //更新该字符数组为：目前的索引+1
            index[s.charAt(j)] = j + 1;
        }
        return max;
    }
}




