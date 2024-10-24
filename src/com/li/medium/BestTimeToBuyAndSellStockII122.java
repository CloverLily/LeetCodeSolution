package com.li.medium;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 *
 * 示例 1：
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
 * 最大总利润为 4 + 3 = 7 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 * 最大总利润为 4 。
 * 示例 3：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0。
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10^4
 * 0 <= prices[i] <= 10^4
 */
public class BestTimeToBuyAndSellStockII122 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};//7
//        int[] prices = {1,2,3,4,5};//4
//        int[] prices = {7, 6, 4, 3, 1};//0
        System.out.println(maxProfit1(prices));
    }

    /**
     * 贪心
     * time:O(N), space: O(1)
     */
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }

        int sumProfit = 0;
        int j = 1;
        while (j < n) {
            sumProfit += Math.max(0, prices[j] - prices[j-1]);
            j++;
        }
        return sumProfit;
    }

    /**
     * 初解
     * time:O(N), space: O(1)
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }

        int minPrice = prices[0];
        int sumProfit = 0;
        int profit = 0;
        int j = 1;
        while (j < n) {
            if (minPrice < prices[j] && (prices[j] - minPrice) >= profit) {
                profit = prices[j] - minPrice;
            } else {
                minPrice = prices[j];
                sumProfit += profit;
                profit = 0;
            }

            if (j == (n - 1) && profit != 0) {
                sumProfit += profit;
            }
            j++;
        }
        return sumProfit;
    }

}
