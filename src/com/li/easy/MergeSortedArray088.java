package com.li.easy;

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @author system
 */
public class MergeSortedArray088 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int[] nums2 = {3};
        merge(nums1, 5, nums2, nums2.length);
        //merge2(nums1, 5, nums2, nums2.length);
        merge3(nums1, 5, nums2, nums2.length);

        //测试 m=0, n=1
        int[] nums11 = {0};
        int[] nums22 = {1};
        merge3(nums11, 0, nums22, 1);

        for (int i : nums1) {
            System.out.print(i + ",");
        }
    }

    /**
     * 普通方法
     * 1.把nums1移到数组右侧
     * 2.对比
     *
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        //把所有nums1元素移到右侧
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }

        int k = 0;
        int i = nums1.length - m;
        int j = 0;
        while (k < nums1.length) {
            if (j >= n) {
                nums1[k] = nums1[i];
                i++;
                k++;
                continue;
            }

            if (i >= nums1.length) {
                nums1[k] = nums2[j];
                j++;
                k++;
                continue;
            }

            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums2[j];
                j++;
            } else {
                nums1[k] = nums1[i];
                i++;
            }
            k++;
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
