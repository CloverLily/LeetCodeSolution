package com.li.SortingAlgorithm;

/**
 * 冒泡排序
 * 适用于少数元素的排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
        System.out.println("冒泡排序结果：");
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    /**
     * 交换数组中任意两个位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3, 4, 5};
        bubbleSort(arr);
    }
}

/**
 * 冒泡排序的改进：鸡尾酒排序(定向冒泡排序)
 */
class CocktailSort {
    public static void cocktailSort(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            //从前往后遍历（除去已排序位置），大数往后冒
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            right--;
            //从后往前遍历（除去已排序位置），小数往前冒
            for (int j = right; j > left; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
            left++;
        }

        System.out.println("定向冒泡排序结果：");
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    /**
     * 交换数组中i,j位置元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {16, 2, 3, 6, 1, 9};
        cocktailSort(arr);
    }

}