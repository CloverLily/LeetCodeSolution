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
public class _038CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String say = "1";
        for (int i = 1; i < n; i++) {
            String temp = count(say);
            say = temp;
        }
        return say;
    }

    private static String count(String s) {
        StringBuilder countStr = new StringBuilder();
        char sub = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (sub != s.charAt(i)) {
                countStr.append(count).append(sub);
                sub = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        countStr.append(count).append(sub);
        return countStr.toString();
    }
}
