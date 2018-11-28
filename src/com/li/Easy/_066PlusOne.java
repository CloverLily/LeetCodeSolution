package com.li.Easy;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class _066PlusOne {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int j = len - 1; j >= 0; j--) {
            //最后一位小于9，不存在进位，该位加一返回
            if (digits[j] != 9) {
                digits[j]++;
                return digits;
            }
            digits[j] = 0;
        }
        //若走到这一步，说明各位数字都是9，存在进位，长度加一
        int[] newDigits = new int[len + 1];
        newDigits[0] = 1;
        return newDigits;

    }

    public static void main(String[] args) {
        for (int i : plusOne(new int[]{9,9,9})) {
            System.out.print(i + ",");
        }
    }
}
