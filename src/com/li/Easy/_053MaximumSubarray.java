package com.li.Easy;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class _053MaximumSubarray {

    /**
     * 动态规划
     * * 最重要考虑子问题与主问题的联系
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] numsDp = new int[len];
        numsDp[0] = nums[0];
        int max = numsDp[0];
        for (int i = 1; i < len; i++) {
            numsDp[i] = nums[i] + (numsDp[i - 1] > 0 ? numsDp[i - 1] : 0);
            max = Math.max(max, numsDp[i]);
        }
        return max;
    }

    /**
     * 无需动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum > maxsum)
                maxsum = sum;

            if (sum < 0)
                sum = 0;

        }
        return maxsum;
    }
}
