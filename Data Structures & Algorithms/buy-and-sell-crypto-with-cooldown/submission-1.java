class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] d: dp) Arrays.fill(d, -1);
        return rec(prices, 0, 1, dp);
    }

    int rec(int[] prices, int idx, int isBuying, int[][] dp) {
        if(idx>=prices.length) return 0;

        if(dp[idx][isBuying]!=-1) return dp[idx][isBuying];

        int skip = rec(prices, idx+1, isBuying, dp);
        if(isBuying==1) {
            return dp[idx][isBuying] = Math.max(skip, rec(prices, idx+1, 0, dp) - prices[idx]);
        } else {
            return dp[idx][isBuying] =  Math.max(skip, rec(prices, idx+2, 1, dp) + prices[idx]);
        }
    }
}
