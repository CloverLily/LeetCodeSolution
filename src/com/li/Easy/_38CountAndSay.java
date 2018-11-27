package com.li.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 38 报数
 * 报数序列是指一个整照其中的整数的顺序进数序列，按行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 */
public class _38CountAndSay {

    private static String[] countArr = new String[30];


    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        countArr[0] = "1";
        countArr[1] = "11";

        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        }

        return getCount(n);
    }

    private static String getCount(int n) {
        while (countArr[n - 1] == null) {
            if (countArr[n - 2] != null) {
                countArr[n - 1] = count(countArr[n - 2]);
            } else {
                countArr[n - 2] = getCount(n - 1);
            }
        }

        return countArr[n - 1];
    }

    private static String count(String s) {
        char[] sChar = s.toCharArray();
        StringBuffer countStr = new StringBuffer();

        int i = 0;
        int j = i + 1;
        int count = 1;
        while (i < sChar.length) {
            if (i == sChar.length - 1) {
                countStr.append(count);
                countStr.append(sChar[i]);
            } else if (j<sChar.length && sChar[i] == sChar[j]) {
                count++;
                j++;//有问题，走到头需要计数
                if (j >= sChar.length) {
                    countStr.append(count);
                    countStr.append(sChar[i]);
                }
            } else {
                countStr.append(count);
                countStr.append(sChar[i]);
                count = 1;
                i = j;
                j = i + 1;
            }
        }
        return countStr.toString();
    }
}
