package com.li.medium;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 *
 * 提示：
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
public class ContainerWithMostWater011 {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 8, 6, 2, 5, 4, 8, 3, 7},//49
                {1, 1}//1
        };
        for (int[] height : heights) {
            System.out.println(maxArea(height));
        }
    }

    /**
     * 原创：贪心
     * time:O(N),space:O(1)
     */
    public static int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxArea = 0;
        int area;
        while (i < j) {
            area = (j - i) * Math.min(height[i], height[j]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
