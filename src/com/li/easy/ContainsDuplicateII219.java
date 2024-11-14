package com.li.easy;

import java.util.*;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 *
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 0 <= k <= 10^5
 */
public class ContainsDuplicateII219 {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 1},//true
                {1, 0, 1, 1},//true
                {1, 2, 3, 1, 2, 3}//false
        };
        int[] k = {3, 1, 2};
        for (int i = 0; i < k.length; i++) {
//            System.out.println(containsNearbyDuplicate(nums[i], k[i]));
            System.out.println(containsNearbyDuplicateOfficial(nums[i], k[i]));
        }
    }

    /**
     * 官方：滑动窗口
     * time:O(N), space:O(K)
     */
    public static boolean containsNearbyDuplicateOfficial(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        Set<Integer> windowNum = new HashSet<>(k);
        for (int i = 0; i < n; i++) {
            if (i > k) {
                windowNum.remove(nums[i - k - 1]);
            }
            if (!windowNum.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 自解：索引映射表
     * time:O(N), space: O(N)
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (numMap.containsKey(nums[i]) && (i - numMap.get(nums[i])) <= k) {
                return true;
            }
            numMap.put(nums[i], i);
        }
        return false;
    }
}
