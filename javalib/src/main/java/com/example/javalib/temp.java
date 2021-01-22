package com.example.javalib;

public class temp {
    public static void main(String[] args) {
        new temp().maxProfit(new int[]{

                1,3, 0, 1, 5

        });
    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[][][] dp = new int[prices.length][2][2];
        int t1, t2, t3, t4, t5;
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][0][1] = 0;
        dp[0][1][1] = Integer.MIN_VALUE;

        for(int i = 1; i < prices.length; i++){
            dp[i][0][1] = dp[i - 1][1][0] + prices[i];
            dp[i][1][1] = Integer.MIN_VALUE;

            t1 = dp[i - 1][0][1];
            t2 = dp[i - 1][0][0];
            t3 = dp[i - 1][1][0] + prices[i];

            t4 = dp[i - 1][0][0] - prices[i];
            t5 = dp[i - 1][1][0];

            dp[i][0][0] = t1 > t2 ? (t1 > t3 ? t1 : t3) : (t2 > t3 ? t2 : t3);
            dp[i][1][0] = t4 > t5 ? t4 : t5;

        }

        int r1 = dp[prices.length - 1][0][0];
        int r2 = dp[prices.length - 1][0][1];

        return r1 > r2 ? r1 : r2;

    }
}
