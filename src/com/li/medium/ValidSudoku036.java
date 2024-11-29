package com.li.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *     Each row must contain the digits 1-9 without repetition.
 *     Each column must contain the digits 1-9 without repetition.
 *     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 *     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *     Only the filled cells need to be validated according to the mentioned rules.
 *
 * Example 1:
 * Input: board =
 * [['5','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: true
 *
 * Example 2:
 * Input: board =
 * [['8','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * Constraints:
 *     board.length == 9
 *     board[i].length == 9
 *     board[i][j] is a digit 1-9 or '.'.
 *
 * 36. 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *  1.数字 1-9 在每一行只能出现一次。
 *  2.数字 1-9 在每一列只能出现一次。
 *  3.数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 *
 * 示例 1：
 * 输入：board =
 * [
 *  ["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出：true
 *
 * 示例 2：
 * 输入：board =
 * [
 *  ["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *
 *
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 *
 */
public class ValidSudoku036 {

    public static void main(String[] args) {
        char[][][] boards = {
                {
                        {'.', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                },//true
                {
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }//false
        };
        for (char[][] board : boards) {
            System.out.println(isValidSudoku(board));
        }
    }

    /**
     * 官方一次遍历
     * time:O(N2),space:O(1)
     */
    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] square = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    row[i][index]++;
                    column[j][index]++;
                    square[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || column[j][index] > 1 || square[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 原始
     * time:O(N2),space:O(N2)
     */
    public static boolean isValidSudokuOrigin(char[][] board) {
        int len = board.length;
        int rowLen = board[0].length;

        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<String, Set<Character>> squareGridsMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < rowLen; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                //对比行
                if (rowSet.contains(board[i][j])) {
                    return false;
                }
                rowSet.add(board[i][j]);

                //对比列
                if (columnMap.containsKey(j)) {
                    if (columnMap.get(j).contains(board[i][j])) {
                        return false;
                    }

                    Set<Character> columnSet = columnMap.get(j);
                    columnSet.add(board[i][j]);
                    columnMap.put(j, columnSet);
                } else {
                    Set<Character> columnSet = new HashSet<>();
                    columnSet.add(board[i][j]);
                    columnMap.put(j, columnSet);
                }

                //对比3宫格
                int gridRow = i / 3;
                int gridColumn = j / 3;
                String gridIndex = new StringBuffer().append(gridRow).append(gridColumn).toString();
                if (squareGridsMap.containsKey(gridIndex)) {
                    if(squareGridsMap.get(gridIndex).contains(board[i][j])){
                        return false;
                    }

                    Set<Character> squareSet = squareGridsMap.get(gridIndex);
                    squareSet.add(board[i][j]);
                    squareGridsMap.put(gridIndex, squareSet);
                } else {
                    Set<Character> squareSet = new HashSet<>();
                    squareSet.add(board[i][j]);
                    squareGridsMap.put(gridIndex, squareSet);
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuOld(char[][] board) {

        int raws = board.length;
        int columns = board[0].length;

        //每一行每个数字的个数
        boolean[][] rawsNum = new boolean[9][9];
        //每一列每个数字的个数
        boolean[][] columnNum = new boolean[9][9];
        //每一个九宫格每个数字的个数
        boolean[][][] subBoardNum = new boolean[3][3][9];

        int index;
        for (int i = 0; i < raws; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                index = board[i][j] - '0' - 1;
                if (rawsNum[i][index]) {
                    return false;
                } else {
                    rawsNum[i][index] = true;
                }

                if (columnNum[index][j]) {
                    return false;
                } else {
                    columnNum[index][j] = true;
                }

                if (subBoardNum[i / 3][j / 3][index]) {
                    return false;
                } else {
                    subBoardNum[i / 3][j / 3][index] = true;
                }

            }
        }

        return true;

    }

}
