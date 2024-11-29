package com.li.medium;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * 请不要 使用另一个矩阵来旋转图像。
 *
 * 示例 1：
 * 输入：matrix = [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ]
 * 输出：[
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 *
 * 示例 2：
 * 输入：matrix = [
 * [ 5, 1, 9, 11],
 * [ 2, 4, 8, 10],
 * [13, 3, 6,  7],
 * [15,14,12, 16]
 * ]
 * 输出：[
 * [15, 13, 2, 5],
 * [14, 3,  4, 1],
 * [12, 6,  8, 9],
 * [16, 7, 10, 11]
 * ]
 *
 *
 * 提示：
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage048 {

    public static void main(String[] args) {
        int[][][] matrixes = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },//[[7,4,1],[8,5,2],[9,6,3]]
                {
                        {5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16}
                }//[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        };

        for (int[][] matrix : matrixes) {
            rotate(matrix);
            for (int[] ints : matrix) {
                System.out.print("[");
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(ints[j] + " ");
                }
                System.out.println("]");
            }
        }
    }

    /**
     * 官方：二次翻转：沿水平线翻转 + 沿对角线翻转
     *  time:O(N2), space:O(1)
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                temp = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
