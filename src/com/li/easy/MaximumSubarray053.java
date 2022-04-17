package com.li.easy;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * @author kang
 */
public class MaximumSubarray053 {

    public static void main(String[] args) {
        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray0411(nums));
    }

    private static int maxSubArray0411(int[] nums) {
        int localSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            localSum += num;
            localSum = Math.max(localSum, num);
            maxSum = Math.max(localSum, maxSum);
        }
        return maxSum;
    }

    /**
     * 动态规划
     * * 最重要考虑子问题与主问题的联系
     *
     * @param nums 整型数组
     * @return 最大子序和
     */
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        //最大子序和的动态规划表
        int[] numsDp = new int[len];
        numsDp[0] = nums[0];
        int max = numsDp[0];
        for (int i = 1; i < len; i++) {
            //如果前一个最大子序和小于零，则当前最大子序和不包括前一个最大子序和。
            numsDp[i] = nums[i] + (Math.max(numsDp[i - 1], 0));
            max = Math.max(max, numsDp[i]);
        }
        return max;
    }

    /**
     * 无需动态规划
     *
     * @param nums 数组
     * @return 最大子和
     */
    public static int maxSubArray2(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;

            if (sum > maxSum) {
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }

        }
        return maxSum;
    }
}
