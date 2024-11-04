package com.li.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 *
 * 示例 1:
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 *
 * 示例 2:
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 *
 *
 * 示例 3:
 * 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is",
 * "everything","else","we","do"]，maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *["ask   not   what",
 * "your country can",
 * "do  for  you ask",
 * "what  you can do",
 * "for your country"]
 *
 * 提示:
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */
public class TextJustification068 {

    public static void main(String[] args) {
        String[][] words = {
                {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"},
                {"This", "is", "an", "example", "of", "text", "justification."},
                {"What", "must", "be", "acknowledgment", "shall", "be"},
                {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}
        };
        int[] maxWidth = {
                16,
                16,
                16,
                20
        };
        for (int i = 0; i < words.length; i++) {
            List<String> resList = fullJustify(words[i], maxWidth[i]);
            for (String res : resList) {
                System.out.println("\"" + res + "\"");
            }
            System.out.println();
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> resList = new ArrayList<>();
        List<List<String>> rowWordsList = new ArrayList<>();
        List<Integer> rowWordWidths = new ArrayList<>();

        //每一行有哪些单词
        int sum = words[0].length();
        int rowWidth = words[0].length();
        List<String> wordList = new ArrayList<>();
        wordList.add(words[0]);
        rowWordsList.add(wordList);
        int i = 1;
        while (i < n) {
            if (sum + 1 + words[i].length() > maxWidth) {
                rowWordWidths.add(rowWidth);

                rowWidth = words[i].length();
                sum = words[i].length();
                wordList = new ArrayList<>();
                rowWordsList.add(wordList);
            } else {
                sum += (1 + words[i].length());
                rowWidth += words[i].length();
            }
            wordList.add(words[i]);
            i++;
        }
        rowWordWidths.add(rowWidth);

        //拼接每一行字符串
        for (int j = 0; j < rowWordWidths.size(); j++) {
            int restWidth = maxWidth - rowWordWidths.get(j);
            int blankLocates = rowWordsList.get(j).size() - 1;
            StringBuffer sb = new StringBuffer();
            for (int k = 0; k < rowWordsList.get(j).size(); k++) {
                sb.append(rowWordsList.get(j).get(k));
                int m = blankNum(j, k, restWidth, blankLocates, rowWordWidths.size(), rowWordsList.get(j).size());
                restWidth -= m;
                blankLocates--;
                while (m > 0) {
                    sb.append(" ");
                    m--;
                }

            }
            resList.add(sb.toString());
        }
        return resList;
    }

    /**
     * 计算单词间空格数量
     * @param j 行数
     * @param k 单词index
     * @param restWidth 总剩余空格数
     * @param blankLocates 剩余空格位置
     * @param rowSize 总行数
     * @param wordsSize 第j行的单词总数
     * @return 当前位置空格数量
     */
    private static int blankNum(int j, int k, int restWidth, int blankLocates, int rowSize, int wordsSize) {
        if (j == rowSize - 1) {//最后一行左对齐
            if (k == wordsSize - 1) {
                return restWidth;
            } else {
                return 1;
            }
        } else {
            if (blankLocates == 0) {
                return restWidth;
            } else {
                return restWidth / blankLocates + ((restWidth % blankLocates) != 0 ? 1 : 0);
            }
        }
    }
}
