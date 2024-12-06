package com.li.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 提示：
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 */
public class SubarraySumEqualsK560 {

    public static void main(String[] args) {
        int[][] nums = {
                {-1, -1, 1},//1
                {1},//0
                {1, 1, 1},//2
                {1, 2, 3}//2
        };
        int[] k = {0, 0, 2, 3};
        for (int i = 0; i < nums.length; i++) {
            int count = subarraySumOfficial2(nums[i], k[i]);
//            int count = subarraySum(nums[i], k[i]);
            System.out.println(count);
        }
    }

    /**
     * 官方：前缀和 + 哈希表
     * time: O(N), space:O(N)
     */
    public static int subarraySumOfficial2(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int pre = 0;
        int count = 0;
        countMap.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (countMap.containsKey(pre - k)) {
                count += countMap.get(pre - k);
            }
            countMap.put(pre, countMap.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    /**
     * 官方：二次遍历
     * time：O(N2), space:O(1)
     */
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
