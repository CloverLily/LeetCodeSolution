package com.li.easy;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大 子字符串(子字符串 是字符串中连续的 非空 字符序列。)。
 *
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为 5。
 *
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为 4。
 *
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为 6 的“joyboy”。
 *
 *
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * 
 * @author system
 */
public class LengthOfLastWord058 {

    public static void main(String[] args) {
        String[] s = {"Hello World", //5
                "   fly me   to   the moon  ",//4
                "luffy is still joyboy"};//6
        for (String word : s) {
            System.out.println(lengthOfLastWord(word));
        }
    }

    /**
     * lastIndexOf
     * time: O(n), space:O(1)
     */
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int leftIndex = s.lastIndexOf(" ");
        return s.length() - leftIndex - 1;
    }


}
