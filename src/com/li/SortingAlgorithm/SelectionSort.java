package com.li.SortingAlgorithm;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            //当前最小值所在索引
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
        }

        System.out.println("选择排序结果：");
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 6, 9, 3, 1, 4, 0, 7};
        selectionSort(arr);
    }

}
