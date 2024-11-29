package com.li.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 * 输入：matrix = [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：[
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 *
 * 示例 2：
 * 输入：matrix = [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]]
 * 输出：[
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]]
 *
 *
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 *
 * 进阶：
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 */
public class SetMatrixZeroes073 {

    public static void main(String[] args) {
        int[][][] matrixArr = {
                {
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                },//[[1,0,1],[0,0,0],[1,0,1]]
                {
                        {0, 1, 2, 0},
                        {3, 4, 5, 2},
                        {1, 3, 1, 5}
                }//[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        };
        for (int[][] matrix : matrixArr) {
//            setZeroes(matrix);
            setZeroesOfficial(matrix);
            System.out.println("[");
            for (int[] row : matrix) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            System.out.println("]");
        }
    }

    /**
     * 官方：第一列标识是否赋0，但刷新时需要行倒序以防止(0,0)被提前覆盖。
     * time:O(MN), space:O(1)
     */
    public static void setZeroesOfficial(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean column0 = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                column0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (column0) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * 自解：遍历找出0的index，再依次置零。
     * time:O(MN), space:O(MN)
     */
    public static void setZeroes(int[][] matrix) {
        Map<Integer, List<Integer>> zeroMap = new HashMap<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> columnList = zeroMap.getOrDefault(i, new ArrayList<>());
                    columnList.add(j);
                    zeroMap.put(i, columnList);
                }
            }
        }

        if (zeroMap.isEmpty()) {
            return;
        }

        for (Map.Entry<Integer, List<Integer>> entrySet : zeroMap.entrySet()) {
            for (int j = 0; j < n; j++) {
                matrix[entrySet.getKey()][j] = 0;
            }
            List<Integer> columnList = entrySet.getValue();
            for (int column : columnList) {
                for (int i = 0; i < m; i++) {
                    matrix[i][column] = 0;
                }
            }
        }
    }

    /**
     * O(m + n)额外空间
     *
     * @param matrix 待置零数组
     */
    public static void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row0Flag = false;
        boolean column0Flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {

                    if (i == 0) {
                        column0Flag = true;
                    }

                    if (j == 0) {
                        row0Flag = true;
                    }

                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0Flag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (column0Flag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

    }

    /**
     * O(m*n)额外空间
     * 遍历记录零的位置+遍历置零
     * @param matrix 待置零数组
     */
    public static void setZeroes0(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Point> zeroPointList = new ArrayList<>(m*n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroPointList.add(new Point(i, j));
                }
            }
        }

        if(zeroPointList.isEmpty()){
            return;
        }

        for(Point point: zeroPointList){
            setPointZeroes(matrix, point);
        }

    }

    /**
     * 某个位置为零时行列置零
     * @param matrix 数组
     * @param point 0的二维索引位置
     */
    private static void setPointZeroes(int[][] matrix, Point point) {
        if (matrix == null || point == null) {
            return;
        }

        //数组行数
        int m = matrix.length;
        //数组列数
        int n = matrix[0].length;

        if (point.getRowIndex() >= m || point.getColumnIndex() >= n) {
            return;
        }

        for (int i = 0; i < m; i++) {
            matrix[i][point.getColumnIndex()] = 0;
        }

        for (int j = 0; j < n; j++) {
            matrix[point.getRowIndex()][j] = 0;
        }

    }

    private static class Point {
        /**
         * 二维横坐标
         */
        int rowIndex;
        /**
         * 二维纵坐标
         */
        int columnIndex;

        public Point(int rowIndex, int columnIndex){
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }

        private int getRowIndex(){
            return this.rowIndex;
        }

        private int getColumnIndex(){
            return this.columnIndex;
        }


    }


}
