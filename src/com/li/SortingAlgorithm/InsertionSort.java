package com.li.SortingAlgorithm;

/**
 * 插入排序
 * 量级小于千，那么插入排序还是一个不错的选择。
 */
public class InsertionSort {

    public static final int[] arr = {3, 2, 6, 4, 7, 8, 1, 0, 9, 5};

    private static void insertionSort(int[] arr) {
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
        insertionSort(InsertionSort.arr);
    }
}

/**
 * 插入排序优化：
 * 二分插入排序
 */
class BinaryInsertionSort {
    private static void binaryInsertionSort(int[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            //右手抓到一张牌
            int get = arr[i];
            // 拿在左手上的牌总是排序好的，所以可以用二分法
            int left = 0;
            //手牌左右边界进行初始化
            int right = i - 1;
            while (left <= right) {// 采用二分法定位新牌的位置:left
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
        binaryInsertionSort(InsertionSort.arr);
    }
}

/**
 * 插入排序的更高效改进：
 * 希尔排序(Shell Sort)
 */
class ShellSort {
    /**
     * 分类 -------------- 内部比较排序
     * 数据结构 ---------- 数组
     * 最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
     * 最优时间复杂度 ---- O(n)
     * 平均时间复杂度 ---- 根据步长序列的不同而不同。
     * 所需辅助空间 ------ O(1)
     * 稳定性 ------------ 不稳定
     */

    private static void shellSort(int[] arr) {
        int len = arr.length;
        int h = 0;

        while (h <= len) {//生成初始增量
            h = 3 * h + 1;
        }

        while (h >= 1) {//插入排序
            for (int i = h; i < len; i++) {
                int j = i - h;//从右向左比较
                int get = arr[i];//拿到一张牌
                while (j >= 0 && arr[j] > get) {
                    arr[j + h] = arr[j];
                    j = j - h;//依次与向左相隔距离h的数值进行比较
                }
                arr[j + h] = get;
            }
            h = (h - 1) / 3;//递减增量
        }

        System.out.println("希尔排序结果");
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        shellSort(InsertionSort.arr);
    }
}