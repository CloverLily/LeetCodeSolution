package com.li.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 提示:
 *     1 <= numRows <= 30
 *
 * @author kang
 */
public class PascalsTriangle118 {
    public static void main(String[] args) {

        List<List<Integer>> arrTriangle = generate(10);
        for (List<Integer> row : arrTriangle) {
            for (Integer num : row) {
                System.out.print(num);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    /**
     * f(x,y) = f(x-1,y-1) + f(x-1,y)
     *
     * @param numRows 行数
     * @return 杨辉三角数组
     */
    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> arrTriangle = new ArrayList<>(numRows);

        int[][] rowArr = new int[numRows][numRows];
        List<Integer> rowTriangle;
        for (int x = 1; x <= numRows; x++) {
            rowTriangle = new ArrayList<>(x);

            rowArr[x - 1][0] = 1;
            if (x != 1) {
                rowArr[x - 1][x - 1] = 1;
            }

            for (int y = 2; (y - 1) <= (x / 2); y++) {
                rowArr[x - 1][y - 1] = rowArr[x - 2][y - 2] + rowArr[x - 2][y - 1];
                if (2 * y != x + 1) {
                    rowArr[x - 1][x - y] = rowArr[x - 2][y - 2] + rowArr[x - 2][y - 1];
                }
            }

            for (int i = 0; i < x; i++) {
                rowTriangle.add(rowArr[x - 1][i]);
            }
            arrTriangle.add(rowTriangle);
        }
        return arrTriangle;
    }

}
