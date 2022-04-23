package com.li.easy;

import java.util.HashMap;
import java.util.Map;

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
 *     1 <= ransomNote.length, magazine.length <= 10^5
 *     ransomNote 和 magazine 由小写英文字母组成
 */
public class RansomNote383 {

    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        String ransomNote2 = "aa", magazine2 = "ab";
        String ransomNote3 = "aa", magazine3 = "aab";


        System.out.println(canConstruct(ransomNote3, magazine3));
        System.out.println(canConstruct2(ransomNote3, magazine3));

    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] magazineLetterCnt = new int[26];

        for (char m : magazine.toCharArray()) {
            magazineLetterCnt[m - 'a']++;
        }

        for (char r : ransomNote.toCharArray()) {
            magazineLetterCnt[r - 'a']--;
            if (magazineLetterCnt[r - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineArr = magazine.toCharArray();

        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazineArr) {
            if (magazineMap.containsKey(c)) {
                magazineMap.put(c, magazineMap.get(c) + 1);
            } else {
                magazineMap.put(c, 1);
            }
        }

        char[] ransomNoteArr = ransomNote.toCharArray();
        for (char ransomNoteChar : ransomNoteArr) {
            if (magazineMap.containsKey(ransomNoteChar) && magazineMap.get(ransomNoteChar) > 0) {
                magazineMap.put(ransomNoteChar, magazineMap.get(ransomNoteChar) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
