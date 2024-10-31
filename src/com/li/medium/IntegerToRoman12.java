package com.li.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 12. 整数转罗马数字
 * 七个不同的符号代表罗马数字，其值如下：
 *
 * 符号	值
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 *
 * 罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：
 * 1. 如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
 * 2. 如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，
 * 例如 4 是 5 (V) 减 1 (I): IV ，
 * 9 是 10 (X) 减 1 (I)：IX。
 * 仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
 * 只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。
 * 你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
 * 给定一个整数，将其转换为罗马数字。
 *
 *
 * 示例 1：
 * 输入：num = 3749
 * 输出： "MMMDCCXLIX"
 * 解释：
 * 3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
 *  700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
 *   40 = XL 由于 50 (L) 减 10 (X)
 *    9 = IX 由于 10 (X) 减 1 (I)
 * 注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
 *
 * 示例 2：
 * 输入：num = 58
 * 输出："LVIII"
 * 解释：
 * 50 = L
 *  8 = VIII
 *
 * 示例 3：
 * 输入：num = 1994
 * 输出："MCMXCIV"
 * 解释：
 * 1000 = M
 *  900 = CM
 *   90 = XC
 *    4 = IV
 *
 * 提示：
 * 1 <= num <= 3999
 */
public class IntegerToRoman12 {

    public static void main(String[] args) {
        int[] nums = {
                3749,//MMMDCCXLIX
                58,//LVIII
                1994//MCMXCIV
        };
        for (int num : nums) {
            System.out.println(intToRomanByCode(num));
//            System.out.println(intToRomanBest(num));
//            System.out.println(intToRoman(num));
        }
    }

    protected static String[] thousands = {"", "M", "MM", "MMM"};
    protected static String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    protected static String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    protected static String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    /**
     * 官方：编码表
     * time:O(1), space:O(1)
     *
     */
    public static String intToRomanByCode(int num) {
        StringBuilder roman = new StringBuilder();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[(num % 1000) / 100]);
        roman.append(tens[((num % 1000) % 100) / 10]);
        roman.append(ones[((num % 1000) % 100) % 10]);

        return roman.toString();
    }

    /**
     * 官方：模拟
     * time:O(1), space:O(1)
     *
     */
    public static String intToRomanBest(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (values[i] > num) {
                continue;
            }

            while (num - values[i] >= 0) {
                num -= values[i];
                roman.append(symbol[i]);
            }

        }
        return roman.toString();
    }


    /**
     * 原创；根据情况分析
     * time:O(1), space:O(1)
     *
     */
    public static String intToRoman(int num) {
        Map<Integer, Character> romanMap = new HashMap<>();
        romanMap.put(1, 'I');
        romanMap.put(5, 'V');
        romanMap.put(10, 'X');
        romanMap.put(50, 'L');
        romanMap.put(100, 'C');
        romanMap.put(500, 'D');
        romanMap.put(1000, 'M');

        StringBuilder roman = new StringBuilder();
        while (num > 0) {
            int thousand = num / 1000;
            if (thousand > 0) {
                for (int i = 0; i < thousand; i++) {
                    roman.append(romanMap.get(1000));
                }
                num = num % 1000;
            }

            int hundred = num / 100;
            if (hundred > 0) {
                if (hundred == 9) {
                    roman.append(romanMap.get(100));
                    roman.append(romanMap.get(1000));
                } else if (hundred == 4) {
                    roman.append(romanMap.get(100));
                    roman.append(romanMap.get(500));
                } else {
                    if (hundred >= 5) {
                        roman.append(romanMap.get(500));
                        hundred -= 5;
                    }
                    for (int i = 0; i < hundred; i++) {
                        roman.append(romanMap.get(100));
                    }
                }
                num = num % 100;
            }

            int ten = num / 10;
            if (ten > 0) {
                if (ten == 9) {
                    roman.append(romanMap.get(10));
                    roman.append(romanMap.get(100));
                } else if (ten == 4) {
                    roman.append(romanMap.get(10));
                    roman.append(romanMap.get(50));
                } else {
                    if (ten >= 5) {
                        roman.append(romanMap.get(50));
                        ten -= 5;
                    }
                    for (int i = 0; i < ten; i++) {
                        roman.append(romanMap.get(10));
                    }
                }
                num = num % 10;
            }

            if (num > 0) {
                if (num == 9) {
                    roman.append(romanMap.get(1));
                    roman.append(romanMap.get(10));
                } else if (num == 4) {
                    roman.append(romanMap.get(1));
                    roman.append(romanMap.get(5));
                } else {
                    if (num >= 5) {
                        roman.append(romanMap.get(5));
                        num -= 5;
                    }
                    for (int i = 0; i < num; i++) {
                        roman.append(romanMap.get(1));
                    }
                }
                num = 0;
            }

        }
        return roman.toString();
    }

}
