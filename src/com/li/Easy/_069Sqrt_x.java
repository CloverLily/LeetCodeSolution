package com.li.Easy;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class _069Sqrt_x {
    public static void main(String[] args) {
        System.out.println("sqrt(4)=" + mySqrt(4));
    }

    public static int mySqrt(int x) {
        int i = x/2;
        while (true) {
            if ((i * i) <= x && (i + 1) * (i + 1) >= x) {
                if ((i + 1) * (i + 1) == x) {
                    return i + 1;
                } else {
                    return i;
                }
            }
           // i++;
        }
    }

}
