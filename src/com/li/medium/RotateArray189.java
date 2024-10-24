package com.li.medium;


/**
 * 189. 轮转数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 *
 * 进阶：
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class RotateArray189 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;

        int[] nums = {-1, -100, 3, 99};
        int k = 2;

        rotate(nums, k);
//        rotate1(nums, k);
        for (int m = 0; m < nums.length; m++) {
            System.out.print(nums[m] + " ");
        }
    }

    /**
     * 新建数组处理，在复制到原数组
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums 数组
     * @param k 轮转步数
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k == 0 || n == 1) {
            return;
        }

        int[] tmpArr = new int[n];
        for (int i = 0; i < n; i++) {
            tmpArr[(i + k) % n] = tmpArr[i];
        }

        System.arraycopy(tmpArr, 0, nums, 0, n);
    }

    /**
     * 在原数组上操作
     * 双倍翻转
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public static void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;

            start += 1;
            end -= 1;
        }
    }
}
