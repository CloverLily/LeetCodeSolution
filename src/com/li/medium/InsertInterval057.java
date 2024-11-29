package com.li.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，
 * 其中 intervals[i] = [STARTi, ENDi] 表示第 i 个区间的开始和结束，并且 intervals 按照 STARTi 升序排列。
 * 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 STARTi 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * 返回插入之后的 intervals。
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 提示：
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= STARTi <= ENDi <= 10^5
 * intervals 根据 STARTi 按 升序 排列
 * newInterval.length == 2
 * 0 <= start <= end <= 10^5
 */
public class InsertInterval057 {
    public static void main(String[] args) {
        int[][][] intervals = {
                {
                        {1, 5}
                },//[[1,7]]
                {},//[[5,7]]
                {
                        {1, 3},
                        {6, 9}
                },//[[1,5],[6,9]]
                {
                        {1, 2},
                        {3, 5},
                        {6, 7},
                        {8, 10},
                        {12, 16}
                }//[[1,2],[3,10],[12,16]]
        };
        int[][] newInterval = {
                {2, 7},
                {5, 7},
                {2, 5},
                {4, 8}
        };
        for (int i = 0; i < intervals.length; i++) {
            int[][] resArr = insert(intervals[i], newInterval[i]);
            System.out.print("[");
            for (int[] res : resArr) {
                System.out.print("[");
                for (int s : res) {
                    System.out.print(s + " ");
                }
                System.out.print("]");
            }
            System.out.println("]");
        }
    }

    /**
     * 自解：一次遍历
     * time:O(N), space:O(1)
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> mergeList = new ArrayList<>();
        boolean isInsert = false;
        int left = intervals[0][0];
        int right = intervals[0][1];
        if (newInterval[0] <= left) {
            left = newInterval[0];
            right = newInterval[1];
            isInsert = true;
        }

        for (int i = 0; i < n; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if (!isInsert && newInterval[0] < x) {
                x = newInterval[0];
                y = newInterval[1];
                isInsert = true;
                i--;
            }

            if (x >= left && x <= right) {
                right = Math.max(right, y);
            } else if (x > right) {
                mergeList.add(new int[]{left, right});
                left = x;
                right = y;
            }

            if (i == n - 1) {
                if (isInsert) {
                    mergeList.add(new int[]{left, right});
                } else {
                    x = newInterval[0];
                    y = newInterval[1];
                    if (x >= left && x <= right) {
                        right = Math.max(right, y);
                        mergeList.add(new int[]{left, right});
                    } else if (x > right) {
                        mergeList.add(new int[]{left, right});
                        mergeList.add(new int[]{x, y});
                    }
                }
            }
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
