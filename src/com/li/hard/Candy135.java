package com.li.hard;

/**
 * 135. 分发糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *
 *
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 *
 * 示例 2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 *
 * 提示：
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 */
public class Candy135 {

    public static void main(String[] args) {
        int[][] ratings = {
                {1, 0, 2},//5
                {1, 2, 2}//4
        };
        for (int[] rating : ratings) {
            System.out.println(candy(rating));
        }
    }

    /**
     * 官方: 先走一遍rating[i] > ratings[i-1]
     * 再走一遍rating[i] > ratings[i+1],两者取最大值
     * time:O(N), space: O(N)
     *
     */
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int right = 1;
        int sumCandy = Math.max(left[n - 1], 1);
        for (int j = n - 2; j >= 0; j--) {
            if (ratings[j + 1] < ratings[j]) {
                right += 1;
            } else {
                right = 1;
            }
            sumCandy += Math.max(left[j], right);
        }
        return sumCandy;
    }

}
