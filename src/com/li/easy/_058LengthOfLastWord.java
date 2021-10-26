package com.li.easy;

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * lastIndexOf()
 */
public class _058LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        //如果是空字符串直接返回0
        if (s == null || s.length() == 0) {
            return 0;
        }

        //剔除末端空格
        s = s.trim();
        //最后一个空格的索引
        int last = s.lastIndexOf(' ');

        return s.length() - last - 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("b a  "));
    }
}
