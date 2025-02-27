package com.li.medium;


/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组(子数组 是数组中连续的 非空 元素序列。)
 *  [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 */
public class MinimumSizeSubarraySum209 {

    public static void main(String[] args) {
        int[] targets = {
                213,
                7,
                4,
                11
        };
        int[][] nums = {
                {12,28,83,4,25,26,25,2,25,25,25,12},//8
                {2, 3, 1, 2, 4, 3},//2
                {1, 4, 4},//1
                {1, 1, 1, 1, 1, 1, 1, 1}//0
        };
        for (int i = 0; i < targets.length; i++) {
            System.out.println(minSubArrayLen(targets[i], nums[i]));
        }
    }

    /**
     * 官方：滑动窗口
     * time:O(N), space:O(1)
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int subSum = nums[0];
        int minCnt = n;
        while (left < n && right < n) {
            if (subSum < target) {
                right++;
                if (right < n) {
                    subSum += nums[right];
                }
            } else {
                minCnt = Math.min(minCnt, right - left + 1);
                subSum -= nums[left];
                left++;
            }
        }
        return minCnt;
    }
}
