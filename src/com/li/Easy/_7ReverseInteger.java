package com.li.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 7 反转整数
 * 给定一个32位有符号整数，将整数中的数字进行反转。
 */
class _7ReverseInteger {
    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            //溢出则返回0
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) return 0;
            rev = rev * 10 + pop;
            x /= 10;
        }
        return rev;
    }

    //测试
    public static void main(String[] args) {
        //翻转后正常
        System.out.println(reverse(123456789));
        //翻转后溢出
        System.out.println(reverse(1999999999));
    }
}
