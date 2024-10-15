package Assignment3;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int[] wt = {3, 2, 5};
        int[] val = {30, 40, 60};

        System.out.println(tabulation(wt.length, 6, wt, val));
    }

    private static int tabulation(int n, int maxWeight, int[] wt, int[] val) {
        int[][] dp = new int[n][maxWeight + 1];
        for(int[] dpRow : dp) Arrays.fill(dpRow, 0);

        for(int i = wt[0]; i <= maxWeight; i++) dp[0][i] = val[0];

        for(int ind = 1; ind < n; ind++) {
            for(int W = 0; W <= maxWeight; W++) {
                int notTake = dp[ind - 1][W];
                int take = Integer.MIN_VALUE;

                if(wt[ind] <= W) take = val[ind] + dp[ind - 1][W - wt[ind]];

                dp[ind][W] = Math.max(notTake, take);
            }
        }

        return dp[n - 1][maxWeight];
    }
}
