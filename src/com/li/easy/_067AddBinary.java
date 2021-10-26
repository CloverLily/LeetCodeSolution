package com.li.easy;

/**
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

    public static void main(String[] args) {
        System.out.println(addBinary("111", "101"));
    }

    /**
     * 返回二进制相加的结果
     *
     * @param a 二进制数a
     * @param b 二进制数b
     * @return 二进制相加
     */
    public static String addBinary(String a, String b) {
        //a的指针，b的指针，进位
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        int length = Math.max(a.length(), b.length());

        int bin1, bin2, sum;
        char[] result = new char[length];
        while (length > 0) {
            bin1 = i < 0 ? 0 : a.charAt(i--) - '0';
            bin2 = j < 0 ? 0 : b.charAt(j--) - '0';
            sum = bin1 + bin2 + carry;
            result[--length] = (char) ('0' + sum % 2);
            carry = sum / 2;

        }
        String resultStr = new String(result);
        if (carry == 1) {
            resultStr = "1" + resultStr;
        }
        return resultStr;
    }
}
