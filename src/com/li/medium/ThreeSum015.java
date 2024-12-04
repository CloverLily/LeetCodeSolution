package com.li.medium;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j],
 * nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 *
 * 提示：
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 */
public class ThreeSum015 {

    public static void main(String[] args) {
        int[][] nums = {
                {-1,0,1,2,-1,-4,-2,-3,3,0,4},//[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
                {-1,0,1,2,-1,-4},//[[-1,-1,2],[-1,0,1]]
                {0,1,1},//[]
                {0,0,0},//[[0,0,0]]
                {-2,0,0,2,2}//[[-2,0,2]]
        };
        for (int[] num : nums) {
            List<List<Integer>> resList = threeSumOfficial(num);
//            List<List<Integer>> resList = threeSum(num);
            System.out.print("[");
            for (List<Integer> res : resList) {
                System.out.print("[");
                for (Integer r : res) {
                    System.out.print(r + " ");
                }
                System.out.print("],");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    /**
     * 官方：排序+去重+遍历
     * time:O(N2), space:O(logN)
     */
    public static List<List<Integer>> threeSumOfficial(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int target = -nums[first];
            int third = n - 1;
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && (nums[second] + nums[third]) > target) {
                    third--;
                }

                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return res;
    }

    /**
     * 原创：遍历+两数之和
     * time:O(N2), space:O(N)
     *
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return resList;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            int sum;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                    while (k > j && nums[k + 1] == nums[k]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                    while (j < n && nums[j - 1] == nums[j]) {
                        j++;
                    }
                } else {
                    resList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    while (k > j && nums[k + 1] == nums[k]) {
                        k--;
                    }

                    j++;
                    while (j < n && nums[j - 1] == nums[j]) {
                        j++;
                    }
                }
            }
        }
        return resList;
    }
}
