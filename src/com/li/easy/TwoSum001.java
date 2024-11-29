package com.li.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 提示
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
 *
 * @author system
 */
public class TwoSum001 {

    public static void main(String[] args) {
        int[][] nums = {
                {2, 7, 11, 15},//[0,1]
                {3, 2, 4},//[1,2]
                {3, 3},//[0,1]
        };
        int[] target = {9, 6, 6};
        for (int i = 0; i < target.length; i++) {
            int[] res = twoSumOri(nums[i], target[i]);
            System.out.print("[");
            for (int r : res) {
                System.out.print(r + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * 映射表
     * time:O(N),space:O(N)
     */
    public static int[] twoSumOri(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int numA = target - nums[i];
            if (indexMap.containsKey(numA)) {
                return new int[]{indexMap.get(numA), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
