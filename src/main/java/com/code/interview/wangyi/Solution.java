package com.code.interview.wangyi;

/**
 * @author markingWang
 * @date 2021/10/18 7:55 下午
 */
public class Solution {

    public long maxProfit(int[] profit) {
        int maxProfit = 0;
        int currentMinProfit = Integer.MAX_VALUE;
        for (int i = 0; i < profit.length; i++) {
            if (currentMinProfit > profit[i]) {
                currentMinProfit = profit[i];
            }

            if (profit[i] - currentMinProfit > maxProfit) {
                maxProfit = profit[i] - currentMinProfit;
            }
        }

        return maxProfit;
    }
}
