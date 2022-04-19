package com.li.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 73. 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * @author kang
 */
public class SetMatrixZeroes073 {

    public static void main(String[] args) {
        int[][] matrix0 = {{1, 0}};
        int[][] matrix = {{0, 2, 3}, {4, 0, 6}};
        int[][] matrix2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {0,10,11,12},
                {13,14,15,0}};
        int[][] matrix4 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        int[][] matrix5 = {
                {-4,-2147483648, 6,-7,  0},
                {-8,          6,-8,-6,  0},
                {2147483647,  2,-9,-6,-10}};

//        setZeroes0(matrix2);
//        setZeroes1(matrix4);
        setZeroes2(matrix5);

        for (int[] row : matrix5) {
            for (int num : row) {
                System.out.print(num);
                System.out.print(",");
            }
            System.out.println();
        }

    }

    /**
     * O(1)额外空间
     * 第一列左上角用于标记行是否为0, 第二列用于标记列是否为0
     *
     * @param matrix 待置零数组
     */
    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean column0Flag = false;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                column0Flag =true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(column0Flag){
                matrix[i][0] = 0;
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
