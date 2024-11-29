package com.li.medium;

/**
 * 289. 生命游戏
 * 根据百度百科， 生命游戏 ，简称为生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 1.如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 2.如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 3.如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 4.如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * 给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 *
 * 示例 1：
 * 输入：board = [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * 输出：[
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 *
 * 示例 2：
 * 输入：board = [
 * [1,1],
 * [1,0]
 * ]
 * 输出：[
 * [1,1],
 * [1,1]
 * ]
 *
 *
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] 为 0 或 1
 *
 *
 * 进阶：
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：
 * 你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。
 * 原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。
 * 你将如何解决这些问题？
 */
public class GameOfLife289 {

    public static void main(String[] args) {
        int[][][] boards = {
                {
                        {0, 1, 0},
                        {0, 0, 1},
                        {1, 1, 1},
                        {0, 0, 0}
                },
                {
                        {1, 1},
                        {1, 0}
                }
        };
        for (int[][] board : boards) {
            gameOfLife(board);
            System.out.println("[");
            for(int[] row : board){
                for(int col : row){
                    System.out.print(col + " ");
                }
                System.out.println();
            }
            System.out.println("]");
        }
    }

    /**
     * 官方：原地+复合状态。
     * time:O(MN), space:O(1)
     */
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCnt = 0;

                for (int k = -1; k < 2; k++) {
                    for (int t = -1; t < 2; t++) {
                        if (k == 0 && t == 0) {
                            continue;
                        }
                        int nbI = k + i;
                        int nbJ = t + j;
                        if (nbI >= 0 && nbI < m && nbJ >= 0 && nbJ < n
                                && (board[nbI][nbJ] == 1 || board[nbI][nbJ] == -1)) {
                            liveCnt++;
                        }
                    }
                }

                //规则4
                if (board[i][j] == 0 && liveCnt == 3) {
                    board[i][j] = 2;
                }

                //规则1、3
                if (board[i][j] == 1 && (liveCnt < 2 || liveCnt > 3)) {
                    board[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

}
