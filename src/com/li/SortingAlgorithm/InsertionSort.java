package com.li.SortingAlgorithm;

/**
 * 插入排序
 * 量级小于千，那么插入排序还是一个不错的选择。
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int get = arr[i];
            int j = i - 1;
            while (j >= 0 && get < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = get;
        }

        System.out.println("插入排序结果：");
        for (int item : arr) {
            System.out.print(item + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 4, 7, 8, 1, 0, 9, 5};
        insertionSort(arr);
    }
}

/**
 * 插入排序优化：
 * 二分插入排序
 */
class BinaryInsertionSort {
    public static void binaryInsertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int get = arr[i];
            j = binarySearch(arr, 0, j, get);


        }
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        int index = 0;
        if (left == right) {
            index = arr[left] > target ? (left - 1) : (left + 1);
        }


        for (int mid = right / 2; mid >= 0; mid /= 2) {
            if (arr[mid] > target)
                binarySearch(arr, left, mid - 1, target);
        }

        return index;
    }

}