package com.li.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 提示：
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class LongestConsecutiveSequence128 {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 0, 1},//3
                {100, 4, 200, 1, 3, 2},//4
                {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}//9
        };
        for (int[] num : nums) {
//            System.out.println(longestConsecutive(num));
            System.out.println(longestConsecutiveOfficial(num));
        }
    }

    /**
     * 官方：哈希集合
     * time:O(N), space:O(N)
     */
    public static int longestConsecutiveOfficial(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestLen = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                }
                longestLen = Math.max(longestLen, currentNum - num + 1);
            }
        }
        return longestLen;
    }

    /**
     * 自解：排序
     * time:O(NlogN), space:O(N)
     */
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        Arrays.sort(nums);
        int maxSubLen = 0;
        int subLen = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                subLen++;
            } else if (nums[i] > nums[i - 1] + 1) {
                subLen = 0;
            }
            maxSubLen = Math.max(subLen, maxSubLen);
        }
        return maxSubLen + 1;
    }
}
