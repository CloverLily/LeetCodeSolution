package com.li.Easy;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class _26RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int arrLen = nums.length;
        int i = 0, j = 1;
        while (j < arrLen) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                j++;
            } else
                j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //删除之后数组的新长度
        int len = removeDuplicates(nums);
        System.out.println(len);
        //打印操作之后的非重复部分
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
