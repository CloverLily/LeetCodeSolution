package com.li.Easy;

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 * lastIndexOf()
 */
public class _58LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        if (s.equals(" ") || s.trim().equals("")) {
            return 0;
        }

        int last = s.lastIndexOf(' ');

        int len = s.length() - s.lastIndexOf(" ") - 1;
        if (len > 0) {
            return len;
        }

        int sum = 0;
        for (int i = last - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                sum++;
            } else if (s.charAt(i) == ' ' && sum != 0) {
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }
}
