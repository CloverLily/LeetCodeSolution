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
        int x = 2147395599;
        System.out.println("sqrt(" + x + ")=" + mySqrt2(x));
    }

    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0) return 0;

        long x1 = x;
        while ((x1 * x1) > x) {
            x1 = (x1 + x / x1) / 2;
        }
        return (int) x1;
    }

    /**
     * 牛顿迭代法优化：二分牛顿迭代
     */
    public static int mySqrt2(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        int middle;
        while (left + 1 < right) {
            middle = (right + left) / 2;
            if (middle > x / middle) {
                right = middle;
            } else if (middle < x / middle) {
                left = middle;
            } else {
                return middle;
            }
        }

        if (right < x / right) {
            return right;
        } else {
            return left;
        }
    }

}
