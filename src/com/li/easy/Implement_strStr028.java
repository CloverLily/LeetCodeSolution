package com.li.easy;

/**
 * 28. 实现strStr()
 * 返回haystack中第一次出现needle的位置索引
 *
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @author system
 */
public class Implement_strStr028 {
    public int strStr(String haystack, String needle) {
        //String的indexOf()方法源代码
        return haystack.indexOf(needle);
    }
}
