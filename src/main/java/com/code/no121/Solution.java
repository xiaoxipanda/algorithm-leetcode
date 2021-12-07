package com.code.no121;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }

        }
        return maxProfit;
    }


    public int maxProfit01(int[] prices){
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minProfit){
                minProfit = prices[i];
            }else if (prices[i] - minProfit > maxProfit){
                maxProfit = prices[i] - minProfit;
            }
        }
        return maxProfit;
    }

}
