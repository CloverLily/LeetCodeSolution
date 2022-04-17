package com.li.medium;

/**
 * 73. 矩阵置零 TODO
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
        setZeroes(matrix0);

        for (int[] row : matrix0) {
            for (int num : row) {
                System.out.print(num);
                System.out.print(",");
            }
            System.out.println();
        }

    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    setZeroes(matrix, i, j);
                }
            }
        }

//        int i = 0;
//        int j = 0;
//        while (i < m && j < n) {
//            if (matrix[i][j] == 0) {
//                setZeroes(matrix, i, j);
//            }
//
//            i++;
//            j++;
//        }

    }

    /**
     * 某个位置为零时行列置零
     * @param matrix 数组
     * @param rowIndex 为0的行索引
     * @param colIndex 为0的列索引
     */
    private static void setZeroes(int[][] matrix, int rowIndex, int colIndex) {
        if (matrix == null) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        if (rowIndex >= m || colIndex >= n) {
            return;
        }

        for (int k = 0; k < m; k++) {
            if (matrix[k][colIndex] != 0) {
                matrix[k][colIndex] = 0;
            } else if (k > rowIndex) {
                setZeroes(matrix, k, colIndex);
            }
        }

        for (int q = 0; q < n; q++) {
            if (matrix[rowIndex][q] != 0) {
                matrix[rowIndex][q] = 0;
            } else if (q > colIndex) {
                setZeroes(matrix, rowIndex, q);
            }
        }

    }


}
