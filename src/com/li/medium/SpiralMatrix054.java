package com.li.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 * 示例 1：
 * 输入：matrix = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix054 {
    public static void main(String[] args) {
        int[][][] matrixs = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },//[1,2,3,6,9,8,7,4,5]
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                },//[1,2,3,4,8,12,11,10,9,5,6,7]
        };
        for(int[][] matrix : matrixs){
            List<Integer> res = spiralOrder(matrix);
            System.out.print("[");
            for(int t:res){
                System.out.print(t + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * 原创: 按逻辑顺时针遍历
     * time:O(m*n), space:O(1)
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int amount = m * n;
        List<Integer> resList = new ArrayList<>(amount);
        int i = 0;
        int j = 0;
        String moveAction = "RIGHT";
        int cnt = 0;
        int iMin = 0;
        int jMin = 0;
        int iMax = m - 1;
        int jMax = n - 1;
        while (cnt < amount) {
            resList.add(matrix[i][j]);
            cnt++;
            switch (moveAction) {
                case "RIGHT":
                    if (j == jMax) {
                        iMin++;
                        moveAction = "DOWN";
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case "LEFT":
                    if (j == jMin) {
                        iMax--;
                        moveAction = "UP";
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case "UP":
                    if (i == iMin) {
                        jMin++;
                        moveAction = "RIGHT";
                        j++;
                    } else {
                        i--;
                    }
                    break;
                case "DOWN":
                    if (i == iMax) {
                        jMax--;
                        moveAction = "LEFT";
                        j--;
                    } else {
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
        return resList;
    }
}
