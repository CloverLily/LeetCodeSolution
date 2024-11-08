package com.li.hard;

import java.util.*;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 *
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 *
 *
 * 示例 1：
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 *
 * 示例 2：
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 *
 * 示例 3：
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 *
 *
 * 提示：
 * 1 <= s.length <= 10^4
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 和 s 由小写英文字母组成
 *
 */
public class SubstringWithConcatenationOfAllWords030 {

    public static void main(String[] args) {
        String[] s = {
                "a",//[0]
                "wordgoodgoodgoodbestword",//[8]
                "barfoothefoobarman",//[0,9]
                "wordgoodgoodgoodbestword",//[]
                "barfoofoobarthefoobarman"//[6,9,12]
        };
        String[][] words = {
                {"a"},
                {"word","good","best","good"},
                {"foo", "bar"},
                {"word", "good", "best", "word"},
                {"bar", "foo", "the"}
        };
        for (int i = 0; i < s.length; i++) {
            List<Integer> resList = findSubstring(s[i], words[i]);
            System.out.print("[");
            for (Integer res : resList) {
                System.out.print(res + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    /**
     * 参考官方：滑动窗口 + 合并同类
     * time: O(ls×m)，其中 ls 是输入 s 的长度，m 是 words 中每个单词的长度。需要做 m 次滑动窗口，每次需要遍历一次 s。
     * space：O(m×n)，其中 n 是 words 的单词数，m是 words 中每个单词的长度。每次滑动窗口时，需要用一个哈希表保存单词频次。
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        int ls = s.length();
        int n = words.length;
        int m = words[0].length();
        List<Integer> resList = new ArrayList<>();
        if (ls < n * m) {
            return resList;
        }

        for (int i = 0; i < m; i++) {
            if (i + m * n > ls) {
                break;
            }

            Map<String, Integer> matchMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String subStr = s.substring(i + j * m, i + (j + 1) * m);
                matchMap.put(subStr, matchMap.getOrDefault(subStr, 0) + 1);
            }

            for (String word : words) {
                matchMap.put(word, matchMap.getOrDefault(word, 0) - 1);
                if (matchMap.get(word) == 0) {
                    matchMap.remove(word);
                }
            }

            for (int start = i; start < ls - n * m + 1; start += m) {
                if (start != i) {
                    String subStr = s.substring(start + m * (n - 1), start + m * n);
                    matchMap.put(subStr, matchMap.getOrDefault(subStr, 0) + 1);
                    if (matchMap.get(subStr) == 0) {
                        matchMap.remove(subStr);
                    }

                    subStr = s.substring(start - m, start);
                    matchMap.put(subStr, matchMap.getOrDefault(subStr, 0) - 1);
                    if (matchMap.get(subStr) == 0) {
                        matchMap.remove(subStr);
                    }
                }
                if (matchMap.isEmpty()) {
                    resList.add(start);
                }
            }
        }
        return resList;
    }

    /*
     * 滑动窗口示意图：同一类的窗口放在同一批i的遍历中，方便每次一个单词的步数，剔除左侧滑走的单词，同时加上右侧滑入的单词，这样可以节省了中间重叠的单词的匹配。
     * s								barfoofoobarthefoobarman
     * words								"bar", "foo", "the"
     *
     * index					0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21	22	23
     * s[index]					b	a	r	f	o	o	f	o	o	b	a	r	t	h	e	f	o	o	b	a	r	m	a	n
     *
     * i=0
     * 滑动窗口start = 0			b	a	r	f	o	o	f	o	o
     *
     * 滑动窗口start = 3						f	o	o	f	o	o	b	a	r
     *
     * 滑动窗口start = 6									f	o	o	b	a	r	t	h	e
     *
     * 滑动窗口start = 9												b	a	r	t	h	e	f	o	o
     *
     * 滑动窗口start = 15														t	h	e	f	o	o	b	a	r
     *
     * 滑动窗口start = 15																	f	o	o	b	a	r	m	a	n
     *
     * i=1
     * 滑动窗口start =1				a	r	f	o	o	f	o	o	b
     *
     * 滑动窗口start = 4							o	o	f	o	o	b	a	r	t
     *
     * 滑动窗口start = 7										o	o	b	a	r	t	h	e	f
     *
     * 滑动窗口start = 10												a	r	t	h	e	f	o	o	b

     * 滑动窗口start = 13															h	e	f	o	o	b	a	r	m
     *
     * ...
     *
     */
}
