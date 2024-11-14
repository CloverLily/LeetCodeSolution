package com.li.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 *
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 *
 * 提示：
 * 1 <= n <= 2^31 - 1
 */
public class HappyNumber202 {

    public static void main(String[] args) {
        int[] n = {
                10,//true
                1111111,//true
                19,//true
                2//false
        };
        for (int num : n) {
//            System.out.println(isHappy(num));
            System.out.println(isHappyFast(num));
        }
    }

    /**
     * 官方：快慢指针
     * time:O(logN), space: O(1)
     */
    public static boolean isHappyFast(int n) {
        int slowSquSum = n;
        int fastSquSum = n;
        while (true) {
            slowSquSum = getNext(slowSquSum);
            fastSquSum = getNext(getNext(fastSquSum));

            if (fastSquSum == 1) {
                return true;
            }

            if (slowSquSum == fastSquSum) {
                return false;
            }
        }
    }

    /**
     * 获取下一个n
     */
    private static int getNext(int n) {
        int squSum = 0;
        int num;
        while (n > 0) {
            num = n % 10;
            n = n / 10;
            squSum += num * num;
        }
        return squSum;
    }

    /**
     * 官方：哈希集合
     * time:O(logN) space:O(logN)
     */
    public static boolean isHappy(int n) {
        int squSum;
        Set<Integer> squSums = new HashSet<>();
        while (true) {
            squSum = 0;
            int num;
            while (n > 0) {
                num = n % 10;
                n = n / 10;
                squSum += num * num;
            }

            if (squSum == 1) {
                return true;
            }
            if (squSums.contains(squSum)) {
                return false;
            }

            squSums.add(squSum);
            n = squSum;
        }
    }
}
