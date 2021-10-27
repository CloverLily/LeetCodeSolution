package com.li.easy;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author system
 */
public class ClimbingStairs070 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /**
     * 递归法求阶梯问题
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] stairsBP = new int[n];
        stairsBP[0] = 1;
        stairsBP[1] = 2;

        return climbStairs(n, stairsBP);
    }

    private static int climbStairs(int n, int[] stairsBP) {
        if (stairsBP[n - 1] == 0) {
            if (stairsBP[n - 2] == 0) stairsBP[n - 2] = climbStairs(n - 1, stairsBP);
            if (stairsBP[n - 3] == 0) stairsBP[n - 3] = climbStairs(n - 2, stairsBP);
            stairsBP[n - 1] = stairsBP[n - 2] + stairsBP[n - 3];
        }
        return stairsBP[n - 1];
    }


    /**
     * 非递归法求阶梯问题
     */
    public static int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] stairsBP = new int[n];
        stairsBP[0] = 1;
        stairsBP[1] = 2;

        for (int i = 2; i < n; i++) {
            stairsBP[i] = stairsBP[i - 1] + stairsBP[i - 2];
        }
        return stairsBP[n - 1];

    }
}
