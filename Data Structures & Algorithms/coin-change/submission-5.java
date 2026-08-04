class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        for(int[] d: dp) {
            Arrays.fill(d, -2);
        }
    
        int res = recWithIdx(coins,0, amount);
        System.out.println(Arrays.deepToString(dp));
        return res==Integer.MAX_VALUE ? -1 : res;
    }

    //take dont take type

    // int rec(int[] arr, int amt) {
    //     if(amt<0) return Integer.MAX_VALUE;

    //     if(amt==0) return 0;

    //     if(dp[amt]!=-2) return dp[amt];

    //     int res = Integer.MAX_VALUE;

    //     for(int ct: arr) {
    //         int take = rec(arr, amt-ct);
    //         if(take!=Integer.MAX_VALUE) res = Math.min(res, take+1);
    //     }

    //     return dp[amt] = res;
    // }

    int recWithIdx(int[] arr, int idx, int amt) {
        if(amt<0) return Integer.MAX_VALUE;
        if(idx>=arr.length) return Integer.MAX_VALUE;

        if(amt==0) return 0;
        if(dp[idx][amt]!=-2) return dp[idx][amt];

        int take = recWithIdx(arr, idx, amt-arr[idx]);
        if(take!=Integer.MAX_VALUE) take+=1;
        int skip = recWithIdx(arr, idx+1, amt);

        return dp[idx][amt]=Math.min(take, skip);

    }
}
