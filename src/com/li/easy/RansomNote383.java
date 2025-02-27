package com.li.easy;

/**
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 *
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote 和 magazine 由小写英文字母组成
 *
 */
public class RansomNote383 {

    public static void main(String[] args) {
        String[] ransomNotes = {
                "a",//false
                "aa",//false
                "aa"//true
        };
        String[] magazines = {"b", "ab", "aab"};
        for (int i = 0; i < ransomNotes.length; i++) {
            System.out.println(canConstructOri(ransomNotes[i], magazines[i]));
        }
    }

    /**
     * 原创：固定数组。
     * time: O(N), space:O(1)
     */
    public static boolean canConstructOri(String ransomNote, String magazine) {
        int m = magazine.length();
        int n = ransomNote.length();
        if (m < n) {
            return false;
        }

        int[] tCnt = new int[26];
        char[] target = ransomNote.toCharArray();
        char[] source = magazine.toCharArray();
        for (char s : source) {
            tCnt[s - 'a']++;
        }
        for (char t : target) {
            tCnt[t - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (tCnt[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
