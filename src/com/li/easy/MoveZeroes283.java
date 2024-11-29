package com.li.easy;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class MoveZeroes283 {

    public static void main(String[] args) {
        int[][] nums = {
                {3, 1, 0, 4, 12},
                {0, 1, 0, 3, 12},//[1,3,12,0,0]
                {0}//[0]
        };
        for (int[] num : nums) {
            System.out.print("[");
            moveZeroesOfficial(num);
            for (int i : num) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * 官方：双指针
     * time:O(N),space: O(1)
     */
    public static void moveZeroesOfficial(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while (left < n) {
            nums[left] = 0;
            left++;
        }
    }

}
