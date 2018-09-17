package com.li.Easy;

/**
 * 9 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
class _9PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x >= 0 && x <= 9) return true;
        if (x < 0 || x % 10 == 0) return false;

        int rev = 0;
        while (x > rev) {
            int pop = x % 10;
            rev = rev * 10 + pop;
            x /= 10;
            if (x == rev || x / 10 == rev) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}
