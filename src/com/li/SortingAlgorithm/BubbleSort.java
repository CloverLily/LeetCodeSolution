package com.li.SortingAlgorithm;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        int len = arr.length;

        for (int i = 0; i < len ; i++) {
            for (int j = len-1; j > i; j--) {
                if(arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }

        for(int item:arr){
            System.out.print(item+" ");
        }
    }

    /**
     * 交换数组中任意两个位置
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={3,1,2,3,4,5};
        bubbleSort(arr);
    }
}
