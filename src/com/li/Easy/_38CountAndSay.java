package com.li.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 38 报数
 * 报数序列是指一个整照其中的整数的顺序进数序列，按行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 */
public class _38CountAndSay {
    public static String[] strArr = new String[30];

    public static void main(String[] args) {
        strArr[0] = "1";
        strArr[1] = "11";
        System.out.println(countAndSay(9));
    }

    public static String countAndSay(int n) {

        while (strArr[n - 1] == null) {
            if (strArr[n - 2] != null) {
                strArr[n - 1] = count(strArr[n - 2]);
            } else {
                strArr[n - 2] = countAndSay(n - 1);
            }
        }
        return strArr[n - 1];
    }

    private static String count(String s) {
        char[] sChar = s.toCharArray();
        //存放字符
        List<Character> charList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < sChar.length; i++) {
            int index = charList.indexOf(sChar[i]);
            if (index != -1) {
                int val = countList.get(index);
                countList.set(index, val + 1);
            } else {
                charList.add(sChar[i]);
                countList.add(1);
            }
        }

        StringBuffer countSb = new StringBuffer();
        for (int i = 0; i < charList.size(); i++) {
            countSb.append(countList.get(i));
            countSb.append(charList.get(i));
        }

        return countSb.toString();
    }
}
