package com.li.easy;

/**
 * 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author system
 */
public class AddBinary067 {

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
        //a的指针
        int idxA = a.length() - 1;
        //b的指针
        int idxB = b.length() - 1;
        //进位标识
        int carry = 0;

        //二进制位1
        int bin1;
        //二进制位2
        int bin2;
        //和
        int sum;
        //待处理长度
        int length = Math.max(a.length(), b.length());
        char[] result = new char[length];
        while (length > 0) {
            bin1 = idxA < 0 ? 0 : a.charAt(idxA--) - '0';
            bin2 = idxB < 0 ? 0 : b.charAt(idxB--) - '0';
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
