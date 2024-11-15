package com.li.medium;

import java.util.*;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [STARTi, ENDi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * 提示：
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= STARTi <= ENDi <= 10^4
 */
public class MergeIntervals056 {

    public static void main(String[] args) {
        int[][][] intervals = {
                {
                        {2,3},
                        {4,6},
                        {5,7},
                        {3,4}
                },//[[2,7]]
                {
                        {2, 3},
                        {4, 5},
                        {6, 7},
                        {8, 9},
                        {1, 10}
                },//[[1,10]]
                {
                        {2, 3},
                        {5, 5},
                        {2, 2},
                        {3, 4},
                        {3, 4}
                },//[[2,4],[5,5]]
                {
                        {1, 4},
                        {1, 5}
                },//[[1,5]]
                {
                        {1, 4},
                        {0, 4}
                },//[[0,4]]
                {
                        {1, 3},
                        {2, 6},
                        {8, 10},
                        {15, 18}
                },//[[1,6],[8,10],[15,18]]
                {
                        {1, 4},
                        {4, 5}
                }//[[1,5]]
        };
        for (int[][] interval : intervals) {
            int[][] res = merge(interval);
            System.out.print("[");
            for (int[] num : res) {
                System.out.print("[");
                for (int i : num) {
                    System.out.print(i + " ");
                }
                System.out.print("]");
            }
            System.out.println("]");

        }
    }

    /**
     * 官方：排序 + 一次遍历
     * time:O(NlogN) , space: O(logN)
     */
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) {
            return intervals;
        }

        List<int[]> mergeList = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if (x >= left && x <= right) {
                right = Math.max(right, y);
            } else if (x > right) {
                mergeList.add(new int[]{left, right});
                left = x;
                right = y;
            }
            if (i == n - 1) {
                mergeList.add(new int[]{left, right});
            }
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
