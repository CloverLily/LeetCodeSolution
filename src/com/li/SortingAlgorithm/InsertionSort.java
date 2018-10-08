package com.li.SortingAlgorithm;

/**
 * 插入排序
 * 量级小于千，那么插入排序还是一个不错的选择。
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {//类似抓扑克牌排序
            //右手抓到一张牌
            int get = arr[i];
            //拿在左手上的牌总是排序好的
            int j = i - 1;
            while (j >= 0 && arr[j] > get) {// 将抓到的牌与手牌从右向左进行比较
                arr[j + 1] = arr[j];// 如果该手牌比抓到的牌大，就将其右移
                j--;
            }
            arr[j + 1] = get;// 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
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
            //右手抓到一张牌
            int get = arr[i];
            // 拿在左手上的牌总是排序好的，所以可以用二分法
            int left = 0;
            //手牌左右边界进行初始化
            int right = i - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] > get)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }
            arr[left] = get;
        }

        System.out.println("二分插入排序结果：");
        for (int item : arr) {
            System.out.print(item + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 4, 7, 8, 1, 0, 9, 5};
        binaryInsertionSort(arr);
    }
}