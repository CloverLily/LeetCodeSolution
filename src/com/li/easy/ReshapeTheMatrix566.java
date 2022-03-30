package com.li.easy;

/**
 * 566. 重塑矩阵
 *
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 *
 * 示例 1：
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 *
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 *
 *
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 *
 * @author kang
 */
public class ReshapeTheMatrix566 {

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};

        int[][] res = matrixReshape(mat, 1, 4);

        for (int[] x : res) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[][] reshapeMat = new int[r][c];

        int x = 0;
        int y = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (y == n) {
                    x++;
                    y = 0;
                }
                reshapeMat[i][j] = mat[x][y++];
            }
        }

        return reshapeMat;
    }

}
