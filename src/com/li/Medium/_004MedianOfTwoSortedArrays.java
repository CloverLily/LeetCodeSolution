package com.li.Medium;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class _004MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {3};
        int[] nums2 = {-4, -3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mLen = nums1.length + nums2.length, midIndex;
        int[] mergeArr = new int[mLen];
        midIndex = mLen / 2;
        int i = nums1.length - 1, j = nums2.length - 1, index = mLen - 1;
        int num1, num2;
        while (index >= midIndex - 1 && (i >= 0 || j >= 0)) {
            num1 = (i < 0) ? Integer.MIN_VALUE : nums1[i];
            num2 = (j < 0) ? Integer.MIN_VALUE : nums2[j];
            if (num1 <= num2) {
                mergeArr[index--] = nums2[j--];
            } else {
                mergeArr[index--] = nums1[i--];
            }
        }

        double midNum;
        if (mLen % 2 == 0) {
            midNum = (double) (mergeArr[midIndex] + mergeArr[midIndex - 1]) / 2;
        } else {
            midNum = mergeArr[midIndex];
        }

        return midNum;
    }
}
