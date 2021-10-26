package com.li.easy;

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class _088MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int[] nums2 = {3};
        merge(nums1, 5, nums2, nums2.length);
        //merge2(nums1, 5, nums2, nums2.length);

        for (int i : nums1) {
            System.out.print(i + ",");
        }
    }

    /**
     * 2.反向排序，从右向左，先排大数
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;

        //分别存放指针m,n目前所指的值
        int num1, num2;
        while (m >= 0 || n >= 0) {
            num1 = m >= 0 ? nums1[m] : Integer.MIN_VALUE;
            num2 = n >= 0 ? nums2[n] : Integer.MIN_VALUE;
            if (num1 > num2) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }
    }

    /**
     * 1.正向排序，从左向右
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //把nums1中的数据移到数组尾端
        for (int k = nums1.length - 1, q = m - 1; k >= (nums1.length - m); k--) {
            nums1[k] = nums1[q--];
        }

        //nums1中的元素指针i,nums2中的元素指针j，处理后nums1的指针p
        int i = n, j = 0, p = 0;
        for (; i < (m + n) && j < n; ) {
            if (nums1[i] < nums2[j]) {
                nums1[p++] = nums1[i++];

            } else if (nums1[i] > nums2[j]) {
                nums1[p++] = nums2[j++];
            } else {
                nums1[p++] = nums1[i++];
                nums1[p++] = nums2[j++];
            }
        }

        while (j < n) {
            nums1[p++] = nums2[j++];
        }
    }
}
