package com.li.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。(个人理解：|/| 形排列)
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class ZigzagConversion006 {
    public static void main(String[] args) {
        String[] s = {
                "PAYPALISHIRING", //PAHNAPLSIIGYIR
                "PAYPALISHIRING", //PINALSIGYAHRPI
                "A",//A
                "AB"//AB
        };
        int[] numRows = {
                3,
                4,
                1,
                1
        };
        for (int i = 0; i < s.length; i++) {
            System.out.println(convert(s[i], numRows[i]));
        }
    }

    /**
     * 原创：按行分别赋值
     * time: O(N), space:O(N)
     */
    public static String convert(String s, int numRows) {
        int n = s.length();
        if (n <= numRows || numRows == 1) {
            return s;
        }

        List<StringBuffer> rowList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rowList.add(new StringBuffer());
        }

        int x = 0;
        boolean isDown = true;
        for (int i = 0; i < n; i++) {
            rowList.get(x).append(s.charAt(i));
            if (x < (numRows - 1) && isDown) {
                x++;
            } else if (x == 0) {
                x++;
                isDown = true;
            } else {
                x--;
                isDown = false;
            }
        }

        StringBuilder res = new StringBuilder();
        for (StringBuffer row : rowList) {
            res.append(row);
        }
        return res.toString();
    }
}
