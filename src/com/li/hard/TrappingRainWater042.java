package com.li.hard;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水
 * （蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 */
public class TrappingRainWater042 {

    public static void main(String[] args) {
        int[][] heights = {
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},//6
                {4, 2, 0, 3, 2, 5}//9
        };
        for (int[] height : heights) {
//            System.out.println(trap(height));
            System.out.println(trapBest(height));
        }
    }

    /**
     * 参考官方：
     * 双指针同时从左从右出发，对比当前最小的最大高度则继续遍历
     * Math.min(leftMax[i], rightMax[i])-height[i]
     * time:O(N), space:O(1)
     */
    public static int trapBest(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int res = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                res += (leftMax - height[left]);
                leftMax = Math.max(leftMax, height[++left]);
            } else {
                res += (rightMax - height[right]);
                rightMax = Math.max(rightMax, height[--right]);
            }
        }
        return res;
    }

    /**
     * 参考官方：
     * 从左遍历一遍计算i的左侧闭区间最大高度，
     * 再从右遍历计算i的右侧闭区间最大高度并计算i的雨水量:
     * Math.min(leftMax[i], rightMax[i])-height[i]
     * time:O(N), space:O(N)
     */
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int rightMax = height[n - 1];
        int res = Math.min(leftMax[n - 1], rightMax) - height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax = Math.max(rightMax, height[j]);
            res += (Math.min(leftMax[j], rightMax) - height[j]);
        }
        return res;
    }
}
