package com.li.common;

/**
 * 二分查找
 * @author system
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @param srcArray 已排序的数组
     * @param target   要查找的目标数
     * @return 目标数在数组中的索引位置
     */
    private static int binarySearch(int[] srcArray, int target) {
        //定义索引初始左右边界
        int left = 0;
        int right = srcArray.length - 1;
        //确保不会出现重复查找、越界
        while (left <= right) {
            //计算中间索引值
            int middle = (left + right) >>> 1;
            if (srcArray[middle] == target) {
                return middle;
                //判断下限
            } else if (srcArray[middle] > target) {
                right = middle - 1;
            } else {//判断上限
                left = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        //正常情况
        System.out.println(binarySearch(arr, 4));
        //非正常情况
        System.out.println(binarySearch(arr, 9));
        //边界情况
        System.out.println(binarySearch(arr, 6));
    }
}
