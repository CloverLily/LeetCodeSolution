package com.li.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class _067AddBinary {

    public String addBinary(String a, String b) {

        int maxLen = Math.max(a.length(), b.length());
        int minLen = Math.min(a.length(), b.length());
        //存放二进制相加后结果集
        int[] binarySum = new int[maxLen + 1];
        List l = new ArrayList();
        int sum = 0;
        int carry = 0;
        for (int i = minLen - 1; i >= 0; i--) {
            sum = a.charAt(i) + b.charAt(i) + carry;
            if (sum != 2) {
                binarySum[i + 1] = sum;
            }
            binarySum[i + 1] = 0;
            carry = 1;

        }

//        for (int j = maxLen - minLen - 1; j >) {
//
//        }

        return null;
    }

    public String addBinary2(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        int minLen = Math.min(a.length(), b.length());

        for (int i = minLen-1; i >=0 ; i--) {

        }

        return null;
    }
}
