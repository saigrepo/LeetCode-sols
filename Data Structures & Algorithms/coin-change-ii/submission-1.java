class Solution {
    int ct=0;
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        Arrays.sort(coins);
        for(int[] d: dp)  Arrays.fill(d, -1);
        return dfs(amount, coins,0, dp);
        //return this.ct;
    }

    //dfs when amt==0 count 1

    int dfs(int amt, int[] coins, int stIdx, int[][] dp) {
        if(amt==0) {
            return 1;
        }

        if(dp[amt][stIdx]!=-1) return dp[amt][stIdx];

        int count=0;
        for(int i=0;i<coins.length;i++) {
            if(i<stIdx) continue;
            int upamt = amt - coins[i];
            if(upamt>=0) {
                count += dfs(upamt, coins, i, dp);
            }
        }

        return dp[amt][stIdx] = count;
    }
}
