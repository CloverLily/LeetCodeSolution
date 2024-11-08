package com.li.medium;


import java.util.Arrays;

/**
 * 274. H 指数
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，
 * 一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 *
 *
 *
 * 示例 1：
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 *
 * 示例 2：
 * 输入：citations = [1,3,1]
 * 输出：1
 *
 * 提示：
 *
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 *
 */
public class HIndex274 {

    public static void main(String[] args) {
        int[][] citations = {
                {3, 0, 6, 1, 5},//3
                {1, 3, 1}//1
        };
        for (int[] citation : citations) {
//            System.out.println(hIndex(citation));
            System.out.println(hIndexCountSort(citation));
        }
    }

    /**
     * 官方：计数排序
     * time:O(N), space:O(N)
     */
    public static int hIndexCountSort(int[] citations) {
        int n = citations.length;
        int[] counter = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                counter[n]++;
            } else {
                counter[citation]++;
            }
        }

        int total = 0;
        for (int j = n; j > 0; j--) {
            total += counter[j];
            if (total >= j) {
                return j;
            }
        }
        return 0;
    }

    /**
     * 原创：先排序再计算
     * time：O(nlogn), space: o(n)
     *
     */
    public static int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= (n - i)) {
                return n - i;
            }
        }
        return 0;
    }

}
